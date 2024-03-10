package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.repository.custom.AdminRepository;
import org.hibernate.Session;

public class AdminRepositoryImpl implements AdminRepository {

    private Session session;

    @Override
    public int save(Admin entity) {
        return (int) session.save(entity);
    }

    @Override
    public Admin get(int id) {
        return session.get(Admin.class, id);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
