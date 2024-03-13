package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.TransactionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    @Column(name = "book_qty")
    private int qty;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "transaction_status")
    private String status;

    @CreationTimestamp
    @Column(name = "transaction_added")
    private Timestamp addedDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "transaction")
    private List<TransactionDetails> details = new ArrayList<>();

    public TransactionDto toDto() {
        return new TransactionDto(
                id,
                qty,
                dueDate,
                status,
                addedDate,
                member
        );
    }
}
