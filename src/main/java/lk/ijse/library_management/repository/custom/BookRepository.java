package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Book;
import lk.ijse.library_management.repository.SuperRepository;

import java.util.List;

public interface BookRepository extends SuperRepository {
    List<Book> getAllData();

    int save(Book entity);

    Book get(int id);

    void delete(Book book);

    void update(Book entity);

    List<String> getAllTitles();

    Book getBookFormTitle(String title);

    String getAuthorFormTitle(String title);
}
