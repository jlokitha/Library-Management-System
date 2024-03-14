package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.repository.SuperRepository;
import lk.ijse.library_management.util.CrudUtil;

public interface AdminRepository extends CrudUtil<Admin> {

    int getIdFormUsernamePassword(String username, String password);

    int getIdFormUsername(String username);
}
