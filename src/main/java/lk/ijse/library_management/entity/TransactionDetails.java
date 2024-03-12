package lk.ijse.library_management.entity;

import lk.ijse.library_management.embedded.TransactionDetailPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "transaction_details")
public class TransactionDetails {

    @EmbeddedId
    private TransactionDetailPK id;

    @ManyToOne
    @JoinColumn(name = "transaction_id", insertable = false, updatable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;
}
