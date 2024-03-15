package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.entity.TransactionDetails;
import lk.ijse.library_management.projection.AdminTransactionProjection;
import lk.ijse.library_management.projection.MemberTransactionProjection;
import lk.ijse.library_management.repository.custom.TransactionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public int save(Transaction entity) {
        return (int) session.save(entity);
    }

    @Override
    public List<Transaction> getAll() {
        try {
            String hql = "SELECT t FROM Transaction t";

            Query<Transaction> query = session.createQuery(hql, Transaction.class);

            return query.list();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Transaction get(int id) {
        return session.get(Transaction.class, id);
    }

    @Override
    public List<TransactionDetails> getTransactionDetails(Transaction entity) {
        String hql = "SELECT td FROM TransactionDetails td WHERE td.transaction = :entity";

        Query query = session.createQuery(hql);
        query.setParameter("entity", entity);

        List list = query.list();

        return list;
    }

    @Override
    public void update(Transaction entity) {
        session.update(entity);
    }

    @Override
    public List<Transaction> getAllToMember(Member member) {
        String hql = "SELECT t FROM Transaction t WHERE t.member = :member";

        Query<Transaction> query = session.createQuery(hql, Transaction.class);
        query.setParameter("member", member);

        return query.list();
    }

    @Override
    public int getDueCount() {
        String hql = "SELECT COUNT(t) FROM Transaction t WHERE t.status = 'Due' OR t.status = 'Overdue'";

        Query query = session.createQuery(hql);

        Long count = (Long) query.uniqueResult();

        return Math.toIntExact(count);
    }

    @Override
    public void delete(Transaction entity) {
        session.delete(entity);
    }

    @Override
    public List<AdminTransactionProjection> getAllTransactionProjection() {

        String hql = "SELECT " +
                "new lk.ijse.library_management.projection.AdminTransactionProjection(t.id, t.qty, t.dueDate, t.addedDate, t.member.id) " +
                "FROM Transaction t WHERE t.dueDate < CURRENT_DATE ";

        Query query = session.createQuery(hql);

        List<AdminTransactionProjection> list = query.list();

        return list;
    }

    @Override
    public int getReturnBookCountOfMember(Member entity) {
        String hql = "SELECT SUM (t.qty) FROM Transaction t WHERE t.status = 'Returned' AND t.member = :member";

        Query query = session.createQuery(hql);
        query.setParameter("member", entity);

        Long count = (Long) query.uniqueResult();

        return (count != null) ?Math.toIntExact(count) : 0;
    }

    @Override
    public int getReturnedCountOfMember(Member entity) {
        String hql = "SELECT COUNT(t) FROM Transaction t WHERE t.status = 'Returned' AND t.member = :member";

        Query query = session.createQuery(hql);
        query.setParameter("member", entity);

        Long count = (Long) query.uniqueResult();

        return Math.toIntExact(count);
    }

    @Override
    public int getDueCountOfMember(Member entity) {
        String hql = "SELECT COUNT(t) FROM Transaction t WHERE t.status = 'Due' OR t.status = 'Overdue' AND t.member = :member";

        Query query = session.createQuery(hql);
        query.setParameter("member", entity);

        Long count = (Long) query.uniqueResult();

        return Math.toIntExact(count);
    }

    @Override
    public List<MemberTransactionProjection> getAllTransactionProjectionOfMember(Member entity) {
        String hql = "SELECT " +
                "new lk.ijse.library_management.projection.MemberTransactionProjection(t.id, t.qty, t.dueDate, t.addedDate) " +
                "FROM Transaction AS t WHERE t.member = :member AND t.status = 'Due' OR t.status = 'Overdue'";

        Query query = session.createQuery(hql);
        query.setParameter("member", entity);

        List<MemberTransactionProjection> list = query.list();

        return list;
    }

    @Override
    public int getBorrowBookCountOfMember(Member entity) {
        String hql = "SELECT SUM (t.qty) FROM Transaction t WHERE t.member = :member";

        Query query = session.createQuery(hql);
        query.setParameter("member", entity);

        Long count = (Long) query.uniqueResult();

        return (count != null) ?Math.toIntExact(count) : 0;
    }
}
