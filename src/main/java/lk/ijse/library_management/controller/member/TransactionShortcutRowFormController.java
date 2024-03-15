package lk.ijse.library_management.controller.member;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.library_management.projection.AdminTransactionProjection;
import lk.ijse.library_management.projection.MemberTransactionProjection;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TransactionShortcutRowFormController {

    @FXML
    private Label lblTransactionId;

    @FXML
    private Label lblContent;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    public void setDateAndTime(Timestamp dateAndTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(dateAndTime);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(dateAndTime);

        lblDate.setText(date);
        lblTime.setText(time);
    }

    public void setData(MemberTransactionProjection dto) {
        lblTransactionId.setText(String.valueOf(dto.getId()));
        lblContent.setText("Borrowed " + dto.getQty() + " Books Due " + dto.getDueDate());
        setDateAndTime((Timestamp) dto.getAddedDate());
    }

    @FXML
    public void btnViewOnAction(ActionEvent actionEvent) {
        try {
            BookBorrowViewFormController.id = Integer.parseInt(lblTransactionId.getText());
            MemberNavigation.popupPane("BookBorrowViewForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
