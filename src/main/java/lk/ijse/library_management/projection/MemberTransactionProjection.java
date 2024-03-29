package lk.ijse.library_management.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberTransactionProjection {

    private int id;

    private int qty;

    private Date dueDate;

    private Date addedDate;
}
