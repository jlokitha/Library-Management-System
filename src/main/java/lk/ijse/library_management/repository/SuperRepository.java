package lk.ijse.library_management.repository;

import org.hibernate.Session;

public interface SuperRepository {
    void setSession(Session session);
}
