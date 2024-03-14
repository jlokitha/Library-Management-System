package lk.ijse.library_management.service.custom;

import lk.ijse.library_management.dto.AdminDto;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.SuperService;

import java.util.List;

public interface BranchService extends SuperService {
    boolean saveBranch(BranchDto branchDto);

    int getIdFromUsername(String username);

    AdminDto getAdminData(int id);

    BranchDto getBranchData(int id);

    boolean updateBranch(BranchDto branchDto);

    void deleteBranch(int id);

    List<BranchDto> getAllBranchData();

    int getIdFormLocation(String location);
}
