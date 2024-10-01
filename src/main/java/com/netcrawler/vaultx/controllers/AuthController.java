package com.netcrawler.vaultx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthController {

    @FXML
    private TextField username; // Must match fx:id="username" in FXML

    @FXML
    private PasswordField password; // Must match fx:id="password" in FXML

    @FXML
    private void handleLogin() {
        String user = username.getText();
        String pass = password.getText();
        loginUser(user, pass);
    }

    public static void loginUser(String username, String password) {
        System.out.println("username is :" + username);
        System.out.println("password is :" + password);
    }
}
