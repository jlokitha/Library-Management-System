package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.service.SuperService;

import java.util.List;

public interface BookService extends SuperService {
    List<BookDto> getAllBookData();

    int getIdFromUsername(String username);

    AdminDto getAdminData(int id);

    boolean saveBook(BookDto dto);

    BookDto getBookData(int id);

    boolean deleteBook(int id);

    boolean updateBook(BookDto dto);
}
