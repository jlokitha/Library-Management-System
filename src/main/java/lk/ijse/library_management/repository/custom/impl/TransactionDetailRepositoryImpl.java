package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.embedded.TransactionDetailPK;
import lk.ijse.library_management.entity.TransactionDetails;
import lk.ijse.library_management.repository.custom.TransactionDetailRepository;
import org.hibernate.Session;

public class TransactionDetailRepositoryImpl implements TransactionDetailRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public TransactionDetailPK save(TransactionDetails entity) {
        return (TransactionDetailPK) session.save(entity);
    }
}
