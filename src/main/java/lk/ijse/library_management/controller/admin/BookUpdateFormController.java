package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BookService;
import lk.ijse.library_management.service.custom.impl.BookServiceImpl;
import lk.ijse.library_management.util.Regex;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.net.URL;
import java.util.ResourceBundle;

public class BookUpdateFormController implements Initializable {

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnUpdate;

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

    public static int id;

    private BookDto dto;

    private final BookService bookService =
            (BookServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (validate()) {
            dto.setTitle(txtTitle.getText());
            dto.setAuthor(txtAuthor.getText());
            dto.setGenre(txtGenre.getText());

            boolean isUpdated = bookService.updateBook(dto);

            if (isUpdated) {
                AdminNavigation.closePane();
                BookManageFormController.controller.getAllData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Book does not updated !").show();
            }
        }
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
    void btnUpdateOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnUpdateOnMouseExited(MouseEvent event) {

    }

    public void setData() {
        BookDto dto = bookService.getBookData(id);

        txtTitle.setText(dto.getTitle());
        txtAuthor.setText(dto.getAuthor());
        txtGenre.setText(dto.getGenre());

        this.dto = dto;
    }

    @FXML
    void txtAuthorOnAction(ActionEvent event) {
        String name = txtAuthor.getText();

        if (Regex.fullName(name)) {
            lblAuthor.setText("Should contain at least 3 letters");
        } else {
            txtGenre.requestFocus();
        }
    }

    @FXML
    void txtAuthorOnMouseClicked(MouseEvent event) {
        lblAuthor.setText("");
    }

    @FXML
    void txtGenreOnAction(ActionEvent event) {
        String genre = txtGenre.getText();

        if (Regex.genre(genre)) {
            lblGenre.setText("Please enter valid mobile number");
        } else {
            btnUpdateOnAction(event);
        }
    }

    @FXML
    void txtGenreOnMouseClicked(MouseEvent event) {
        lblGenre.setText("");
    }

    @FXML
    void txtTiltleOnMouseClicked(MouseEvent event) {
        lblTitle.setText("");
    }

    @FXML
    void txtTitleOnAction(ActionEvent event) {
        String title = txtTitle.getText();

        if (Regex.title(title)) {
            lblTitle.setText("Should contain at least 3 letters");
        } else {
            txtAuthor.requestFocus();
        }
    }

    public boolean validate() {
        String title = txtTitle.getText();

        if (Regex.title(title)) {
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
