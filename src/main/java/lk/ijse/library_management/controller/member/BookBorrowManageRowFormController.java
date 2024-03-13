package lk.ijse.library_management.controller.member;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.util.List;

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

    public void setData(TransactionDto dto) {
        lblBorrowId.setText(String.valueOf(dto.getId()));
        lblBookAmount.setText(String.valueOf(dto.getQty()));
        lblStatus.setText(dto.getStatus());
        lblMemberId.setText(String.valueOf(dto.getMember().getId()));
        lblReturnDate.setText(String.valueOf(dto.getDueDate()));
    }
}
