module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.Pharmacy.Project to javafx.fxml;
    exports com.Pharmacy.Project;
    exports com.Pharmacy.Project.Controllers;
    opens com.Pharmacy.Project.Controllers to javafx.fxml;
}