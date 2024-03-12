package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.service.SuperService;

import java.util.List;

public interface TransactionService extends SuperService {
    List<String> getAllBookTitles();

    BookDto getBookDataFromTitle(String title);

    boolean saveTransaction(TransactionDto dto, MemberDto member, List<BookDto> books);

    MemberDto getMemberFromUsername(String username);

    String getBookAuthorFromTitle(String title);
}
