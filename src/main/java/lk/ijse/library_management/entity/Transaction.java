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

    @Column(name = "book_qty", nullable = false)
    private int qty;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Column(name = "transaction_status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "transaction_added")
    private Timestamp addedDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "transaction"
    )
    private List<TransactionDetails> transactionDetails = new ArrayList<>();

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
