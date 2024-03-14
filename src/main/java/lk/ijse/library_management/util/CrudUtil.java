package lk.ijse.library_management.util;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.SuperRepository;

import java.sql.SQLException;
import java.util.List;

public interface CrudUtil<T> extends SuperRepository {
    int save(final T entity) throws SQLException;

    void delete(final T id) throws SQLException;

    void update(final T entity) throws SQLException;

    T get(final int id) throws SQLException;

    List<T> getAll();
}
