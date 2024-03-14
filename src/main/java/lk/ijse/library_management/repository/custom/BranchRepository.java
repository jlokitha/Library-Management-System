package lk.ijse.library_management.repository.custom;

import lk.ijse.library_management.entity.Branch;
import lk.ijse.library_management.repository.SuperRepository;
import lk.ijse.library_management.util.CrudUtil;
import org.hibernate.Session;

import java.util.List;

public interface BranchRepository extends CrudUtil<Branch> {
    void setSession(Session session);

    List<Branch> getAllId();

    int getIdFormLocation(String location);

    int getCount();

}
