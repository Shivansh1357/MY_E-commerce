package com.example.myecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginPageController {
    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @FXML
    public void login(MouseEvent e) throws SQLException, IOException {
        String query=String.format("select * from user where emailId= '%s' AND PASS= '%s' ",email.getText(),password.getText());
        //query="select * from user where emailId= 'Shivanshtripathi1357@gmail.com' AND pass=  'Shiv@nsh1357';
        ResultSet res=HelloApplication.connection.executeQuery(query);
        if(res.next()){
            HelloApplication.emailId=res.getString("emailId");

            String userType=res.getString("userType");
            if(userType.equals("Seller")){
                AnchorPane sellerpage= FXMLLoader.load(getClass().getResource("sellerpage.fxml"));
                HelloApplication.root.getChildren().add(sellerpage);
            }
            else{
                System.out.println("We are logged in As Buyer");
                productPage productPage=new productPage();

                Header header=new Header();
                AnchorPane productPane=new AnchorPane();
                productPane.getChildren().add(productPage.products());
                productPane.setLayoutX(150);
                productPane.setLayoutY(100);
                HelloApplication.root.getChildren().clear();
                HelloApplication.root.getChildren().addAll(header.root,productPane);
            }
            System.out.println("the user is present");
        }else{
            Dialog<String> dialog=new Dialog<>();
            dialog.setTitle("login");
            ButtonType type=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("Login Failed! Please check userName, PassWord");
            dialog.showAndWait();
        }

    }
}
