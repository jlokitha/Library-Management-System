package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Admin;
import lk.ijse.library_management.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDto {

    private int id;

    private String name;

    private String location;

    private String mobile;

    private String email;

    private Timestamp createdDate;

    private Timestamp updatedDate;

    private Admin admin;

    public Branch toEntity() {
        return new Branch(
                id,
                name,
                location,
                mobile,
                email,
                createdDate,
                updatedDate,
                admin
        );
    }
}
