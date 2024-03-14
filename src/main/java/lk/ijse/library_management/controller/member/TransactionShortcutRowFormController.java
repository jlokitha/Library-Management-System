package lk.ijse.library_management.controller.member;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.library_management.projection.TransactionProjection;

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

    public void setStatus(TransactionProjection dto) {
        java.util.Date date = new java.util.Date(System.currentTimeMillis());

        if ( (date.after(dto.getDueDate())) && (dto.getStatus().equals("Due") || (dto.getStatus().equals("Overdue")))) {
            setStatusStyle();
        }
    }

    public void setStatusStyle() {

        lblTransactionId.setStyle(
                "-fx-background-color: #FFD3D3;" +
                        "-fx-background-radius: 20px;" +
                        "-fx-text-fill: #FF0E0E");
    }

    public void setData(TransactionProjection dto) {
        lblTransactionId.setText(String.valueOf(dto.getId()));
        lblContent.setText("Borrowed " + dto.getQty() + " Books Due " + dto.getDueDate());
        setDateAndTime((Timestamp) dto.getAddedDate());
        setStatus(dto);
    }
}
