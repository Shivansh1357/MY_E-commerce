package com.example.myecommerce;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {

    public static dataBaseConnection connection;
    public static Group root;
    public static String emailId;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        emailId ="";
        connection=new dataBaseConnection();
        root=new Group();
        Header header=new Header();
        productPage productPage=new productPage();
        AnchorPane productPane=new AnchorPane();
        productPane.getChildren().add(productPage.products());
        productPane.setLayoutX(150);
        productPane.setLayoutY(100);
        root.getChildren().addAll(header.root,productPane);

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("E-Commerce");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e ->{
            try {
                connection.con.close();
                System.out.println("Connection is closed");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


    }

    public static void main(String[] args) {
        launch();
    }
}