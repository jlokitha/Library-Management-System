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
import lk.ijse.library_management.dto.MemberDto;
import lk.ijse.library_management.service.ServiceFactory;
import lk.ijse.library_management.service.custom.MemberService;
import lk.ijse.library_management.service.custom.impl.MemberServiceImpl;
import lk.ijse.library_management.util.navigation.AdminNavigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberManageFormController implements Initializable {

    @FXML
    public JFXTextField txtSearch;

    @FXML
    private VBox vBox;

    public static MemberManageFormController controller;

    public MemberManageFormController() {
        controller = this;
    }

    private final MemberService memberService =
            (MemberServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);

    @FXML
    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            int id = memberService.getMemberIdFormMobile(txtSearch.getText());
            MemberViewFormController.id = id;
            AdminNavigation.popupPane("MemberViewForm.fxml");
            txtSearch.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void txtSearchOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void getAllData() {

        List<MemberDto> data = memberService.getAllMemberData();

        vBox.getChildren().clear();

        for(MemberDto dto : data) {
            loadDataTable(dto);
        }
    }

    private void loadDataTable(MemberDto dto) {
        try {
            FXMLLoader loader = new FXMLLoader(BookManageFormController.class.getResource("/view/admin/MemberManageRowForm.fxml"));
            Parent root = loader.load();
            MemberManageRowFormController controller = loader.getController();
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
