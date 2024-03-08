package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDto {

    private int id;

    private String location;

    private String mobile;

    private String email;

    public Branch toEntity() {
        Branch branch = new Branch();
        branch.setId(this.id);
        branch.setLocation(this.location);
        branch.setMobile(this.mobile);
        branch.setEmail(this.email);
        return branch;
    }
}
