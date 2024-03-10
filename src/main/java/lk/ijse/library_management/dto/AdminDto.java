package lk.ijse.library_management.dto;

import lk.ijse.library_management.embedded.NameIdentifier;
import lk.ijse.library_management.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Admin toEntity() {
        Admin admin = new Admin();

        admin.setName(new NameIdentifier(fName, lName));
        admin.setMobile(mobile);
        admin.setEmail(email);
        admin.setUsername(username);
        admin.setPassword(password);

        return admin;
    }
}
