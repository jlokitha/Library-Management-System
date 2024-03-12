package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.embedded.TransactionDetailPK;
import lk.ijse.library_management.entity.TransactionDetails;
import lk.ijse.library_management.repository.SuperRepository;

public interface TransactionDetailRepository extends SuperRepository {
    TransactionDetailPK save(TransactionDetails entity);
}
