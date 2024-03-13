package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.dto.TransactionDetailsDto;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.service.SuperService;

import java.util.List;

public interface TransactionService extends SuperService {
    List<String> getAllBookTitles();

    BookDto getBookDataFromTitle(String title);

    boolean saveTransaction(TransactionDto dto, MemberDto member, List<BookDto> books);

    MemberDto getMemberFromUsername(String username);

    String getBookAuthorFromTitle(String title);

    List<TransactionDto> getAllTransactionData();

    TransactionDto getTransactionData(int id);

    List<TransactionDetailsDto> getTransactionDetails(TransactionDto dto);

    boolean updateTransaction(int id);
}
