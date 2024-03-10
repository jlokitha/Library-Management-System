package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Admin;
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

    private Admin admin;

    public Branch toEntity() {
        return new Branch(
                id,
                location,
                mobile,
                email,
                admin
        );
    }
}
