package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.AdminRepository;
import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.service.custom.SignInService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SignInServiceImpl implements SignInService {

    private Session session;

    private final AdminRepository adminRepository =
            (AdminRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ADMIN);

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
}
