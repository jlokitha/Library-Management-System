package lk.ijse.library_management.controller.member;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BookBorrowManageRowFormController {

    @FXML
    private Label lblBorrowId;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblBookAmount;

    @FXML
    private Label lblReturnDate;

    @FXML
    private Label lblStatus;

    @FXML
    private ImageView imgView;

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) {
        try {
            BookBorrowViewFormController.id = Integer.parseInt(lblBorrowId.getText());
            MemberNavigation.popupPane("BookBorrowViewForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void imgViewOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseExited(MouseEvent event) {

    }

    public void setStatus(TransactionDto dto) {
        LocalDate currentDate = LocalDate.now();
        LocalDate expDate = dto.getDueDate().toLocalDate();

        if ( (currentDate.isAfter(expDate)) && (dto.getStatus().equals("Due")) ) {
            dto.setStatus("Overdue");
            BookBorrowManageFormController.controller.updateList.add(dto);
            lblStatus.setText("Overdue");
        } else {
            lblStatus.setText(dto.getStatus());
        }
    }

    public void setStatusStyle() {
        String status = lblStatus.getText();

        lblStatus.setAlignment(Pos.CENTER);

        if ( Objects.equals(status, "Returned") ) {
            lblStatus.setStyle(
                    "-fx-background-color: #C7FFDE;" +
                            "-fx-background-radius: 20px;" +
                            "-fx-text-fill: #139547");
        } else if (Objects.equals(status, "Due")) {
            lblStatus.setStyle(
                    "-fx-background-color: #A0C0FFFF;" +
                            "-fx-background-radius: 20px;" +
                            "-fx-text-fill: #1351CB");

        } else {
            lblStatus.setStyle(
                    "-fx-background-color: #FFD3D3;" +
                            "-fx-background-radius: 20px;" +
                            "-fx-text-fill: #FF0E0E");
        }
    }

    public void setData(TransactionDto dto) {
        lblBorrowId.setText(String.valueOf(dto.getId()));
        lblBookAmount.setText(String.valueOf(dto.getQty()));
        lblMemberId.setText(String.valueOf(dto.getMember().getId()));
        lblReturnDate.setText(String.valueOf(dto.getDueDate()));
        setStatus(dto);
        setStatusStyle();
    }
}
