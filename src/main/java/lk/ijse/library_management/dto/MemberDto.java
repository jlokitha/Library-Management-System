package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {

    private int id;

    private String name;

    private String mobile;

    private String email;

    private String username;

    private String password;

    private Timestamp addedDate;

    private Timestamp updatedDate;

    public Member toEntity() {
        Member member = new Member();

        member.setId(id);
        member.setName(name);
        member.setMobile(mobile);
        member.setEmail(email);
        member.setUsername(username);
        member.setPassword(password);
        member.setAddedDate(addedDate);
        member.setUpdatedDate(updatedDate);

        return member;
    }
}
