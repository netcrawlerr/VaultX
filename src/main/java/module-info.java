module com.netcrawler.vaultx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.netcrawler.vaultx to javafx.fxml;
    exports com.netcrawler.vaultx;
    exports com.netcrawler.vaultx.controllers;
    opens com.netcrawler.vaultx.controllers to javafx.fxml;
}