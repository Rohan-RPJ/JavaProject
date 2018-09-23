/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sirji
 */
public class JavaProject extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        //setting full screen 
        //primaryStage.setFullScreen(true); 
        
        //Setting gridPane as layout for the page
        GridPane page_1 = new GridPane();
        
        //making gridlines visible
        //page_1.setGridLinesVisible(true);
        
        //css effects for page_1 i.e. gridpane
        page_1.setId("page");
       
        //setting gaps between rows and columns of grid 
        page_1.setHgap(10);
        page_1.setVgap(10);
        
        //padding of gridpane in scene
        page_1.setPadding(new Insets(50,50,50,50));
        
        //Logo Image
        Image logo = new Image(JavaProject.class.getResourceAsStream("air-logo.png")); 
        ImageView logo_view = new ImageView(logo);
        
        //adding logo image to gridpane
        page_1.add(logo_view,0,0);
        
        //setting size of image logo
        logo_view.setFitHeight(150);
        logo_view.setFitWidth(200);
        
        
        //scenetitle
        Label scenetitle = new Label("Welcome To AeroSwing Flights...");
       
        //adding css effects to label welcome-label
        scenetitle.setId("welcome-label");
        page_1.add(scenetitle, 1,0,4,2);
        
        //Radio Buttons 
        RadioButton trip_option_1 = new RadioButton("Round Trip");
        RadioButton trip_option_2 = new RadioButton("One Way Trip");
        
        //ToggleGroup to select any one option for RadioButtons
        ToggleGroup group = new ToggleGroup();
        trip_option_1.setToggleGroup(group);
        trip_option_2.setToggleGroup(group);
        
        //Setting Title for radioButtons
        Text select_trip_text = new Text("Select Your Trip");
        select_trip_text.setId("text");
        
        //adding trip text and radio buttons to page
        page_1.add(select_trip_text, 0,3,2,1);
        page_1.add(trip_option_1,0,4);
        page_1.add(trip_option_2,0,5);
        
        //Journeydetails-text
        Text jour_detail_text = new Text("Enter Your Journey Details");
        jour_detail_text.setId("text");
        page_1.add(jour_detail_text,0,7,2,1);
        
        //Text for From:
        Text from_state_text = new Text("Journey From :");
        page_1.add(from_state_text,0,9);
        
        //ComboBox for Source States
        ComboBox from_state_list = new ComboBox();
        from_state_list.getItems().addAll("Maharashtra","Gujarat","Rajasthan","Goa","Uttar Pradesh");
        page_1.add(from_state_list,1,9);
        
        //css effects for combobox from_state_list
        from_state_list.setId("combobox");
        
        //text for To:
        Text to_state_text = new Text("To Destination:");
        page_1.add(to_state_text,0,13);
        
        //ComboBox for Destination States
        ComboBox to_state_list = new ComboBox();
        to_state_list.getItems().addAll("Maharashtra","Gujarat","Rajasthan","Goa","Uttar Pradesh");
        page_1.add(to_state_list,1,13);
        
        //css effects for comobox to_state_list
        to_state_list.setId("combobox");
        
        //Label if source state not selected
        Label select_state_label = new Label(" first select your journey place");
        page_1.add(select_state_label, 1, 11);
        
        //setAction to find airports if any of the Source states is selected 
        from_state_list.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override 
            public void handle(ActionEvent e)
            {
                select_state_label.setText("");
                ComboBox from_airport_box;
                if(from_state_list.getValue()=="Maharashtra" && to_state_list.getValue()!="Maharashtra")
                {     
                    //Airports for Maharashtra
                    from_airport_box = new ComboBox();
                    from_airport_box.getItems().addAll("Chhatrapati Shivaji Airport","Pune Airport","Kolhapur Airport");                   
                }
                else if(from_state_list.getValue()=="Gujarat" && to_state_list.getValue()!="Gujarat")
                {      
                    //Airports for Gujarat
                    from_airport_box = new ComboBox();
                    from_airport_box.getItems().addAll("Surat Airport","Rajkot Airport","Bhuj Airport");
                }
                else if(from_state_list.getValue()=="Rajasthan" && to_state_list.getValue()!="Rajasthan")
                {
                    //Airports for Rajasthan
                    from_airport_box = new ComboBox();
                    from_airport_box.getItems().addAll("Jaipur Airport","Jaisalmer Airport","Kota Airport");
                }
                else if(from_state_list.getValue()=="Goa" && to_state_list.getValue()!="Goa")
                {
                    //Airport for Goa
                    from_airport_box = new ComboBox();
                    from_airport_box.getItems().addAll("Dabolim Airport");
                } 
                else if(from_state_list.getValue()=="Uttar Pradesh" && to_state_list.getValue()!="Uttar Pradesh")
                {        
                    //Airports for Uttar Pradesh
                    from_airport_box = new ComboBox();
                    from_airport_box.getItems().addAll("Agra Civil Enclave","Allahbad Airport","Kanpur Airport");
                }
                else
                {
                    //if no airport selected
                    from_airport_box = new ComboBox();
                }
                //set size of ComboBox
                from_airport_box.setMaxSize(150,50);
                //css effects for comobox from_airport_box
                from_airport_box.setId("combobox");
                page_1.add(from_airport_box,1,11);
            }          
        });
        
        //text for Select Airport:
        Text from_text = new Text("Select Airport :");
        page_1.add(from_text,0,11);       
           
        //Label if destination state not selected
        Label dest_state_label = new Label(" first select your destination place");
        page_1.add(dest_state_label, 1, 15);
        
        //setAction to find airports if any of the Destination states is selected 
        to_state_list.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override            
            public void handle(ActionEvent e)
            {
                dest_state_label.setText("");
                ComboBox to_airport_box;
                if(to_state_list.getValue()=="Maharashtra" && from_state_list.getValue()!="Maharashtra")
                {        
                    //Airports for Maharashtra
                    to_airport_box = new ComboBox();
                    to_airport_box.getItems().addAll("Chhatrapati Shivaji Airport","Pune Airport","Kolhapur Airport");                   
                }
                else if(to_state_list.getValue()=="Gujarat" && from_state_list.getValue()!="Gujarat")
                {                      
                    //Airports for Gujarat
                    to_airport_box = new ComboBox();
                    to_airport_box.getItems().addAll("Surat Airport","Rajkot Airport","Bhuj Airport");
                }
                else if(to_state_list.getValue()=="Rajasthan" && from_state_list.getValue()!="Rajasthan")
                {
                    //Airports for Rajasthan
                    to_airport_box = new ComboBox();
                    to_airport_box.getItems().addAll("Jaipur Airport","Jaisalmer Airport","Kota Airport");
                }
                else if(to_state_list.getValue()=="Goa" && from_state_list.getValue()!="Goa")
                {
                    //Airports for Dabolim
                    to_airport_box = new ComboBox();
                    to_airport_box.getItems().addAll("Dabolim Airport");
                } 
                else if(to_state_list.getValue()=="Uttar Pradesh" && from_state_list.getValue()!="Uttar Pradesh")
                {      
                    //Airports for Uttar Pradesh
                    to_airport_box = new ComboBox();
                    to_airport_box.getItems().addAll("Agra Civil Enclave","Allahbad Airport","Kanpur Airport");
                }
                else
                {
                    //if source and destination states are equal
                    Text warning = new Text("Select different State");
                    page_1.add(warning,1,15);
                    to_airport_box = new ComboBox();
                }
                to_airport_box.setMaxSize(150,50);
                page_1.add(to_airport_box,1,15);
                
                //css effects for comobox to_airport_box
                to_airport_box.setId("combobox");
            }          
        });
        
        //Text for Destination Airport
        Text to_text = new Text("Destination Airport :");
        page_1.add(to_text,0,15);       
        
        //Text for Class
        Text select_class = new Text("Select Class :");
        page_1.add(select_class,0,18);
        
        //ComboBox for selecting Class
        ComboBox class_list = new ComboBox();
        class_list.getItems().addAll("Economy","Business","First");
        page_1.add(class_list,1,18);
        
        //css effects for comobox class_list
        class_list.setId("combobox");
        
        //Text for number of person
        Text person_count = new Text("Number of Persons :");
        page_1.add(person_count,0,19);
        
        //css effects for comobox person_count
        person_count.setId("combobox");
        
        //ComboBox for selecting Class
        ComboBox person_count_list = new ComboBox();
        person_count_list.getItems().addAll("1","2","3","4");
        page_1.add(person_count_list,1,19);
        
        //Text for account details 
        Text account_text = new Text("Enter Your Account Details");
        account_text.setId("text");
        page_1.add(account_text,0,21,3,1);
        
        //
        Text username_text = new Text("Username :");
        page_1.add(username_text,0,22);
        
        //
        TextField username_tf = new TextField();
        username_tf.setPromptText("Enter Username");  
        page_1.add(username_tf,1,22);
        //T
        Text passwd_text = new Text("Password :");
        page_1.add(passwd_text,0,23);      
        
        //
        PasswordField passwd_pf = new PasswordField();
        passwd_pf.setPromptText("Enter Password");
        page_1.add(passwd_pf,1,23);
        
        //forgot_password?
        Hyperlink forgot_pw = new Hyperlink("(forgot password ?)");
        page_1.add(forgot_pw,0,24);
        forgot_pw.setId("forgot-pw");
        
        //
        /*forgot_pw.setOnAction(e ->{   
                   
            new NewAccount(); 
            
        }); */
        
        //
        Button sign_in_btn = new Button("Sign in");
        page_1.add(sign_in_btn, 0, 28);
        
        //
        Button sign_up_btn = new Button("Sign up");
        page_1.add(sign_up_btn, 1, 28);
        
        sign_in_btn.setOnAction(e->{
           Stage stage = new Stage();
           stage.setTitle("Abc");
           stage.show();
        });
    
        
        
        
        ScrollPane rootPane = new ScrollPane();
        rootPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        rootPane.setVbarPolicy(ScrollBarPolicy.ALWAYS); 
        rootPane.setFitToHeight(true);
        rootPane.setFitToWidth(true); 
        //rootPane.setVmax(2);
        //rootPane.setHmax(2);
        //rootPane.setVvalue(20);
        rootPane.setContent(page_1);   
        
        
        
        //instantiating scene
        Scene scene = new Scene(rootPane, 1000, 600);
        
        scene.getStylesheets().add(JavaProject.class.getResource("JavaProject.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("AeroSwing National Flights");
        //primaryStage.setResizable(false);
        primaryStage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
