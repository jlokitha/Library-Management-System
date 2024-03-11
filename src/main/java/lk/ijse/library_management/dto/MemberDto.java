package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {

    private int id;

    private String name;

    private String address;

    private String mobile;

    private String email;

    private String username;

    private String password;

    private Timestamp addedDate;

    private Timestamp updatedDate;

    public Member toEntity() {
        return new Member(
                id,
                name,
                address,
                mobile,
                email,
                username,
                password,
                addedDate,
                updatedDate
        );
    }
}
