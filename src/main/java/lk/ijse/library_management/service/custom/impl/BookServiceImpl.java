package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.entity.Book;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.BookRepository;
import lk.ijse.library_management.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.library_management.service.custom.BookService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private Session session;

    private final BookRepository bookRepository =
            (BookRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BOOK);

    @Override
    public List<BookDto> getAllBookData() {

        session = SessionFactoryConfig.getInstance().getSession();

        try {

            bookRepository.setSession(session);

            List<Book> ids = bookRepository.getAllData();

            List<BookDto> dtos = new ArrayList<>();

            for (Book entity : ids) {
                dtos.add(entity.toDto());
            }

            return dtos;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }
}
