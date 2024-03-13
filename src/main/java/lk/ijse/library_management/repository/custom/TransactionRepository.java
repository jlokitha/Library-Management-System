package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.entity.TransactionDetails;
import lk.ijse.library_management.repository.SuperRepository;

import java.util.List;

public interface TransactionRepository extends SuperRepository {
    int save(Transaction entity);

    List<Transaction> getAll();

    Transaction get(int id);

    List<TransactionDetails> getTransactionDetails(Transaction entity);

    void update(Transaction entity);

    List<Transaction> getAllToMember(Member member);
}
