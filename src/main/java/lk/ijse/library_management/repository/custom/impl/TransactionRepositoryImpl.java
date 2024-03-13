package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.entity.TransactionDetails;
import lk.ijse.library_management.repository.custom.TransactionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        String hql = "SELECT t FROM Transaction t";

        Query<Transaction> query = session.createQuery(hql, Transaction.class);
        return query.list();
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
}
