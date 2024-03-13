package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.service.SuperService;

public interface AdminSignInService extends SuperService {
    int getIdFromUsernamePassword(String username, String password);

    int getIdFormUsername(String username);

    AdminDto getAdminData(int id);

    void sendEmail(String... data);
}
