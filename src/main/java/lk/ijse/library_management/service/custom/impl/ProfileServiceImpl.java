package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.controller.admin.AdminGlobalFormController;
import lk.ijse.library_management.dto.AdminDto;
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
    public AdminDto getAdminData() {

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);

            Admin admin = adminRepository.get(AdminGlobalFormController.id);

            transaction.commit();

            return admin.toDto();

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }
}
