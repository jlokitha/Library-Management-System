package lk.ijse.library_management.controller.member;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.dto.BookDto;
import lk.ijse.library_management.dto.TransactionDetailsDto;
import lk.ijse.library_management.dto.TransactionDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.TransactionService;
import lk.ijse.library_management.service.custom.impl.TransactionServiceImpl;
import lk.ijse.library_management.util.navigation.MemberNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookBorrowViewFormController implements Initializable {

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private Label labelTotal;

    @FXML
    private JFXTextField txtIssedDate;

    @FXML
    private JFXTextField txtMemberMobile;

    @FXML
    private JFXTextField txtDueDate;

    @FXML
    private JFXTextField txtTransactionId;

    public static int id;

    private final TransactionService transactionService =
            (TransactionServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.TRANSACTION);

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

    public void getAllData(List<TransactionDetailsDto> detailsDtos) {

        vBox.getChildren().clear();

        for(TransactionDetailsDto dto : detailsDtos) {
            loadDataTable(dto.getBook());
        }
    }

    private void loadDataTable(BookDto dto) {
        try {
            FXMLLoader loader = new FXMLLoader(BookBorrowViewFormController.class.getResource("/view/member/BookBorrowViewRowForm.fxml"));
            Parent root = loader.load();
            BookBorrowViewRowFormController controller = loader.getController();
            controller.setData(dto);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TransactionDto dto = transactionService.getTransactionData(id);

        List<TransactionDetailsDto> detailsDtos = transactionService.getTransactionDetails(dto);

        txtTransactionId.setText(String.valueOf(dto.getId()));
        txtMemberMobile.setText(dto.getMember().getMobile());
        txtMemberName.setText(dto.getMember().getName());
        txtIssedDate.setText(String.valueOf(dto.getAddedDate()));
        txtDueDate.setText(String.valueOf(dto.getDueDate()));


        getAllData(detailsDtos);
    }
}
