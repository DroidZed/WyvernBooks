/**
 * Sample Skeleton for 'booksMain.fxml' Controller Class
 */
package application ;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class booksMainController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn1"
    private Button btn1; // Value injected by FXMLLoader

    @FXML // fx:id="btn2"
    private Button btn2; // Value injected by FXMLLoader

    @FXML // fx:id="btn3"
    private Button btn3; // Value injected by FXMLLoader

    @FXML // fx:id="btn4"
    private Button btn4; // Value injected by FXMLLoader

    @FXML // fx:id="pane1"
    private Pane pane1; // Value injected by FXMLLoader

    @FXML // fx:id="pane2"
    private Pane pane2; // Value injected by FXMLLoader

    @FXML // fx:id="pane3"
    private Pane pane3; // Value injected by FXMLLoader

    @FXML // fx:id="pane4"
    private Pane pane4; // Value injected by FXMLLoader
    
    @FXML // fx:id="slide"
    private AnchorPane slide; // Value injected by FXMLLoader

    @FXML
    void authorhandle(ActionEvent event) {
    		pane2.toFront();
    }
    @FXML
    void bookHandle(ActionEvent event) {
    	pane1.toFront();
    }
    @FXML
    void themeHandle(ActionEvent event) {
    	pane3.toFront();
    }
    @FXML
    void closeHandle(ActionEvent event) {
    	
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert slide != null : "fx:id=\"slide\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert btn4 != null : "fx:id=\"btn4\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert pane2 != null : "fx:id=\"pane2\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert pane3 != null : "fx:id=\"pane3\" was not injected: check your FXML file 'booksMain.fxml'.";
        assert pane4 != null : "fx:id=\"pane4\" was not injected: check your FXML file 'booksMain.fxml'.";

    }
  
    
   
}
