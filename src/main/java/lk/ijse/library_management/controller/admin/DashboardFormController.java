package lk.ijse.library_management.controller.admin;

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
import lk.ijse.library_management.projection.TransactionProjection;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.DashboardService;
import lk.ijse.library_management.service.custom.impl.DashboardServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    public JFXButton btnSearch;

    @FXML
    public Label lblSearch;

    @FXML
    public JFXTextField txtMemberId;

    @FXML
    private VBox vBoxTransaction;

    @FXML
    private Label lblTotMembers;

    @FXML
    private Label lblTotBooks;

    @FXML
    private Label lblTotDue;

    @FXML
    private Label lblTotBranches;

    private final DashboardService adminDashboardService =
            (DashboardServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.DASHBOARD);

    public void setCounts() {
        lblTotMembers.setText(String.valueOf(adminDashboardService.getMemberCount()));

        lblTotBooks.setText(String.valueOf(adminDashboardService.getBookCount()));

        lblTotDue.setText(String.valueOf(adminDashboardService.getDueTransactionCount()));

        lblTotBranches.setText(String.valueOf(adminDashboardService.getBranchCount()));
    }

    public void loadTransactionData() {
        List<TransactionProjection> list = adminDashboardService.getAllTransactions();

        if (list != null) {
            vBoxTransaction.getChildren().clear();

            for (TransactionProjection dto : list) {
                loadDataTable(dto);
            }
        }
    }

    private void loadDataTable(TransactionProjection dto) {
        try {
            FXMLLoader loader = new FXMLLoader(DashboardFormController.class.getResource("/view/admin/TransactionShortcutRowForm.fxml"));
            Parent root = loader.load();
            TransactionShortcutRowFormController controller = loader.getController();
            controller.setData(dto);
            vBoxTransaction.getChildren().add(root);
        } catch (IOException e) {

        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        int id = -1;

        try {
            id = Integer.parseInt(txtMemberId.getText());

        } catch (NumberFormatException e) {

            id = adminDashboardService.getMemberIdFormMobile(txtMemberId.getText());
        }

        if (id > 0) {
            try {
                MemberViewFormController.id = id;
                AdminNavigation.popupPane("MemberViewForm.fxml");
            } catch (IOException e) {
                AdminGlobalFormController.getInstance().popUpPane.setVisible(false);
                AdminGlobalFormController.getInstance().imgGreyBack.setVisible(false);
            }
        }

        txtMemberId.clear();
    }

    public void btnAddAttendanceMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnAddAttendanceMouseExited(MouseEvent mouseEvent) {

    }

    public void txtMemberIdOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    @Override
    public void initialize(URL url , ResourceBundle resourceBundle) {
        setCounts();
        loadTransactionData();
    }
}
