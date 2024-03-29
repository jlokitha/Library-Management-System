package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.projection.AdminTransactionProjection;
import lk.ijse.library_management.projection.MemberTransactionProjection;
import lk.ijse.library_management.service.SuperService;

import java.util.List;

public interface DashboardService extends SuperService {
    int getMemberCount();

    int getBookCount();

    int getDueTransactionCount();

    int getBranchCount();

    List<AdminTransactionProjection> getAllTransactions();

    int getMemberIdFormMobile(String mobile);

    int getMemberIdFormUsername(String username);

    MemberDto getMemberData(int id);

    int getMemberReadBookCount(MemberDto dto);

    int getMemberReturnedCount(MemberDto dto);

    int getMemberDueCount(MemberDto dto);

    List<MemberTransactionProjection> getAllTransactionsOfMember(MemberDto dto);

    int getMemberBorrowBookCount(MemberDto dto);
}
