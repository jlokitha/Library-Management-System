package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.embedded.NameIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_address")
    private String address;

    @Column(name = "member_mobile")
    private String mobile;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_username")
    private String username;

    @Column(name = "member_password")
    private String password;

    @CreationTimestamp
    @Column(name = "member_added")
    private Timestamp addedDate;

    @UpdateTimestamp
    @Column(name = "member_updated")
    private Timestamp updatedDate;

    public MemberDto toDto() {
        return new MemberDto(
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
