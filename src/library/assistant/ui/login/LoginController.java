package library.assistant.ui.login;

import Utils.DataBase;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import library.assistant.data.model.User;
import library.assistant.util.LibraryAssistantUtil;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(LoginController.class.getName());
    private static LoginController instance;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private User loggedUser;

    @FXML
    private javafx.scene.control.Label error;

    @FXML
    private JFXTextField userMail;
    @FXML
    private JFXPasswordField userPassword;
    @FXML
    private javafx.scene.control.Label register;

    public LoginController() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public static LoginController getInstance() {
        return instance;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public boolean mailandpasswordValidate() {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(userMail.getText());
        if (userPassword.getText().length() < 8) {
            error.setText("*password length < 8 ");

        }

        if (matcher.matches()) {
            error.setText("");

            return true;
        } else {
            error.setText("*mail not valid");
            return false;
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String email = userMail.getText();
        String password = userPassword.getText();
        mailandpasswordValidate();
        if (mailandpasswordValidate()) {
            String sql = "SELECT * FROM admin WHERE usermail = ? and userpassword = ?;";

            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    error.setText("failed please verifiy your email or password");
                } else {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    error.setText("");
                    closeStage();
                    loadMain();
            LOGGER.log(Level.INFO, "admin successfully logged in {}", email);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            userMail.getStyleClass().add("wrong-credentials");
            userPassword.getStyleClass().add("wrong-credentials");
        }

    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        System.exit(0);
    }

    private void closeStage() {
        ((Stage) userMail.getScene().getWindow()).close();
    }

    /* 
     public void changeScenex(ActionEvent actionEvent) throws IOException {

     Node node = (Node) actionEvent.getSource();
     Stage dialogStage = (Stage) node.getScene().getWindow();
     Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/REGISTER.fxml")));
     dialogStage.setScene(scene);
     dialogStage.show();

     }

     public void resetPage(MouseEvent actionEvent) throws IOException {

     Parent root = FXMLLoader.load(getClass().getResource("/GUI/resetMail.fxml"));

     Scene scene = loginButton.getScene();

     root.translateXProperty().set(scene.getWidth());

     Pane parentContainer = (Pane) scene.getRoot();
     parentContainer.getChildren().add(root);

     Timeline timeline = new Timeline();
     KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
     KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
     timeline.getKeyFrames().add(kf);
     timeline.setOnFinished(event1 -> {
     parentContainer.getChildren().remove(container);
     });
     timeline.play();

     }
     */
    private void infoBox(String infoMessage, String titleBar) {

        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/library/assistant/ui/main/main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Library Assistant");
            stage.setScene(new Scene(parent));
            stage.show();
            LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }
    

    void loadRegister() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/library/assistant/ui/register/register.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Register");
            stage.setScene(new Scene(parent));
            stage.show();
            LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @FXML
    private void createAccountAction(MouseEvent event) {
         closeStage();
         loadRegister();
        
    }

}
