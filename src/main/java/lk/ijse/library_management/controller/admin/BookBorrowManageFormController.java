package lk.ijse.library_management.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.TransactionService;
import lk.ijse.library_management.service.custom.impl.TransactionServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookBorrowManageFormController implements Initializable {

    @FXML
    public JFXTextField txtSearch;

    @FXML
    public JFXButton btnReset;


    @FXML
    private VBox vBox;

    public List<TransactionDto> updateList;

    public static BookBorrowManageFormController controller;

    private final TransactionService transactionService =
            (TransactionServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.TRANSACTION);



    public BookBorrowManageFormController() {
        controller = this;
        updateList = new ArrayList<>();
    }

    @FXML
    public void txtSearchOnAction(ActionEvent actionEvent) {
        int id = -1;

        try {

            id = Integer.parseInt(txtSearch.getText());

        } catch (NumberFormatException e) {

            id = transactionService.getMemberIdFormMobile(txtSearch.getText());
        }

        if (id > 0) {
            List<TransactionDto> data = transactionService.getAllTransactionDataToId(id);
            getAllData(data);
            txtSearch.clear();
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid member !").show();
            txtSearch.clear();
        }
    }

    @FXML
    public void txtSearchOnMouseClicked(MouseEvent mouseEvent) {

    }

    @FXML
    public void btnResetOnAction(ActionEvent actionEvent) {
        invokeGetAllData();
    }

    @FXML
    public void btnResetOnMouseEntered(MouseEvent mouseEvent) {

    }

    @FXML
    public void btnResetOnMouseExited(MouseEvent mouseEvent) {

    }

    public void invokeGetAllData() {
        List<TransactionDto> data = transactionService.getAllTransactionData();

        if (data == null) {
            data = new ArrayList<>();
        }
        getAllData(data);
    }

    public void getAllData(List<TransactionDto> data) {

        vBox.getChildren().clear();

        for(TransactionDto dto : data) {
            loadDataTable(dto);
        }
    }

    private void loadDataTable(TransactionDto dto) {
        try {
            FXMLLoader loader = new FXMLLoader(BookBorrowManageFormController.class.getResource("/view/admin/BookBorrowManageRowForm.fxml"));
            Parent root = loader.load();
            BookBorrowManageRowFormController controller = loader.getController();
            controller.setData(dto);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invokeGetAllData();

        if (!updateList.isEmpty()) {
            transactionService.updateTransactionStatus(updateList);
        }
    }
}
