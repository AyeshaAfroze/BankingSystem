/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC FiX
 */
public class AboutController implements Initializable {

    @FXML
    private Button back1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
       Parent NewParent = FXMLLoader.load(getClass().getResource("page.fxml"));
          Scene NewScene=new Scene(NewParent);
          Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(NewScene);
          window.show();
    }
    
}
