package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.AdminRepository;
import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.service.custom.AdminProfileService;
import lk.ijse.library_management.util.SendEmail;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.mail.MessagingException;

public class AdminProfileServiceImpl implements AdminProfileService {

    private Session session;

    private final AdminRepository adminRepository =
            (AdminRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ADMIN);

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
    public int getIdFromUsername(String username) {

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
    public void deleteAdmin(int id) {

        AdminDto dto = getAdminData(id);

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);
            adminRepository.delete(dto.toEntity());
            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

    }

    @Override
    public boolean updateAdminPassword(int id, String oldPassword, String newPassword) {

        AdminDto dto = getAdminData(id);

        if (oldPassword.equals(dto.getPassword())) {

            dto.setPassword(newPassword);

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
        } else {
            return false;
        }
    }

    @Override
    public void sendAccountDeletionEmail(String email) {
        SendEmail sendEmail = new SendEmail();
        String subject = "Account Deletion Confirmation";
        String htmlPath = "DeleteUserEmail.html";

        new Thread(() -> {
            try {
                sendEmail.sendEmail(email, subject, htmlPath);

            } catch ( MessagingException e) {}
        }).start();
    }

    @Override
    public void sendPasswordChangeEmail(String email) {
        new Thread(() -> {
            SendEmail sendEmail = new SendEmail();

            String subject = "Password Change Confirmation";
            String htmlPath = "ChangePasswordEmail.html";
            try {
                sendEmail.sendEmail(email, subject, htmlPath);
            } catch (MessagingException e) {
                System.out.println("Password Change Email Failed !");
            }
        }).start();
    }
}
