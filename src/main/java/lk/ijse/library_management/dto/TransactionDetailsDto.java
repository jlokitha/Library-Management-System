package lk.ijse.library_management.dto;

import lk.ijse.library_management.embedded.TransactionDetailPK;
import lk.ijse.library_management.entity.TransactionDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDetailsDto {
    private TransactionDetailPK id;

    private TransactionDto transaction;

    private BookDto book;

    public TransactionDetails toEntity() {
        return new TransactionDetails(
                id,
                transaction.toEntity(),
                book.toEntity()
        );
    }
}
