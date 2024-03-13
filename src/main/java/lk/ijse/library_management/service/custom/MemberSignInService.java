package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.SuperService;

public interface MemberSignInService extends SuperService {
    int getIdFromUsernamePassword(String username, String password);

    int getIdFormUsername(String username);

    MemberDto getMemberData(int id);

    void sendEmail(String... data);
}
