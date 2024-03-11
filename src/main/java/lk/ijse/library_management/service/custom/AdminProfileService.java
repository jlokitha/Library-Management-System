package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.SuperService;

public interface AdminProfileService extends SuperService {
    AdminDto getAdminData(int id);

    int getIdFromUsernamePassword(String username, String password);

    int getIdFromUsername(String username);

    void deleteAdmin(int id);

    boolean updateAdminPassword(int id, String oldPassword, String newPassword);
}
