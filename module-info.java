module com.example.myecommerce {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.myecommerce to javafx.fxml;
    exports com.example.myecommerce;
}