package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "branch_name")
    private String name;

    @Column(name = "branch_location")
    private String location;

    @Column(name = "branch_moobile")
    private String mobile;

    @Column(name = "branch_email")
    private String email;

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
                admin
        );
    }
}
