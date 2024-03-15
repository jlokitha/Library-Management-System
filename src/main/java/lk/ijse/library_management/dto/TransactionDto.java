package lk.ijse.library_management.dto;

import lk.ijse.library_management.entity.Member;
import lk.ijse.library_management.entity.Transaction;
import lk.ijse.library_management.entity.TransactionDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {

    private int id;

    private int qty;

    private Date dueDate;

    private String status;

    private Timestamp addedDate;

    private MemberDto member;

    public Transaction toEntity() {
        return new Transaction(
                id,
                qty,
                dueDate,
                status,
                addedDate,
                member.toEntity(),
                new ArrayList<>()
        );
    }
}
