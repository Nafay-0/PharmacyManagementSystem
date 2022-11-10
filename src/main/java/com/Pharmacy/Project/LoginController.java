package com.Pharmacy.Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button loginButton;
    @FXML
    private TextField loginId;
    @FXML
    private TextField loginPassword;

    @FXML
    private Label userRole;
    @FXML
    private ChoiceBox<String> userchoice;
    private String[] roles = {"Manager", "Cashier"};






    public boolean isUserValid(String username, String password,String role) {
        if (username.equals("admin") && password.equals("admin") && role.equals("Manager")) {
            return true;
        } else {
            return false;
        }
    }

    public void login(ActionEvent event) {
        String username = loginId.getText();
        String password = loginPassword.getText();
        String role = userchoice.getValue();
        if (isUserValid(username, password,role)) {
            System.out.println("Login Successful");
            // show login alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("Welcome " + username);
            alert.showAndWait();

            // redirect to new page AdminPage.fxml
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminPage.fxml")));
                Stage stage = (Stage) scenePane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login Failed");
            // show alert for invalid credentials
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Invalid Credentials");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // clear the fields
        loginId.clear();
        loginPassword.clear();
        // add the roles to the choice box
        userchoice.getItems().addAll(roles);
        // set the default value
        userchoice.setValue("Manager");
        userchoice.setOnAction(event -> {
//            userRole.setText(userchoice.getValue());
        });


    }
}