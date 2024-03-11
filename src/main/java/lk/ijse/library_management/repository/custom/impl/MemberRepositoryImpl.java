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
}
