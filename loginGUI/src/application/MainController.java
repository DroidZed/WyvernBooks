/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn_sign"
    private Button btn_sign; // Value injected by FXMLLoader
    
    @FXML // fx:id="btn_sign"
    private Button btn_reg; // Value injected by FXMLLoader

    @FXML // fx:id="usr"
    private TextField usr; // Value injected by FXMLLoader

    @FXML // fx:id="pwd"
    private PasswordField pwd; // Value injected by FXMLLoader

    @FXML
    void loginHandle(ActionEvent event) throws Exception {
    	Window owner = btn_sign.getScene().getWindow();
	    if(usr.getText().isEmpty() && pwd.getText().isEmpty()) {
	        AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your username & password !");
            return;
    	}
	    if(usr.getText().isEmpty()) {
	        AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your username !");
            return;
    	}
	    if(pwd.getText().isEmpty()) {
	        AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your password !");
            return;
    	}
	    else {
	    	try {
	    	User u = new User(usr.getText(),pwd.getText());
	    	
	    	JSON_IO_Ops j = new JSON_IO_Ops("json_info/user.json"); 
	    	
	    	j.saveUserInfo(u);
	    	
	    	Stage s = (Stage) owner;
	    	
	    	s.close();

    		FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("booksMain.fxml"));
    		Parent root1 = (Parent) fxmlloader.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));
    		stage.getIcons().add(new Image("icon.png"));
    		stage.setResizable(false);
    		stage.show();
    	}catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
	    }

    }
    @FXML
    void registerHandle(ActionEvent event) {
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_sign != null : "fx:id=\"btn_sign\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btn_reg != null : "fx:id=\"btn_reg\" was not injected: check your FXML file 'Sample.fxml'.";
        assert usr != null : "fx:id=\"usr\" was not injected: check your FXML file 'Sample.fxml'.";
        assert pwd != null : "fx:id=\"pwd\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
