package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.SuperRepository;
import lk.ijse.library_management.util.CrudUtil;

import java.util.List;

public interface MemberRepository extends CrudUtil<Member> {

    int getIdFormUsername(String username);

    int getIdFormUsernamePassword(String username, String password);

    int getIdFormMobile(String mobile);

    int getCount();
}
