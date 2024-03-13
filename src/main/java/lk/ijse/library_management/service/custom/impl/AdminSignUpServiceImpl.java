package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.AdminRepository;
import lk.ijse.library_management.service.custom.AdminSignUpService;
import lk.ijse.library_management.util.SendEmail;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.mail.MessagingException;

public class AdminSignUpServiceImpl implements AdminSignUpService {

    private Session session;

    private final AdminRepository adminRepository =
            (AdminRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ADMIN);

    @Override
    public void sendEmail(String... data) {
        SendEmail sendEmail = new SendEmail ();
        new Thread(()->{
            try {
                sendEmail.sendEmail(data[0], data[1], data[2], data[3]);
            } catch ( MessagingException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public boolean saveAdmin(AdminDto adminDto) {
        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);
            int id = adminRepository.save(adminDto.toEntity());
            transaction.commit();
            return id > 0;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateAdmin(AdminDto dto) {
        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);
            adminRepository.update(dto.toEntity());
            transaction.commit();
            return true;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }
    }
}
