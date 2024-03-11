package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.repository.custom.AdminRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public int getIdFormUsernamePassword(String username, String password) {
        String hql = "SELECT a.id FROM Admin a WHERE a.username = :username AND a.password = :password";

        Query<Integer> query = session.createQuery(hql, Integer.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        Integer id = query.uniqueResult();
        return (id != null) ? id : -1;
    }

    @Override
    public void delete(Admin entity) {
        session.delete(entity);
    }

    @Override
    public int getIdFormUsername(String username) {
        String hql = "SELECT a.id FROM Admin a WHERE a.username = :username";

        Query<Integer> query = session.createQuery(hql, Integer.class);
        query.setParameter("username", username);

        Integer id = query.uniqueResult();
        return id;
    }

    @Override
    public void update(Admin entity) {
        session.update(entity);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
