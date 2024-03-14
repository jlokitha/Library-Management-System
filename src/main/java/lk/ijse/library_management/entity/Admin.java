package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.AdminDto;
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
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int id;

    @Column(name = "admin_name", nullable = false)
    private NameIdentifier name;

    @Column(name = "admin_mobile", nullable = false, unique = true)
    private String mobile;

    @Column(name = "admin_email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "admin_added")
    private Timestamp addedDate;

    @UpdateTimestamp
    @Column(name = "admin_updated")
    private Timestamp updatedDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "admin"
    )
    private List<Branch> branches = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "admin"
    )
    private List<Book> books = new ArrayList<>();

    public AdminDto toDto() {
        return new AdminDto(
                id,
                name.getFName(),
                name.getLName(),
                mobile,
                email,
                username,
                password,
                addedDate,
                updatedDate
        );
    }
}
