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
import lk.ijse.library_management.dto.BranchDto;
import lk.ijse.library_management.entity.Branch;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.BranchService;
import lk.ijse.library_management.service.custom.impl.BranchServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BranchManageFormController implements Initializable {

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

    public static BranchManageFormController controller;

    public BranchManageFormController() {
        controller = this;
    }

    private final BranchService branchService =
            (BranchServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void btnAddBranchOnAction(ActionEvent event) {
        try {
            AdminNavigation.popupPane("BranchAddForm.fxml");
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

            id = branchService.getIdFormLocation(txtSearch.getText());
        }

        if (id > 0) {
            try {
                BranchViewFormController.id = id;
                AdminNavigation.popupPane("BranchViewForm.fxml");
            } catch (IOException e) {
                AdminGlobalFormController.getInstance().popUpPane.setVisible(false);
                AdminGlobalFormController.getInstance().imgGreyBack.setVisible(false);
            }
        }
        txtSearch.clear();
    }

    @FXML
    public void txtSearchOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void getAllData() {
        List<BranchDto> data = branchService.getAllBranchData();

        vBox.getChildren().clear();

        for(BranchDto dto : data) {
            loadDataTable(dto);
        }

    }

    private void loadDataTable(BranchDto dto) {
        try {
            FXMLLoader loader = new FXMLLoader(BranchManageFormController.class.getResource("/view/admin/BranchManageRowForm.fxml"));
            Parent root = loader.load();
            BranchManageRowFormController controller = loader.getController();
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
