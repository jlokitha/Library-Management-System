package lk.ijse.library_management.util.navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.StageStyle;
import lk.ijse.library_management.controller.admin.AdminGlobalLoginFormController;
import lk.ijse.library_management.controller.admin.SignInFormController;
import lk.ijse.library_management.controller.member.MemberGlobalFormController;


import java.io.IOException;

public class MemberNavigation {

    private static Parent parent;
    private static Stage stage;
    private static Scene scene;

    public static void switchNavigation(String path, ActionEvent event) throws IOException {
        parent = FXMLLoader.load(AdminNavigation.class.getResource("/view/member/" + path));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SignInFormController.stage = stage;
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void switchPaging(String path) throws IOException {
        MemberGlobalFormController.getInstance().pagingPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(AdminNavigation.class.getResource("/view/member/"+path));
        Parent root = loader.load();
        MemberGlobalFormController.getInstance().pagingPane.getChildren().add(root);
    }

    public static void popupPane(String path) throws IOException {

        MemberGlobalFormController.getInstance().popUpPane.setVisible(true);
        MemberGlobalFormController.getInstance().imgGreyBack.setVisible(true);

        AnchorPane root = FXMLLoader.load(AdminNavigation.class.getResource("/view/member/" + path));

        Stage popupStage = new Stage();
        MemberGlobalFormController.getInstance().setPopupStage(popupStage);
        popupStage.setScene(new Scene(root));
        popupStage.centerOnScreen();
        popupStage.initOwner(MemberGlobalFormController.getInstance().popUpPane.getScene().getWindow());
        popupStage.initStyle(StageStyle.UNDECORATED);
        popupStage.show();
    }

    public static void switchLoginPage(String path) throws IOException {
        AdminGlobalLoginFormController.getInstance().loginPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(AdminNavigation.class.getResource("/view/member/"+path));
        Parent root = loader.load();
        AdminGlobalLoginFormController.getInstance().loginPane.getChildren().add(root);
    }

    public static void closePane(){
        MemberGlobalFormController.getInstance().popUpPane.getChildren().clear();
        MemberGlobalFormController.getInstance().popupStage.close();
        MemberGlobalFormController.getInstance().popUpPane.setVisible(false);
        MemberGlobalFormController.getInstance().imgGreyBack.setVisible(false);
    }

}