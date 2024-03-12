package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.repository.SuperRepository;

public interface TransactionRepository extends SuperRepository {
    int save(Transaction entity);
}
