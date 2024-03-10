package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.entity.Branch;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.AdminRepository;
import lk.ijse.library_management.repository.custom.BranchRepository;
import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BranchServiceImpl implements BranchService {

    private Session session;

    private final BranchRepository branchRepository =
            (BranchRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BRANCH);

    private final AdminRepository adminRepository =
            (AdminRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ADMIN);

    @Override
    public boolean saveBranch(BranchDto branchDto) {

        session = SessionFactoryConfig.getInstance().getSession();
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
    public BranchDto getBranchData(int id) {

        session = SessionFactoryConfig.getInstance().getSession();

        try {

            branchRepository.setSession(session);

            Branch branch = branchRepository.get(id);

            return branch.toDto();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateBranch(BranchDto branchDto) {
        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            branchRepository.setSession(session);

            branchRepository.update(branchDto.toEntity());

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

    @Override
    public void deleteBranch(int id) {

        BranchDto dto = getBranchData(id);

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            adminRepository.setSession(session);

            branchRepository.delete(dto.toEntity());

            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();

        } finally {
            session.close();
        }
    }

    @Override
    public List<BranchDto> getAllBranchData() {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            branchRepository.setSession(session);

            List<Branch> ids = branchRepository.getAllId();

            List<BranchDto> dtos = new ArrayList<>();

            for (Branch entity : ids) {
                dtos.add(entity.toDto());
            }

            return dtos;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }
}
