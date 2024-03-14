package lk.ijse.library_management.entity;

import lk.ijse.library_management.dto.TransactionDetailsDto;
import lk.ijse.library_management.embedded.TransactionDetailPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

    @EmbeddedId
    private TransactionDetailPK id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "transaction_id",
            insertable = false,
            updatable = false
    )
    private Transaction transaction;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "book_id",
            insertable = false,
            updatable = false
    )
    private Book book;

    public TransactionDetailsDto toDto() {
        return new TransactionDetailsDto(
                id,
                transaction.toDto(),
                book.toDto()
        );
    }
}
