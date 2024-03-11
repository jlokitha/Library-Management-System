package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.service.SuperService;

import java.util.List;

public interface BookService extends SuperService {
    List<BookDto> getAllBookData();
}
