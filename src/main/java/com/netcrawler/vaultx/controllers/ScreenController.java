package com.netcrawler.vaultx.controllers;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenController { 

    private Stage stage;
    private Scene scene;
   

  
    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException{
           Parent root = FXMLLoader.load(getClass().getResource("/com/netcrawler/vaultx/FXML/Dashboard.fxml")) ;
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
    }

   
    @FXML
    public void switchToLogin(ActionEvent event) throws IOException{
           Parent root = FXMLLoader.load(getClass().getResource("/com/netcrawler/vaultx/FXML/Login.fxml")) ;
           stage = ((Stage)((Node)event.getSource()).getScene().getWindow());
           scene = new Scene(root);
           URL cssUrl = getClass().getResource("/com/netcrawler/vaultx/css/login.css");
           if (cssUrl != null) {
               scene.getStylesheets().add(cssUrl.toExternalForm());
           } else {
               System.err.println("CSS file not found");
           }
           stage.setScene(scene);
           stage.show();
    }
}
