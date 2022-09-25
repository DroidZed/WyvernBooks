package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Window;

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

	@FXML
	private Hyperlink nra;

	@FXML
	private Hyperlink ad;
	
	@FXML // fx:id="txtf"
	private TextFlow txtf; // Value injected by FXMLLoader
	
    @FXML // fx:id="pic"
    private JFXButton pic; // Value injected by FXMLLoader
    
    @FXML // fx:id="sp"
    private ScrollPane sp; // Value injected by FXMLLoader
    
    @FXML // fx:id="scrl"
    private AnchorPane scrl; // Value injected by FXMLLoader
    
    @FXML // fx:id="fp"
    private FlowPane fp; // Value injected by FXMLLoader
    
    @FXML // fx:id="stp"
    private StackPane stp; // Value injected by FXMLLoader

    @FXML // fx:id="grp"
    private Group grp; // Value injected by FXMLLoader

    @FXML // fx:id="cb"
    private JFXComboBox<String> cb; // Value injected by FXMLLoader
    
    @FXML // fx:id="slds"
    private ImageView slds; // Value injected by FXMLLoader
    
    @FXML // fx:id = "bDone"
    private JFXButton bDone; // sending data through this button
    
    @FXML // fx:id="srh"
    private JFXButton srh; // search btn

    @FXML // fx:id="tfo"
    private TextFlow tfo; // text flow for answers
    
    @FXML // fx:id="sfield"
    private JFXTextField sfield; // search field of the bar
    
    @FXML // fx:id="bname"
    private JFXTextField bname; // Value injected by FXMLLoader

    @FXML // fx:id="aname"
    private JFXTextField aname; // Value injected by FXMLLoader

    @FXML // fx:id="dpk"
    private JFXDatePicker dpk; // Value injected by FXMLLoader

    @FXML // fx:id="sldr"
    private JFXSlider sldr; // Value injected by FXMLLoader

	@FXML
    void addPics(ActionEvent event) {
    	try{
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Choose your pic : ");
    	fileChooser.getExtensionFilters().addAll(
    		     new FileChooser.ExtensionFilter("JPG Image", "*.jpg")
    		     ,new FileChooser.ExtensionFilter("PNG Image", "*.png")
    			);
    	Window owner = null;
    	File selectedFile = null;
    	ImageView i = new ImageView();
    	owner = pic.getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(owner);
    	Image img = new Image(new FileInputStream(selectedFile.getPath()));

    	i.setFitHeight(368);
	   	i.setFitWidth(637);
    	i.setLayoutX(0);
    	i.setLayoutY(0);
        i.setImage(img);
        fp.getChildren().add(i);
        scrl.setPrefHeight(i.getFitHeight() + fp.getVgap() + scrl.getPrefHeight());
    	}
    	catch(NullPointerException e){
    	//do nothing really...
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
	@FXML
	List<String> sendData(ActionEvent event) {

		String bType = null;
		String authName = aname.getText();
		String bookName = bname.getText();
		LocalDate date = dpk.getValue();
		double BorrP = sldr.getValue();
		for(String s : cb.getItems()) {
			if(s != "")
				bType = s;
		}
		
		List<String> lst = new ArrayList<String>();
		
		lst.add(authName);
		lst.add(bookName);
		lst.add(date.toString());
		lst.add(String.valueOf(BorrP));
		lst.add(bType);
		
		System.out.println(date.toString());	
		return lst;
	}
	
	@FXML
	void fSearch(ActionEvent event) {
		List<String> rest = sendData(event);
		
		for(String s : rest) {
			System.out.println(s);
		}
		
		
		System.out.println(sfield.getText());
		System.out.println(bname.getText());
		
		if(sfield.getText() != bname.getText()) {

			Text an,bn,dt,sld,cbx;
			
			an = new Text();
			bn = new Text();
			dt = new Text();
			sld = new Text();
			cbx = new Text();
			
			an.setText("Author : "+aname.getText()+"\n");
			bn.setText("Book : "+bname.getText()+"\n");
			dt.setText("Addition date : "+dpk.getValue().toString()+"\n");
			sld.setText("Nb. of Pages : "+String.valueOf((int)(sldr.getValue()))+"\n");
			String v = null;
			for(String s : cb.getItems()) {
				if(s != "")
					v = s;
			}
			cbx.setText("Type : "+v+"\n");
			
			an.setFont(new Font("Segio Script", 30));
			bn.setFont(new Font("Segio Script", 30));
			dt.setFont(new Font("Segio Script", 30));
			sld.setFont(new Font("Segio Script", 30));
			cbx.setFont(new Font("Segio Script", 30));
			
			tfo.setTextAlignment(TextAlignment.LEFT);
			tfo.getChildren().addAll(an,bn,dt,sld,cbx);

		}
		
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		try {
	    	cb.getItems().add("romantic");
	    	cb.getItems().add("drama");
	    	cb.getItems().add("action");
			AnchorPane box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));
			drawer.setSidePane(box);
			for (javafx.scene.Node node : box.getChildren()) {
				if (node.getAccessibleText() != null) {
					node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
						switch (node.getAccessibleText()) {
							case "Add Book":
								pane_1.toFront();
								break;

							case "Browse":
								pane_2.toFront();
								break;

							case "Gallery":
								pane_4.toFront();
								break;

							case "About":
								pane_3.toFront();
								break;

							case "Exit":
								System.exit(0);
								break;
						}
					});
				}
			}
			HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
			burgerTask2.setRate(-1);
			hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
				burgerTask2.setRate(burgerTask2.getRate() * -1);
				burgerTask2.play();
				if (drawer.isOpened()) {
					drawer.close();
				} else {
					drawer.open();
				}
			});
		nra = new Hyperlink();
		nra.setText("Drissi Nour Amine");
		nra.setOnAction(new EventHandler <ActionEvent> (){
			public void handle(ActionEvent e) {
				try {
				    Desktop.getDesktop().browse(new URL("https://www.facebook.com/profile.php?id=100009172362259").toURI());
				} catch (IOException e1) {
				    e1.printStackTrace();
				} catch (URISyntaxException e1) {
				    e1.printStackTrace();
				}
			}
		});
		ad = new Hyperlink();
		ad.setText("Dhahri Aymen");
		ad.setOnAction(new EventHandler <ActionEvent> (){
			public void handle(ActionEvent e) {
				try {
				    Desktop.getDesktop().browse(new URL("https://www.linkedin.com/in/aymen-d").toURI());
				} catch (IOException e1) {
				    e1.printStackTrace();
				} catch (URISyntaxException e1) {
				    e1.printStackTrace();
				}
			}
		});
		final Text t1,t2,t3,n,a;
		
		t1 = new Text();
		t2 = new Text();
		t3 = new Text();
		n = new Text();
		a = new Text();
		
		t1.setText("Wyvern\n");
		t1.setFont(new Font("Verdana", 30));
		
		t2.setText("Simple and cool pic browser & book viewer app for your convenience.\nMade with JavaFx + JFoenix. \n");
		t2.setFont(new Font("Verdana", 20));

		t3.setText("Made by :\n");
		t3.setFont(new Font("Verdana", 20));
		
		n.setText("Drissi Nour Amine");
		n.setFont(new Font("Verdana", 20));
		
		a.setText("\tDhahri Aymen\n");
		a.setFont(new Font("Verdana", 20));
		
		txtf.setLineSpacing(10.0);
		txtf.setLayoutX(txtf.getLayoutX()-70);
		txtf.setLayoutY(txtf.getLayoutY()-20);
		txtf.setTextAlignment(TextAlignment.CENTER);
		
		txtf.getChildren().addAll(t1,t2,t3,n,a,nra,ad);
		} catch (Exception e1) {
				e1.printStackTrace();
		}
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert pane_3 != null : "fx:id=\"pane_3\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert txtf != null : "fx:id=\"txtf\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert pane_4 != null : "fx:id=\"pane_4\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert sp != null : "fx:id=\"sp\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert scrl != null : "fx:id=\"scrl\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert stp != null : "fx:id=\"stp\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert pic != null : "fx:id=\"pic\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert fp != null : "fx:id=\"fp\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert pane_2 != null : "fx:id=\"pane_2\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert sfield != null : "fx:id=\"sfield\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert srh != null : "fx:id=\"srh\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert tfo != null : "fx:id=\"tfo\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert pane_1 != null : "fx:id=\"pane_1\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert cb != null : "fx:id=\"cb\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert bDone != null : "fx:id=\"bDone\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert bname != null : "fx:id=\"bname\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert aname != null : "fx:id=\"aname\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert dpk != null : "fx:id=\"dpk\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert sldr != null : "fx:id=\"sldr\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert hamburger != null : "fx:id=\"hamburger\" was not injected: check your FXML file 'nourUI2.fxml'.";
        assert drawer != null : "fx:id=\"drawer\" was not injected: check your FXML file 'nourUI2.fxml'.";
	}
	
}