package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Branch;
import lk.ijse.library_management.repository.SuperRepository;
import org.hibernate.Session;

import java.util.List;

public interface BranchRepository extends SuperRepository {
    void setSession(Session session);

    int save(Branch branch);

    Branch get(int id);

    void update(Branch entity);

    void delete(Branch entity);

    List<Branch> getAllId();

    int getIdFormLocation(String location);
}
