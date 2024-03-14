package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Book;
import lk.ijse.library_management.repository.SuperRepository;
import lk.ijse.library_management.util.CrudUtil;

import java.util.List;

public interface BookRepository extends CrudUtil<Book> {

    List<String> getAllTitles();

    Book getBookFormTitle(String title);

    String getAuthorFormTitle(String title);

    int getIdFormTitle(String title);

    int getCount();
}
