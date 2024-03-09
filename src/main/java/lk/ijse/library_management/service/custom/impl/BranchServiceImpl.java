package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.entity.Branch;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.BranchRepository;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository =
            (BranchRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BRANCH);
    @Override
    public boolean saveBranch(BranchDto branchDto) {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {

            branchRepository.setSession(session);
            int id = branchRepository.save(branchDto.toEntity());
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
}
