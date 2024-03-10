package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.AdminRepository;
import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.service.custom.ProfileService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfileServiceImpl implements ProfileService {

    private Session session;

    private final AdminRepository adminRepository =
            (AdminRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ADMIN);

    @Override
    public Admin getAdminData(int id) {

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);

            Admin admin = adminRepository.get(id);

            transaction.commit();

            return admin;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public int getIdFromUsernamePassword(String username, String password) {

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);
            int id = adminRepository.getIdFormUsernamePassword(username, password);
            transaction.commit();
            return id;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public int getIdFromUsername(String username) {

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);
            int id = adminRepository.getIdFormUsername(username);
            transaction.commit();
            return id;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public void deleteAdmin(int id) {

        Admin entity = getAdminData(id);

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);
            adminRepository.delete(entity);
            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }

    }
}
