package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.Pharmacy;
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
import java.sql.SQLException;
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
    private PasswordField loginPassword;

    @FXML
    private Label userRole;
    @FXML
    private ChoiceBox<String> userchoice;
    private String[] roles = {"Manager", "Cashier"};

    Pharmacy pharmacy = Pharmacy.getInstance();

    public LoginController() throws SQLException {
    }


    public boolean isUserValid(String username, String password,String role) throws SQLException {
        if (role.equals("Manager") && pharmacy.verifyManager(username,password)){
            return true;
        }
        else if (username.equals("cashier") && password.equals("cashier") && role.equals("Cashier")) {
            return true;
        } else {
            return false;
        }
    }



    public void login(ActionEvent event) throws SQLException {
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

            if (Objects.equals(role, "Manager")) {
                try {
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (Objects.equals(role, "Cashier")) {
                try {
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/CashierPage.fxml")));
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
