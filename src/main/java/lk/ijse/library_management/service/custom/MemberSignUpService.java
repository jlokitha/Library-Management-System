package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.SuperService;

import java.sql.SQLException;

public interface MemberSignUpService extends SuperService {
    boolean saveMember(MemberDto memberDto) throws SQLException;

    boolean updateMember(MemberDto dto);

    void sendEmail(String... data);
}
