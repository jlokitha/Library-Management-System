package lk.ijse.library_management.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Embeddable
public class TransactionDetailPK implements Serializable {

    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "book_id")
    private int bookId;
}
