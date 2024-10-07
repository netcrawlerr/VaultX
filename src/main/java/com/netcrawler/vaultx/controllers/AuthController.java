package com.netcrawler.vaultx.controllers;

import java.io.IOException;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthController {
    
    ScreenController screenController = new ScreenController();

    @FXML
    private TextField username;

    @FXML
    private PasswordField password; 

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel; 

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String user = username.getText();
        String pass = password.getText();
        loginUser(event, user, pass); 
    }

    public void loginUser(ActionEvent event, String username, String password) throws IOException {
        System.out.println("is empty ? " + username.isEmpty());
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Fields cannot be empty");
            System.out.println("Both fields can't be empty");
            return;
        } 
        else{
            
            System.out.println(username);
            System.out.println(password);
            screenController.switchToDashboard(event);
        }
        
    }
}
