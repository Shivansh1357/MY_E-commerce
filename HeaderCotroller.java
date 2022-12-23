package com.example.myecommerce;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class HeaderCotroller {
    @FXML
    Button loginButton;
    @FXML
    Label email;
    @FXML
    TextField searchText;
    @FXML
    Button logoutButton;


    @FXML
    public void initialize(){
        if (!HelloApplication.emailId.equals("")){
            loginButton.setOpacity(0);
            email.setText(HelloApplication.emailId);
        }
    }
    @FXML
    public void login(MouseEvent e)throws IOException{
        AnchorPane loginPage=FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        HelloApplication.root.getChildren().add(loginPage);
    }
    @FXML
    public void search(MouseEvent e) throws IOException, SQLException {
        productPage productPage=new productPage();

        Header header=new Header();
        AnchorPane productPane=new AnchorPane();
        productPane.getChildren().add(productPage.productBySearch(searchText.getText()));
        productPane.setLayoutX(150);
        productPane.setLayoutY(100);
        HelloApplication.root.getChildren().clear();
        HelloApplication.root.getChildren().addAll(header.root,productPane);
    }

    @FXML
    public void logoutappear(MouseEvent e){
        if(logoutButton.getOpacity()==0){
            logoutButton.setOpacity(1);
        }else{
            logoutButton.setOpacity(0);
        }
    }
    @FXML
    public void logout(MouseEvent e) throws IOException {
        if(logoutButton.getOpacity()==1) {
            HelloApplication.emailId = "";
            logoutButton.setOpacity(0);
            Header header = new Header();
            HelloApplication.root.getChildren().add(header.root);
        }
    }
}


