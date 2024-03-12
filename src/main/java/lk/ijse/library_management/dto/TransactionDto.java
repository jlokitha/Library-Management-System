package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {

    private int id;

    private int qty;

    private Date dueDate;

    private String status;

    private Timestamp addedDate;

    private Member member;

    public Transaction toEntity() {
        return new Transaction(
                id,
                qty,
                dueDate,
                status,
                addedDate,
                member,
                new ArrayList<>()
        );
    }
}
