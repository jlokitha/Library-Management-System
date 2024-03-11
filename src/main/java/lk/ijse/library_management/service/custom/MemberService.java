package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.SuperService;

import java.util.List;

public interface MemberService extends SuperService {
    MemberDto getMemberData(int id);

    List<MemberDto> getAllMemberData();

    boolean deleteMember(int id);
}
