package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.util.navigation.AdminNavigation;

public class BookBorrowViewFormController {

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label labelTotal;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblQty;

    @FXML
    private JFXTextField txtIssedDate;

    @FXML
    private JFXTextField txtMemberMobile;

    @FXML
    private JFXTextField txtDueDate;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        AdminNavigation.closePane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

}
