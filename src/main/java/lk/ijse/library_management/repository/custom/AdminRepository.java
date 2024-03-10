package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.repository.SuperRepository;

public interface AdminRepository extends SuperRepository {
    int save(Admin entity);

    Admin get(int id);
}
