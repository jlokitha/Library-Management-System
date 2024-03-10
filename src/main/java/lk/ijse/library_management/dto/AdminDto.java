package lk.ijse.library_management.dto;

import lk.ijse.library_management.embedded.NameIdentifier;
import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDto {
    private int id;
    private String fName;
    private String lName;
    private String mobile;
    private String email;
    private String username;
    private String password;
    private Timestamp addedDate;
    private Timestamp updatedDate;

    public Admin toEntity() {
        Admin admin = new Admin();

        admin.setId(id);
        admin.setName(new NameIdentifier(fName, lName));
        admin.setMobile(mobile);
        admin.setEmail(email);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setAddedDate(addedDate);
        admin.setUpdatedDate(updatedDate);

        return admin;
    }
}
