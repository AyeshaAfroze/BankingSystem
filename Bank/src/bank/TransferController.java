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
public class TransferController implements Initializable {

    @FXML
    private TextField searchAcc;
    @FXML
    private TextField name1;
    @FXML
    private TextField transferAmount;
    @FXML
    private Button search;
    @FXML
    private Button transfer;
    @FXML
    private TextField currentbalance;
    @FXML
    private Button profile;
    @FXML
    private Button history;
    @FXML
    private Button deposite;
    @FXML
    private Button withdraw;
    @FXML
    private Button pin;
    @FXML
    private TextField balance;
    @FXML
    private TextField acc;
   // String s1, s2,n,sea;
    String s1, s2, sea, n, s3; //initialize these variable in transfer class

    String b,d;
    int amount,amount1;
    String t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setAcc(String a) { //account textfield show
        acc.setText(a);
        s1 = acc.getText();

    }

    public void setBalance(String n) { //display balance
        balance.setText(n);

        database1 con = new database1();
       //String s=(acc.getText());
        //acc.setText(s);
        con.file();////write

        //acc.setText(a);
    }

    @FXML
    private void search(ActionEvent event) throws IOException, SQLException {  //search method inside transfer class

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank3", "root", "");
        Statement st = conn.createStatement();
        s2 = searchAcc.getText();
        database1 co = new database1();

        //String query = "SELECT * FROM signup ";
        String query = "select * from signup ";

        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            n = rs.getString("name");
            sea = rs.getString("acc");
            t=rs.getString("balance");
            System.out.println(n);
            if (s2.equals(sea)) {
                name1.setText(n);
                break;
            }
        }

        // name1.setText(n);
        // saveinfo(s);
        //  rs = st.executeQuery(query);
        /*   System.out.println("Results from the query:\n ");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String section = rs.getString("section");

                System.out.println("ID: " + id + " Name: " + name + " Address: " + address + " Section: " + section);*/
        //  }
        //  name1.setText(n);
    }

    @FXML
    private void transfer(ActionEvent event) throws IOException {
      
        d = transferAmount.getText();
        database1 d2 = new database1();

        //String code=code1.getText();
        // if(code.equals("999"))
        b = balance.getText();
        //d = amountOfDeposition.getText();
        System.out.println(d);//////////
        System.out.println(b);
        int d1 = Integer.parseInt(d);
        //amount=b-d;
        int b1 = Integer.parseInt(b);
        int amount = b1 - d1;
        String amount1 = String.valueOf(amount);
        System.out.println(amount);
        currentbalance.setText(amount1);
        d2.updatebalance(amount1, s1);
        
        int l= Integer.parseInt(t);
        int a=l+d1;
        
        String amount2=String.valueOf(a);
        
        
        
        d2.updatebalance(amount2, s2);

    }

    @FXML
    private void profile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("profile.fxml"));
        Parent NewParent = loader.load();
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();
        ProfileController p = loader.getController();
        //database1 con= new database1();
        database1 con = new database1();
        con.file();////read

        String s1 = con.getacc();
        String s2 = con.getName();

        p.setAcc(s1);

        String s3 = con.getDOB();
        String s4 = con.getNat();
        String s5 = con.getbalance();
        String s6 = con.getAd();
        String s7 = con.getphone();
        String s8 = con.getMail();

        p.setInfo(s2, s3, s4, s5, s6, s7, s8);//display

    }

    @FXML
    private void deposite(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("deposite.fxml"));
        Parent NewParent = loader.load();
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();
        database1 con = new database1();
        con.file();////read
        String s1 = con.getacc();
        String s2 = con.getbalance();
        DepositeController j1 = loader.getController();
        j1.setAcc(s1);
        j1.setBalance(s2);
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
        database1 con = new database1();
        con.file();////read
        String s1 = con.getacc();
        String s2 = con.getbalance();
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

}
