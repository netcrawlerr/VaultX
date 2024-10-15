package com.netcrawler.vaultx.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.util.Callback;

public class DashboardController {

    @FXML
    private Button addFolder;

    @FXML
    private ListView<String> folderListView; 

    @FXML
    public void initialize() {
         
        folderListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    private HBox hbox;
                    private Label folderLabel;
                    private Button unlockButton;

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setGraphic(null);
                        } else {
                            try {
                                
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/netcrawler/vaultx/FXML/FolderListItem.fxml"));
                                hbox = loader.load();
                                
                              
                                folderLabel = (Label) hbox.lookup("#folderLabel");
                                unlockButton = (Button) hbox.lookup("#unlockButton");

                                
                                folderLabel.setText(item);

                                
                                unlockButton.setOnAction(e -> {
                                    folderListView.getItems().remove(item);  
                                    unlockDirectory(Paths.get(item));  
                                });

                                setGraphic(hbox);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
            }
        });
    }

    @FXML
    public void lockFolder() {
        System.out.println("About To Lock Folder");
        File selectedDirectory = openDirectoryChooser();
        if (selectedDirectory != null) {
             
            lockDirectory(selectedDirectory.toPath());  
        }
    }

    private File openDirectoryChooser() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a Directory");
        File selectedDirectory = directoryChooser.showDialog((Stage) addFolder.getScene().getWindow());
        
        if (selectedDirectory != null) {
            String folderPath = selectedDirectory.getAbsolutePath();  
            System.out.println("Selected Directory: " + folderPath);  
            folderListView.getItems().add(folderPath);  
        } else {
            System.out.println("No directory selected.");
        }
        return selectedDirectory;
    }

    private void lockDirectory(Path path) {
        try {
            
            Files.setAttribute(path, "dos:readonly", true);
            System.out.println("Directory locked: " + path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unlockDirectory(Path path) {
        try {
            
            Files.setAttribute(path, "dos:readonly", false);
            System.out.println("Directory unlocked: " + path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
