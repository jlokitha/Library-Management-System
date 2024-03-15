package lk.ijse.library_management.controller.member;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.projection.AdminTransactionProjection;
import lk.ijse.library_management.projection.MemberTransactionProjection;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.DashboardService;
import lk.ijse.library_management.service.custom.impl.DashboardServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    public Label lblTotBorrowBooks;

    @FXML
    private VBox vBoxTransaction;

    @FXML
    private Label lblTotBooks;

    @FXML
    private Label lblTotReturned;

    @FXML
    private Label lblTotDue;

    private final DashboardService dashboardService =
            (DashboardServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.DASHBOARD);


    public void setLabelData() {
        int id = dashboardService.getMemberIdFormUsername(MemberGlobalFormController.username);

        MemberDto dto = dashboardService.getMemberData(id);

        lblTotBooks.setText(String.valueOf(dashboardService.getMemberReadBookCount(dto)));

        lblTotBorrowBooks.setText(String.valueOf(dashboardService.getMemberBorrowBookCount(dto)));

        lblTotReturned.setText(String.valueOf(dashboardService.getMemberReturnedCount(dto)));

        lblTotDue.setText(String.valueOf(dashboardService.getMemberDueCount(dto)));

        loadTransactionData(dto);
    }

    public void loadTransactionData(MemberDto dto) {
        List<MemberTransactionProjection> list = dashboardService.getAllTransactionsOfMember(dto);

        if (list != null) {
            vBoxTransaction.getChildren().clear();

            for (MemberTransactionProjection projection : list) {
                loadDataTable(projection);
            }
        }
    }

    private void loadDataTable(MemberTransactionProjection dto) {
        try {
            FXMLLoader loader = new FXMLLoader(lk.ijse.library_management.controller.member.DashboardFormController.class.getResource("/view/member/TransactionShortcutRowForm.fxml"));
            Parent root = loader.load();
            TransactionShortcutRowFormController controller = loader.getController();
            controller.setData(dto);
            vBoxTransaction.getChildren().add(root);
        } catch (IOException e) {

        }
    }

    @Override
    public void initialize(URL url , ResourceBundle resourceBundle) {
        setLabelData();
    }
}
