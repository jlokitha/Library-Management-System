package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.repository.custom.TransactionRepository;
import org.hibernate.Session;

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
}
