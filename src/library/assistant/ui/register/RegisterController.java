/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.assistant.ui.register;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RegisterController implements Initializable {
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField pseudoname;
    @FXML
    private JFXTextField image;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label error;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleRegisterButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
    }
    
}
