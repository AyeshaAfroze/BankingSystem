/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC FiX
 */
public class PinController implements Initializable {

    @FXML
    private Button profile;
    @FXML
    private Button history;
    @FXML
    private Button tansfer;
    @FXML
    private Button deposite;
    @FXML
    private Button withdraw;
    @FXML
    private Button pin;
    @FXML
    private TextField newPin;
    @FXML
    private Button changePin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void profile(ActionEvent event) {
    }

    @FXML
    private void history(ActionEvent event) {
    }

    @FXML
    private void transfer(ActionEvent event) {
    }

    @FXML
    private void deposite(ActionEvent event) {
    }

    @FXML
    private void withdraw(ActionEvent event) {
    }

    @FXML
    private void changePin(ActionEvent event) {
    }
    
}
