package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.SuperRepository;

import java.util.List;

public interface MemberRepository extends SuperRepository {
    Member get(int id);

    List<Member> getAll();

    void delete(Member entity);

    int getIdFormUsername(String username);

    int save(Member entity);

    int getIdFormUsernamePassword(String username, String password);

    void update(Member entity);

    int getIdFormMobile(String mobile);
}
