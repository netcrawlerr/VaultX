package com.netcrawler.vaultx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/com/netcrawler/vaultx/FXML/Login.fxml")); 

            Scene scene = new Scene(root);

            // Load CSS
            URL cssUrl = getClass().getResource("/com/netcrawler/vaultx/css/login.css");
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            } else {
                System.err.println("CSS file not found");
            }

            stage.setResizable(false);
            stage.setTitle("VaultX");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
