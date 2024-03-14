package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.embedded.NameIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_mobile", nullable = false, unique = true)
    private String mobile;

    @Column(name = "member_email", nullable = false, unique = true)
    private String email;

    @Column(name = "member_username", nullable = false, unique = true)
    private String username;

    @Column(name = "member_password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "member_added")
    private Timestamp addedDate;

    @UpdateTimestamp
    @Column(name = "member_updated")
    private Timestamp updatedDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "member"
    )
    private List<Transaction> transactions = new ArrayList<>();

    public MemberDto toDto() {
        return new MemberDto(
                id,
                name,
                mobile,
                email,
                username,
                password,
                addedDate,
                updatedDate
        );
    }
}
