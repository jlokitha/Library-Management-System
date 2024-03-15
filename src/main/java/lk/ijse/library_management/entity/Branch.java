package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "branch")
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int id;

    @Column(name = "branch_name", nullable = false, unique = true)
    private String name;

    @Column(name = "branch_location", nullable = false)
    private String location;

    @Column(name = "branch_moobile", nullable = false, unique = true)
    private String mobile;

    @Column(name = "branch_email", nullable = false)
    private String email;

    @CreationTimestamp
    @Column(name = "branch_added")
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "branch_updated")
    private Timestamp updatedDate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public BranchDto toDto() {
        return new BranchDto(
                id,
                name,
                location,
                mobile,
                email,
                createdDate,
                updatedDate,
                admin.toDto()
        );
    }
}
