package com.example.myecommerce;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Orders {
    void placeorder(String productId) throws SQLException {
        ResultSet res=HelloApplication.connection.executeQuery("Select max(OrderId) as orderId from orders");
        int orderId=1;
        if(res.next()){
            orderId=res.getInt("orderId")+1;
        }
        Date date=new Date(System.currentTimeMillis());
        String query= String.format("Insert into orders values(%s, %s, '%s', '%s')",orderId,productId,HelloApplication.emailId,date);
        int response=HelloApplication.connection.executeUpdate(query);
        if(response>0){
            Dialog<String>dialog=new Dialog<>();
            dialog.setTitle("Order");
            ButtonType  type=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.setContentText("Your Order is Placed");
            dialog.showAndWait();

            System.out.println("the order is placed");
        }else{
            System.out.println("the order is Not placed");
        }
    }
}
