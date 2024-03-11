package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.custom.MemberRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Member get(int id) {
        return session.get(Member.class, id);
    }

    @Override
    public List<Member> getAll() {
        String hql = "SELECT m FROM Member m";

        Query<Member> query = session.createQuery(hql, Member.class);

        return query.list();
    }

    @Override
    public void delete(Member entity) {
        session.delete(entity);
    }

    @Override
    public int getIdFormUsername(String username) {
        String hql = "SELECT m.id FROM Member m WHERE m.username = :username";

        Query<Integer> query = session.createQuery(hql, Integer.class);
        query.setParameter("username", username);

        Integer id = query.uniqueResult();
        return (id != null) ? id : -1;
    }

    @Override
    public int save(Member entity) {
        return (int) session.save(entity);
    }

    @Override
    public int getIdFormUsernamePassword(String username, String password) {
        String hql = "SELECT m.id FROM Member m WHERE m.username = :username AND m.password = :password";

        Query<Integer> query = session.createQuery(hql, Integer.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        Integer id = query.uniqueResult();
        return (id != null) ? id : -1;
    }

    @Override
    public void update(Member entity) {
        session.update(entity);
    }
}
