package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.AdminRepository;
import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.service.custom.AdminSignInService;
import lk.ijse.library_management.util.SendEmail;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;

import javax.mail.MessagingException;

public class AdminSignInServiceImpl implements AdminSignInService {

    private Session session;

    private final AdminRepository adminRepository =
            (AdminRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ADMIN);

    @Override
    public int getIdFromUsernamePassword(String username, String password) {

        session = SessionFactoryConfig.getInstance().getSession();

        try {

            adminRepository.setSession(session);
            int id = adminRepository.getIdFormUsernamePassword(username, password);
            return id;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getIdFormUsername(String username) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            adminRepository.setSession(session);
            int id = adminRepository.getIdFormUsername(username);
            return id;

        } catch (Exception e) {

            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public AdminDto getAdminData(int id) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            adminRepository.setSession(session);
            Admin admin = adminRepository.get(id);
            return admin.toDto();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

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
}
