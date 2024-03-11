package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.repository.SuperRepository;

import java.util.List;

public interface MemberRepository extends SuperRepository {
    Member get(int id);

    List<Member> getAll();

    void delete(Member entity);
}
