package lk.ijse.library_management.dto;

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
}
