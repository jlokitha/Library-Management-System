package lk.ijse.library_management.util;

import lk.ijse.library_management.repository.SuperRepository;

import java.sql.SQLException;

public interface CrudUtil<T> extends SuperRepository {
    boolean save(final T entity) throws SQLException;

    boolean delete(final String id) throws SQLException;

    boolean update(final T entity) throws SQLException;

    T get(final String id) throws SQLException;
}
