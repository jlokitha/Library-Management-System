package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BookService;
import lk.ijse.library_management.service.custom.impl.BookServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookManageFormController implements Initializable {

    @FXML
    public JFXTextField txtSearch;

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private ImageView imgAdd;

    @FXML
    private Label lblAdd;

    public static BookManageFormController controller;

    public BookManageFormController() {
        controller = this;
    }

    private final BookService bookService =
            (BookServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);

    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        try {
            AdminNavigation.popupPane("BookAddForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnAddOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void btnAddOnMouseExited(MouseEvent event) {

    }

    @FXML
    public void txtSearchOnAction(ActionEvent actionEvent) {
        int id = -1;

        try {

            id = Integer.parseInt(txtSearch.getText());

        } catch (NumberFormatException e) {

            id = bookService.getBookIdFormTitle(txtSearch.getText());

        }

        if (id > 0) {
            try {
                BookViewFormController.id = id;
                AdminNavigation.popupPane("BookViewForm.fxml");
                txtSearch.clear();
            } catch (IOException e) {
                AdminGlobalFormController.getInstance().popUpPane.setVisible(false);
                AdminGlobalFormController.getInstance().imgGreyBack.setVisible(false);
            }
        }
    }

    @FXML
    public void txtSearchOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void getAllData() {

        List<BookDto> data = bookService.getAllBookData();

        vBox.getChildren().clear();

        for(BookDto dto : data) {
            if (!dto.getAvailability().equals("Removed")) {
                loadDataTable(dto);
            }
        }
    }

    private void loadDataTable(BookDto dto) {
        try {
            FXMLLoader loader = new FXMLLoader(BookManageFormController.class.getResource("/view/admin/BookManageRowForm.fxml"));
            Parent root = loader.load();
            BookManageRowFormController controller = loader.getController();
            controller.setData(dto);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAllData();
    }
}
