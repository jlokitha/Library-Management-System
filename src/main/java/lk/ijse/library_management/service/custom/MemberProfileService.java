package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.SuperService;

public interface MemberProfileService extends SuperService {
    int getIdFromUsername(String username);

    MemberDto getMemberData(int id);

    int getIdFromUsernamePassword(String username, String password);

    void deleteMember(int id);

    boolean updateMemberPassword(int id, String currentPass, String newPass);
}
