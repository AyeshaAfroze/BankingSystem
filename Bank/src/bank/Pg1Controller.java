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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
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
public class Pg1Controller implements Initializable {

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
    private TextField password;
    @FXML
    private TextField name;
    @FXML
    private Button createAccount;
    @FXML
    private TextField pin;
    @FXML
    private TextField acc;
    @FXML
    private Button login;
    @FXML
    private Button about;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void createAccount(ActionEvent event) throws SQLException {
        
        String s1=name.getText();
        String s2=dob.getText();
        String s3=nat.getText();
        String s6=gen.getText();
        
        String s7=ad.getText();
        String s8=phn.getText();
        String s9=email.getText();
        String s4=password.getText();
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank3","root","");//connection of database
        
        //create statement
        Statement m=conn.createStatement();//creating statement
       
        
        
        String sql = "insert into signup values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s4+"','"+s6+"',',"+s7+"','"+s8+"','"+s9+"')"; //updating data
        
        //String s1= " update  employees set email='hhh' set last name='abul' set 1st name='kabul' where id=11 " ;
        //int f=m.executeUpdate(s1);
        int r=m.executeUpdate(sql);
        
        System.out.println(r);
              
    }

    @FXML
    private void profile(ActionEvent event) throws IOException {
         Parent NewParent = FXMLLoader.load(getClass().getResource("profile.fxml"));
          Scene NewScene=new Scene(NewParent);
          Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(NewScene);
          window.show();    
          
    }

    @FXML
    private void about(ActionEvent event) throws IOException {
         Parent NewParent = FXMLLoader.load(getClass().getResource("about.fxml"));
          Scene NewScene=new Scene(NewParent);
          Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(NewScene);
          window.show();
    }
    
}
