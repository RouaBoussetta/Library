/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.assistant.ui.register;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import library.assistant.data.model.User;
import library.assistant.ui.login.LoginController;
import library.assistant.util.LibraryAssistantUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RegisterController implements Initializable {
        private final static Logger LOGGER = LogManager.getLogger(RegisterController.class.getName());
    private static RegisterController instance;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private User loggedUser;

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
    @FXML
    private ComboBox<?> role;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/*
    @FXML
    private void handleRegisterButtonAction(ActionEvent event) {
        if (this.validateForm()) {
            preparedStatement = connection.prepareStatement("select * from user where usermail =  ? ");

            preparedStatement.setString(1, email.getText());


            if (!preparedStatement.executeQuery().next()) {

                try {
                    String sql = "INSERT INTO `user` ( username, lastname,pseudoname,usermail,userpassword,"
                            + "roles,userimage) VALUES (?, ?, ?, ?, ?,?,?)";
                    User user = new User();
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, username.getText());
                    preparedStatement.setString(2, lastname.getText());
                    preparedStatement.setString(3, pseudoname.getText());
                    preparedStatement.setString(4, email.getText());
                    preparedStatement.setString(5, password.getText());
                                      preparedStatement.setString(6, password.getText());

                    preparedStatement.setString(7, image.getText());
                   

                    

                    int n = preparedStatement.executeUpdate();
                    if (n > 0) {
                       closeStage();
                    loadLogin();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                this.infoBox("email or cin is  exist", "error");

            }
        }

    }
    
    
    
    */
    public boolean validateForm() {
        mailValidate();
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Input Required");

      /*  if (userCin.getText().toString().length() != 8) {
            error.setText("cin not valid length 8 number required ");
            Integer.parseInt(userCin.getText().toString());

        }*/
        String str = "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?";

        return true;
    }

     
      public boolean mailValidate() {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        RequiredFieldValidator validator = new RequiredFieldValidator();//yvalidy mail
        validator.setMessage("Input Required");
        validator.setMessage("email not valid");
        Matcher matcher = pattern.matcher(email.getText());

        if (matcher.matches()) {//respect mail expression
            error.setText("");

            return true;
        } else {
            error.setText("email not valid");

            email.setText("");
            return false;
        }
    }

    private void infoBox(String infoMessage, String titleBar) {

        {
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }

    }
/*
    public void choose(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ALL files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        String pathsInfo = "";
        pathsInfo += "getPath(): " + file.getPath() + "\n";
        pathsInfo += "getAbsolutePath(): " + file.getAbsolutePath() + "\n";

        pathsInfo += (new File(file.getPath())).isAbsolute();

        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            byte[] res = baos.toByteArray();
            String encodedImage = Base64.getEncoder().encodeToString(baos.toByteArray());
            this.image = encodedImage;
            Path p = Paths.get(file.getPath());

            img.setImage(new Image(file.toURI().toURL().toExternalForm()));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some problem has occurred. Please try again");
        }

        
    }*/
    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }
    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
           closeStage();
                    loadLogin();
    }
    
     void loadLogin() {
        try {
           
            Parent parent = FXMLLoader.load(getClass().getResource("/library/assistant/ui/login/login.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Library Assistant Login");
            stage.setScene(new Scene(parent));
            stage.show();
            LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleRegisterButtonAction(ActionEvent event) {
    }
    
}
