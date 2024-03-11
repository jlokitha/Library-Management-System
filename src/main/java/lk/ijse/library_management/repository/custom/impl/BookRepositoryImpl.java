package lk.ijse.library_management.repository.custom.impl;

import lk.ijse.library_management.entity.Book;
import lk.ijse.library_management.repository.custom.BookRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<Book> getAllData() {
        String hql = "SELECT b FROM Book b";

        Query<Book> query = session.createQuery(hql, Book.class);

        List<Book> list = query.list();

         return list;
    }

    @Override
    public int save(Book entity) {
       return (int) session.save(entity);
    }

    @Override
    public Book get(int id) {
        return session.get(Book.class, id);
    }
}
