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
    public List<Book> getAll() {
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

    @Override
    public void delete(Book book) {
        session.update(book);
    }

    @Override
    public void update(Book entity) {
        session.update(entity);
    }

    @Override
    public List<String> getAllTitles() {
        String status = "Available";
        String hql = "SELECT b.title FROM Book b WHERE b.availability = :availability";

        Query query = session.createQuery(hql);
        query.setParameter("availability", status);

        return query.list();
    }

    @Override
    public Book getBookFormTitle(String title) {
        String status = "Available";
        String hql = "SELECT b FROM Book b WHERE b.title = :title AND b.availability = :availability";

        Query<Book> query = session.createQuery(hql, Book.class);
        query.setParameter("title", title);
        query.setParameter("availability", status);

        return query.uniqueResult();
    }

    @Override
    public String getAuthorFormTitle(String title) {
        String hql = "SELECT b.author FROM Book b WHERE b.title = :title";

        Query query = session.createQuery(hql);
        query.setParameter("title", title);

        return (String) query.uniqueResult();
    }

    @Override
    public int getIdFormTitle(String title) {
        String hql = "SELECT b.id FROM Book b WHERE b.title = :title";

        Query query = session.createQuery(hql);
        query.setParameter("title", title);

        return (int) query.uniqueResult();
    }

    @Override
    public int getCount() {
        String hql = "SELECT COUNT (b) FROM Book b";

        Query query = session.createQuery(hql);

        Long count = (Long) query.uniqueResult();

        return Math.toIntExact(count);
    }
}
