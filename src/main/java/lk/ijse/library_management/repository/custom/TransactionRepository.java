package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.entity.TransactionDetails;
import lk.ijse.library_management.projection.AdminTransactionProjection;
import lk.ijse.library_management.projection.MemberTransactionProjection;
import lk.ijse.library_management.util.CrudUtil;

import java.util.List;

public interface TransactionRepository extends CrudUtil<Transaction> {

    List<TransactionDetails> getTransactionDetails(Transaction entity);

    List<Transaction> getAllToMember(Member member);

    int getDueCount();

    List<AdminTransactionProjection> getAllTransactionProjection();

    int getReturnBookCountOfMember(Member entity);

    int getReturnedCountOfMember(Member entity);

    int getDueCountOfMember(Member entity);

    List<MemberTransactionProjection> getAllTransactionProjectionOfMember(Member entity);

    int getBorrowBookCountOfMember(Member entity);
}
