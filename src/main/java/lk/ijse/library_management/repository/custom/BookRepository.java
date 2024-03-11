package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Book;
import lk.ijse.library_management.repository.SuperRepository;

import java.util.List;

public interface BookRepository extends SuperRepository {
    List<Book> getAllData();
}