/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
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
public class ProfileController implements Initializable {

    @FXML
    private Button profile;
    @FXML
    private Button history;
    @FXML
    private Button transfer;
    @FXML
    private Button deposite;
    @FXML
    private Button withdraw;
    @FXML
    private Button pin;
    @FXML
    private TextField name;
    @FXML
    private TextField dob;
    @FXML
    private TextField nat;
    @FXML
    private TextField gen;
    @FXML
    private TextField ad;
    @FXML
    private TextField phn;
    @FXML
    private TextField email;
    @FXML
    private TextField acc;
    
    
    String s1,s2;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database1 con=new database1();
       //String s=(acc.getText());
       //acc.setText(s);
      // con.file();
       //con.fileRead();
        
    }
   
    public void setAcc(String a){ //account textfield show
        acc.setText(a);
        s1=acc.getText();
        
        
    }
    public void setfile(){
       
        //s2
        
        
    }
    public void  setInfo(String n,String d,String nationality,String b,String add,String p,String e){ //display all except acc
        name.setText(n);
        dob.setText(d);
        nat.setText(nationality);
        gen.setText(b);
        ad.setText(add);
        phn.setText(p);
        email.setText(e);
       database1 con=new database1();
       //String s=(acc.getText());
       //acc.setText(s);
       con.file();////write
       
        //acc.setText(a);
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
    private void deposite(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("deposite.fxml"));
                Parent NewParent = loader.load();
                Scene NewScene = new Scene(NewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(NewScene);
                window.show();
                database1 con=new database1();
                con.file();
                 
                
              String s1= con.getacc();
              String s2=con.getbalance();
                 DepositeController j1 = loader.getController();
                j1.setAcc(s1);
                j1.setBalance(s2);
               // con.fileRead();
                 
                
          
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
                //WithdrawController j1 = loader.getController();
                //j1.setAcc1(s1);
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
    
}
