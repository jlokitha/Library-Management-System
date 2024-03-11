package lk.ijse.library_management.service.custom.impl;

import lk.ijse.library_management.controller.admin.AdminGlobalFormController;
import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.entity.Book;
import lk.ijse.library_management.repository.RepositoryFactory;
import lk.ijse.library_management.repository.custom.AdminRepository;
import lk.ijse.library_management.repository.custom.BookRepository;
import lk.ijse.library_management.repository.custom.impl.AdminRepositoryImpl;
import lk.ijse.library_management.repository.custom.impl.BookRepositoryImpl;
import lk.ijse.library_management.service.custom.BookService;
import lk.ijse.library_management.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private Session session;

    private final BookRepository bookRepository =
            (BookRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BOOK);

    private final AdminRepository adminRepository =
            (AdminRepositoryImpl) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ADMIN);

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

    @Override
    public int getIdFromUsername(String username) {

        session = SessionFactoryConfig.getInstance().getSession();

        try {

            adminRepository.setSession(session);
            int id = adminRepository.getIdFormUsername(username);
            return id;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        } finally {
            session.close();
        }
    }

    @Override
    public AdminDto getAdminData(int id) {

        session = SessionFactoryConfig.getInstance().getSession();

        try {

            adminRepository.setSession(session);

            Admin admin = adminRepository.get(id);

            return admin.toDto();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }

    @Override
    public boolean saveBook(BookDto dto) {

        int id = getIdFromUsername(AdminGlobalFormController.username);

        AdminDto data = getAdminData(id);

        dto.setAdmin(data.toEntity());

        session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        try {

            bookRepository.setSession(session);

            int bId = bookRepository.save(dto.toEntity());

            transaction.commit();

            return bId > 0;

        } catch (Exception e) {

            transaction.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }
    }

    @Override
    public BookDto getBookData(int id) {
        session = SessionFactoryConfig.getInstance().getSession();

        try {

            bookRepository.setSession(session);

            Book book = bookRepository.get(id);

            return book.toDto();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            session.close();
        }
    }
}
