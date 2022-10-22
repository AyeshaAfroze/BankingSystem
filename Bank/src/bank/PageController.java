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
public class PageController implements Initializable {

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
    @FXML
    private TextField accountNumber;
    
    @FXML
    private TextField show;
    //   String na;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    

    }

   

    @FXML
    private void createAccount(ActionEvent event) throws SQLException {
        String s1 = name.getText();
        String s2 = dob.getText();
        String s3 = nat.getText();
        String s6 = gen.getText();
        String s4 = accountNumber.getText();

        String s7 = ad.getText();
        String s8 = phn.getText();
        String s9 = email.getText();
        String s5 = password.getText();
        String s10 = "0";

        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank3", "root", "");//connection of database
        database1 con = new database1();
        con.insertData(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
         show.setText("Account Created");
        
    }

    

    @FXML
    public void profile(ActionEvent event) throws IOException, SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank3", "root", "");//connection of database

        //create statement
        Statement m = conn.createStatement();//creating statement
        String s = acc.getText();
        
      
        database1 con = new database1();
        String s3 = con.getData(s);///get pin
        database1 c =new database1();
            c.inFile(s);
        
       // String g=con.getacc();
      

        String s2 = pin.getText();
      

        if (s2.equals(s3)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("profile.fxml"));
            Parent NewParent = loader.load();
            Scene NewScene = new Scene(NewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(NewScene);
            window.show();

            ProfileController j = loader.getController();
            j.setAcc(s);///set acc

            String query2 = "select name,dob,nationality,balance,ad,phn,email from signup where acc='" + s + "' ";
            ResultSet r2 = m.executeQuery(query2);

            while (r2.next()) {
                String d = r2.getString("dob");
                String na = r2.getString("name");
                String n1 = r2.getString("nationality");

                String b = r2.getString("balance");
                String a = r2.getString("ad");

                String p = r2.getString("phn");
                String e = r2.getString("email");
                j.setInfo(na, d, n1, b, a, p, e);//display( method in profile

            }
        }
        else
        {
            show.setText("LOGIN FAILED");
        }

    }

    @FXML
    private void about(ActionEvent event) throws IOException {
        Parent NewParent = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene NewScene = new Scene(NewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(NewScene);
        window.show();
    }
    
     

}
