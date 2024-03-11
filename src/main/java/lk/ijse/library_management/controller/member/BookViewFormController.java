package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BookService;
import lk.ijse.library_management.service.custom.impl.BookServiceImpl;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.net.URL;
import java.util.ResourceBundle;

public class BookViewFormController implements Initializable {

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label lblId;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblGenre;

    @FXML
    private Label lblAvailability;

    public static int id;

    private final BookService bookService =
            (BookServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        MemberNavigation.closePane();
    }

    @FXML
    void btnCancelOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnCancelOnMouseExited(MouseEvent event) {

    }

    public void setData() {
        BookDto dto = bookService.getBookData(id);

        lblId.setText(String.valueOf(dto.getId()));
        lblTitle.setText(dto.getTitle());
        lblAuthor.setText(dto.getAuthor());
        lblGenre.setText(dto.getGenre());
        lblAvailability.setText(dto.getAvailability());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
