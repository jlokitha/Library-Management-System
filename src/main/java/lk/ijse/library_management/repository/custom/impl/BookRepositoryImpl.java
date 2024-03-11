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
        String hql = "SELECT x FROM Book x";

        Query<Book> query = session.createQuery(hql, Book.class);

        List<Book> list = query.list();

         return list;
    }
}
