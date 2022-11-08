module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.Pharmacy.Project to javafx.fxml;
    exports com.Pharmacy.Project;
}