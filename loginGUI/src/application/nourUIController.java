package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.sun.istack.internal.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class nourUIController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="anchorPane"
    private AnchorPane anchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="hamburger"
    private JFXHamburger hamburger; // Value injected by FXMLLoader

    @FXML // fx:id="drawer"
    private JFXDrawer drawer; // Value injected by FXMLLoader
    

    @FXML // fx:id="pane_1"
    private Pane pane_1; // Value injected by FXMLLoader

    @FXML // fx:id="pane_2"
    private Pane pane_2; // Value injected by FXMLLoader

    @FXML // fx:id="pane_3"
    private Pane pane_3; // Value injected by FXMLLoader

    @FXML // fx:id="pane_4"
    private Pane pane_4; // Value injected by FXMLLoader
    
    @FXML // fx:id="content"
    private Pane content; // Value injected by FXMLLoader


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	try {
			AnchorPane box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
		
    			
    	drawer.setSidePane(box);
    	   
    	for (javafx.scene.Node node : box.getChildren()) {
    		if (node.getAccessibleText() != null) {
    			node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
    				
                         switch(node.getAccessibleText()){ 
                           case "home":
                             pane_1.toFront();     
                               break;
                           
                           case "browse":
                        	   pane_2.toFront();
                               break;   
                               
                           case "about": 
                        	   pane_3.toFront();
                                break;  
                                
                           case "news":   
                        	   pane_4.toFront();
                                break;  
                                
                           case "exit":  
                        	   System.exit(0);
                                break; 

                  
                       
                         }
      
    			});
    		}
    	}
    	
    	
    	
    	
    	
    	HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
    	 burgerTask2.setRate(-1);
    	 hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) ->{
    		 burgerTask2.setRate(burgerTask2.getRate() * -1);
    		 burgerTask2.play();
    		 
    		 if (drawer.isOpened()) {
    		        drawer.close();
    		    } else {
    		        drawer.open();
    		    }
    		 
    		 
    	 });
    	} catch (IOException e1) {
			Logger.getLogger(nourUIController.class.getName(), null);
		}
    	
    	
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'nourUI.fxml'.";
        assert hamburger != null : "fx:id=\"hamburger\" was not injected: check your FXML file 'nourUI.fxml'.";
        assert drawer != null : "fx:id=\"drawer\" was not injected: check your FXML file 'nourUI.fxml'.";

    }
}