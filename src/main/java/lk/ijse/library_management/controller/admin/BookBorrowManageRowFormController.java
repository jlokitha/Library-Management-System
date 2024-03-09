package lk.ijse.library_management.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;

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
    private ImageView imgPrint;

    @FXML
    void imgPrintOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void imgPrintOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void imgPrintOnMouseExited(MouseEvent event) {

    }

    @FXML
    void imgViewOnMouseClicked(MouseEvent event) {
        try {
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

}
