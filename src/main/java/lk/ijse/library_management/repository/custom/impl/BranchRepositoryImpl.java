package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Branch;
import lk.ijse.library_management.repository.custom.BranchRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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

    @Override
    public Branch get(int id) {
        return session.get(Branch.class, id);
    }

    @Override
    public void update(Branch entity) {
        session.update(entity);
    }

    @Override
    public void delete(Branch entity) {
        session.delete(entity);
    }

    @Override
    public List<Branch> getAllId() {
        String hql = "SELECT b FROM Branch b";

        Query<Branch> query = session.createQuery(hql, Branch.class);

        List<Branch> list = query.list();

        return list;
    }

    @Override
    public int getIdFormLocation(String location) {
        try {
            String hql = "SELECT b.id FROM Branch b WHERE b.location = :location";

            Query query = session.createQuery(hql);
            query.setParameter("location", location);

            return (int) query.uniqueResult();

        } catch (Exception e) {
            return -1;
        }
    }
}
