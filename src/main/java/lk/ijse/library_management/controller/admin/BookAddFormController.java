package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BookService;
import lk.ijse.library_management.service.custom.impl.BookServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

public class BookAddFormController {

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtGenre;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblGenre;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private Label lblTitle;

    private final BookService bookService =
            (BookServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);

    @FXML
    void btnAddOnAction(ActionEvent event) {

        if (validate()) {
            boolean isSaved = bookService.saveBook(new BookDto(
                    -1,
                    txtTitle.getText(),
                    txtAuthor.getText(),
                    txtGenre.getText(),
                    "Available",
                    null,
                    null,
                    null
            ));

            if (isSaved) {
                AdminNavigation.closePane();
                BookManageFormController.controller.getAllData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Book does not saved !").show();
            }
        }
    }

    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

    }

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

    @FXML
    void txtAuthorOnAction(ActionEvent event) {

    }

    @FXML
    void txtAuthorOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtGenreOnAction(ActionEvent event) {

    }

    @FXML
    void txtGenreOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtTiltleOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtTitleOnAction(ActionEvent event) {

    }

    public boolean validate() {
        String title = txtTitle.getText();

        if (Regex.fullName(title)) {
            lblTitle.setText("Should contain at least 3 letters");
            return false;
        }

        String name = txtAuthor.getText();

        if (Regex.fullName(name)) {
            lblAuthor.setText("Should contain at least 3 letters");
            return false;
        }

        String genre = txtGenre.getText();

        if (Regex.genre(genre)) {
            lblGenre.setText("Please enter valid mobile number");
            return false;
        }

        return true;
    }

}
