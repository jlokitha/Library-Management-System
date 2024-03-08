package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.SuperService;

public interface BranchService extends SuperService {
    boolean saveBranch(BranchDto branchDto);
}
