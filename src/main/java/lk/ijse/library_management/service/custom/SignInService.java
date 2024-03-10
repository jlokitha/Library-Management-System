package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.service.SuperService;

public interface SignInService extends SuperService {
    int getIdFromUsernamePassword(String username, String password);
}
