package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Branch;
import lk.ijse.library_management.repository.custom.BranchRepository;
import org.hibernate.Session;

public class BranchRepositoryImpl implements BranchRepository {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public int save(Branch branch) {
        return (int) session.save(branch);
    }
}
