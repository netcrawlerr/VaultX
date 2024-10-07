module com.netcrawler.vaultx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.netcrawler.vaultx to javafx.fxml;
    opens com.netcrawler.vaultx.controllers to javafx.fxml;
    
    exports com.netcrawler.vaultx;
    exports com.netcrawler.vaultx.controllers;
}
