package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.TransactionService;
import lk.ijse.library_management.service.custom.impl.TransactionServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

public class BookBorrowManageRowFormController {

    @FXML
    public ImageView imgReturn;

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

    private final TransactionService transactionService =
            (TransactionServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.TRANSACTION);

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) {
        try {
            BookBorrowViewFormController.id = Integer.parseInt(lblBorrowId.getText());
            AdminNavigation.popupPane("BookBorrowViewForm.fxml");
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

    public void imgReturnOnMouseClicked(MouseEvent mouseEvent) {
        boolean isUpdated = transactionService.updateTransaction(Integer.parseInt(lblBorrowId.getText()));
    }

    public void imgReturnOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void imgReturnOnMouseExited(MouseEvent mouseEvent) {

    }

    public void setData(TransactionDto dto) {
        lblBorrowId.setText(String.valueOf(dto.getId()));
        lblBookAmount.setText(String.valueOf(dto.getQty()));
        lblStatus.setText(dto.getStatus());
        lblMemberId.setText(String.valueOf(dto.getMember().getId()));
        lblReturnDate.setText(String.valueOf(dto.getDueDate()));
    }
}
