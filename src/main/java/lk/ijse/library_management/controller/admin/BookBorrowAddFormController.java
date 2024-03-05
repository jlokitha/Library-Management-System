package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class BookBorrowAddFormController {

    @FXML
    private JFXComboBox<?> cmbMobile;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private JFXButton btnAddBook;

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnBorrow;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXComboBox<?> cmbBookTitle;

    @FXML
    private Label labelTotal;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblDesc;

    @FXML
    private Label lblStockId;

    @FXML
    private Label lblQty;

    @FXML
    private JFXTextField txtIssedDate;

    @FXML
    private JFXDatePicker dpReturningDate;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddBookOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddBookOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void btnBorrowOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnBorrowOnMouseExited(MouseEvent event) {

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    @FXML
    void cmbBookTitleOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookTitleOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void cmbMobileOnAction(ActionEvent event) {

    }

    @FXML
    void cmbMobileOnMouseClicked(MouseEvent event) {

    }

}
