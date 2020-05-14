/**
 * Sample Skeleton for 'Sample.fxml' Controller Class
 */

package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController {

    @FXML // fx:id="btn_sign"
    private Button btn_sign; // Value injected by FXMLLoader
    
    @FXML // fx:id= "btn_img"
    private Button btn_img; // Value injected by FXMLLoader
    
    @FXML // fx:id="btn_sign"
    private Button btn_reg; // Value injected by FXMLLoader
    
    @FXML // fx:id="btn_sign"
    private Button btn_enter; // Value injected by FXMLLoader
    
    @FXML // fx:id="btn_sign"
    private Button btn_reg_enter; // Value injected by FXMLLoader
    
    @FXML // fx:id="usr"
    private TextField usr; // Value injected by FXMLLoader
    
    @FXML // fx:id="reg_usr"
    private TextField reg_usr; // Value injected by FXMLLoader

    @FXML // fx:id="pwd"
    private PasswordField pwd; // Value injected by FXMLLoader
    
    @FXML // fx:id="reg_pwd"
    private PasswordField reg_pwd; // Value injected by FXMLLoader
    
    @FXML // fx:id="iamge"
    private ImageView image; // Value injected by FXMLLoader
    
    @FXML // fx:id="pane_1"
    private Pane pane_1; // Value injected by FXMLLoader

    @FXML // fx:id="pane_2"
    private Pane pane_2; // Value injected by FXMLLoader
    
    @FXML // fx:id="stackPane"
    private StackPane stackPane; // Value injected by FXMLLoader
    
    @FXML // fx:id="stackPane1"
    private StackPane stackPane1; // Value injected by FXMLLoader

    @FXML
    void loadSignIn(ActionEvent event) {
       pane_1.toFront();
    }
    
    @FXML
    void loadSignUp(ActionEvent event) {
       pane_2.toFront();
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void loginHandle(ActionEvent event) throws Exception {
	    if(usr.getText().isEmpty() && pwd.getText().isEmpty()) {
	    	dialogToShow(JFXDialog.DialogTransition.CENTER,"Whoah !! You can't enter like this !!","ATTENTION !",stackPane);
    	}
	    else if(usr.getText().isEmpty()) {
	    	dialogToShow(JFXDialog.DialogTransition.CENTER,"Oops, can't let you in, you forgot something :/ ","ATTENTION !",stackPane);
    	}
	    else if(pwd.getText().isEmpty()) {
	    	dialogToShow(JFXDialog.DialogTransition.CENTER,"Oops, can't let you in, you forgot something :/ ","ATTENTION !",stackPane);
    	}
	    else {
	    	try {
	    	User u = new User(usr.getText(),pwd.getText(), "img/pp.png");
	    	JSON_IO_Ops j = new JSON_IO_Ops("json_info/user.json");
	    	
	    	if(j.validateUser(false,u.getPassword()) == true) {
	    	
	    	Window owner = btn_enter.getScene().getWindow();
	    	
	    	Stage s = (Stage) owner;
	    	s.close();

    		FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("nourUI2.fxml"));
    		Parent root1 = (Parent) fxmlloader.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));
    		stage.getIcons().add(new Image("icon.png"));
    		stage.setResizable(false);
    		stage.show();
	    	}
	    	else
	    		dialogToShow(JFXDialog.DialogTransition.CENTER,"Oh oh...wrong password !","ATTENTION !",stackPane1);
	    	}
	    	catch (Exception e) {
	    		System.out.println(e.getMessage());
	    	}
    }
}
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void registerHandle(ActionEvent event) throws Exception{

    	try {

    	if(reg_usr.getText().isEmpty() && reg_pwd.getText().isEmpty()) {
	    	dialogToShow(JFXDialog.DialogTransition.CENTER,"Whoah !! You didn't enter your info ? Go back now !","ATTENTION !",stackPane1);
    	}
    	else if(reg_usr.getText().isEmpty()) {
	    	dialogToShow(JFXDialog.DialogTransition.CENTER,"Oops, can't let you in, you forgot something :/ ","ATTENTION !",stackPane1);
    	}
    	else if(reg_pwd.getText().isEmpty()) {
	    	dialogToShow(JFXDialog.DialogTransition.CENTER,"Oops, can't let you in, you forgot something :/ ","ATTENTION !",stackPane1);
    	}
    	
	    else {
	    	//saving the user info to json
	    	User u = new User(reg_usr.getText(),reg_pwd.getText(),"img/pp.png");
	    	JSON_IO_Ops j = new JSON_IO_Ops("json_info/user.json");

	      	if(j.validateUser(true,u.getUsername()) == true) {
	      	j.saveUserInfo(u);
	      	
	      	//saving the pic
	      	Image im = image.getImage();
	      	File output = new File("img/pp.png");
	      	BufferedImage bImage = SwingFXUtils.fromFXImage(im, null);
	      	ImageIO.write(bImage, "png", output);
	      	
	    	//closing the interface
	      	Window owner = btn_reg_enter.getScene().getWindow();
	    	Stage s = (Stage) owner;
	    	s.close();
	    	
	      	//switching to the other one
    		FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("nourUI2.fxml"));
    		Parent root1 = (Parent) fxmlloader.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));
    		stage.getIcons().add(new Image("icon.png"));
    		stage.setResizable(false);
    		stage.show();
	      	}
	    	else {
	    		dialogToShow(JFXDialog.DialogTransition.CENTER,"You now there can't be two of you right ?","ATTENTION !",stackPane1);
	    	}
	      	}
	    
    	}catch (Exception e){
    		System.out.println(e.getMessage());
    	}
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void chooseFile(ActionEvent event) throws Exception {
    	try{
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Choose your pic : ");
    	fileChooser.getExtensionFilters().addAll(
    		     new FileChooser.ExtensionFilter("JPG Image", "*.jpg")
    		     ,new FileChooser.ExtensionFilter("PNG Image", "*.png")
    			);
    	Window owner = null;
    	File selectedFile = null;
    	owner = btn_img.getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(owner);
        FileInputStream path = new FileInputStream(selectedFile.getPath());
        Image img = new Image(path);
        image.setImage(img);
    	}
    	catch(NullPointerException e){
    		//do nothing
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }


    void dialogToShow(DialogTransition trans,String cnt, String info, StackPane s) {
    	JFXDialogLayout content = new JFXDialogLayout();
    	content.setHeading(new Text(info));
    	content.setBody(new Text(cnt));
    	JFXDialog dialog = new JFXDialog(s , content , trans);
    	JFXButton button = new JFXButton("Done");
    	button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				dialog.close();
			}
    	});
    	content.setActions(button);
    	dialog.show();
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn_sign != null : "fx:id=\"btn_sign\" was not injected: check your FXML file 'main.fxml'.";
        assert btn_reg != null : "fx:id=\"btn_reg\" was not injected: check your FXML file 'main.fxml'.";
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'main.fxml'.";
        assert usr != null : "fx:id=\"usr\" was not injected: check your FXML file 'main.fxml'.";
        assert pwd != null : "fx:id=\"pwd\" was not injected: check your FXML file 'main.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'main.fxml'.";
        assert btn_enter != null : "fx:id=\"btn_enter\" was not injected: check your FXML file 'main.fxml'.";
        assert pane_2 != null : "fx:id=\"pane_2\" was not injected: check your FXML file 'main.fxml'.";
        assert stackPane1 != null : "fx:id=\"stackPane1\" was not injected: check your FXML file 'main.fxml'.";
        assert btn_reg_enter != null : "fx:id=\"btn_reg_enter\" was not injected: check your FXML file 'main.fxml'.";
        assert reg_usr != null : "fx:id=\"reg_usr\" was not injected: check your FXML file 'main.fxml'.";
        assert reg_pwd != null : "fx:id=\"reg_pwd\" was not injected: check your FXML file 'main.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'main.fxml'.";
        assert btn_img != null : "fx:id=\"btn_img\" was not injected: check your FXML file 'main.fxml'.";

    }
}
