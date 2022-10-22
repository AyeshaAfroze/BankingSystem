/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC FiX
 */
public class DepositeController implements Initializable {

    @FXML
    private Button profile;
    @FXML
    private Button history;
    @FXML
    private Button tansfer;
    @FXML
    private Button deposite;
    @FXML
    private Button deposition;
    @FXML
    private Button withdraw;
    @FXML
    private Button pin;
    @FXML
    private TextField balance;
    @FXML
    private TextField amountOfDeposition;
    @FXML
    private TextField currentBalance;
    @FXML
    private TextField code1;
    @FXML
    private TextField acc1;
    String s, d, b,s1;
    int amount;

    //balance.setText("ssh");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        
    }
    
        public void setAcc(String a){ //account textfield show
        acc1.setText(a);
        s1=acc1.getText();
        
        
    }
        
         public void  setBalance(String n){ //display balance
        balance.setText(n);
     
       database1 con=new database1();
       //String s=(acc.getText());
       //acc.setText(s);
       con.file();////write
       
        //acc.setText(a);
    }
    
    
    
    
    
    
    
    

 /*   public void setAcc(String a) {
        acc1.setText(a);
        s = acc1.getText();

        System.out.println(s);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank3", "root", "");//connection of database

            //create statement
            Statement m = conn.createStatement();//creating statement
            // String s1 = acc1.getText();
            String query = "select balance from signup where acc='" + s + "' ";

            ResultSet rs = m.executeQuery(query);

            while (rs.next()) {
                b = rs.getString("balance");

                balance.setText(b);
            }
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(DepositeController.class.getName()).log(Level.SEVERE, null, ex);
        }

      
        
        
     
        

    }*/

    public void depositCalculation() {
        int d1 = Integer.parseInt(d);
        //amount=b-d;
       int b1 = Integer.parseInt(b);
       
       
        amount = b1 - 1;
        String amount1 = String.valueOf(amount);

        currentBalance.setText(amount1);

    }

    @FXML
    private void profile(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("profile.fxml"));
        Parent NewParent = loader.load();
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();
        //PageController p=loader.getController();
        //p.profile(event);
        ProfileController p=loader.getController();
        //database1 con= new database1();
        database1 con=new database1();
                con.file();////read
                
              String s1= con.getacc();
              String s2=con.getbalance();
              
              p.setAcc(s1);
              
        
        String s3= con.getDOB();
        String s4=con.getNat();
        String s5=con.getbalance();
        String s6=con.getAd();
        String s7=con.getphone();
        String s8=con.getMail();
        
        p.setInfo(s2, s3, s4, s5, s6, s7,s8);//display


    }

    @FXML
    private void history(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("history.fxml"));
        Parent NewParent = loader.load();
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();

    }

    @FXML
    private void transfer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("transfer.fxml"));
        Parent NewParent = loader.load();
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();
           database1 con=new database1();
                con.file();////read
                 String s1= con.getacc();
              String s2=con.getbalance();
                 TransferController j2 = loader.getController();
                j2.setAcc(s1);
                j2.setBalance(s2);

    }

    @FXML
    private void withdraw(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("withdraw.fxml"));
        Parent NewParent = loader.load();
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();
        database1 con=new database1();
                con.file();////read
                 String s1= con.getacc();
              String s2=con.getbalance();
                 WithdrawController j1 = loader.getController();
                j1.setAcc(s1);
                j1.setBalance(s2);

    }

    @FXML
    private void pin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("pin.fxml"));
        Parent NewParent = loader.load();
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();

    }

    @FXML
    private void deposition(ActionEvent event) {
     database1 d2=new database1(); /// whole code in deposites controller deposition action event
        
        String code=code1.getText();
        if(code.equals("999"))
        {
           b = balance.getText();
         d = amountOfDeposition.getText();
        System.out.println(d);//////////
        System.out.println(b);
        int d1 = Integer.parseInt(d);
        //amount=b-d;
        int b1 = Integer.parseInt(b);
        amount = b1+d1;
        String amount1 = String.valueOf(amount);
        System.out.println(amount);
        currentBalance.setText(amount1);
        d2.updatebalance(amount1, s1);
        }
        
        
        
        
        }
    }


