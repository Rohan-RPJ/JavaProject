/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window_1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Rohan
 */
public class Forgot_Password extends Window_1{
    Forgot_Password(){
        //new account page
    Stage new_passwd_page = new Stage();
    new_passwd_page.setTitle("Forgot Password");
            
    //GridPane Layout 
    GridPane new_passwd_pane = new GridPane();
                        
    //making gridlines visible
    new_passwd_pane.setGridLinesVisible(true); 
                
    //
    new_passwd_pane.setAlignment(Pos.TOP_CENTER);          
            
    //scenetitle
    Label new_passwd_scene_title = new Label();
    new_passwd_scene_title.setText("Create new Password"); 
    new_passwd_pane.add(new_passwd_scene_title,0,0,3,2);
    
    //css effects for label
    new_passwd_scene_title.setId("text");
    
     
       
    //setting gaps between rows and columns of grid 
    new_passwd_pane.setHgap(10);
    new_passwd_pane.setVgap(10);
        
    //padding of gridpane in scene
    new_passwd_pane.setPadding(new Insets(50,50,50,50));
            
    //
    new_passwd_pane.centerShapeProperty();
            
    //
    Text user_id = new Text("User Id :");
    new_passwd_pane.add(user_id,0,3);
    //css effects same as that for text on 1st page 
    user_id.setId("page");  
            
    //
    TextField user_id_tf = new TextField();
    user_id_tf.setPromptText("Enter your user id");
    new_passwd_pane.add(user_id_tf,1,3);
   // user_id_tf.setText(null);
            
    //
    Text new_passwd = new Text("New Password :");
    new_passwd_pane.add(new_passwd,0,5);
    
    //css effects same as that for text on 1st page 
    new_passwd.setId("page");
             
    //
    PasswordField new_passwd_pf = new PasswordField();
    new_passwd_pf.setPromptText("Enter new Password");
    new_passwd_pane.add(new_passwd_pf,1,5);
    //new_passwd_pf.setDisable(true);
    
        
    //
    Label passwd_alert = new Label();
    passwd_alert.setText("Password should be atleast 5 characters long");
    new_passwd_pane.add(passwd_alert,0,6,3,1);
    
    //
    Text confirm_passwd = new Text("Confirm Password :");
    new_passwd_pane.add(confirm_passwd,0,8);
    
    //css effects same as that for text on 1st page 
    confirm_passwd.setId("page");
             
    //
    PasswordField confirm_passwd_pf = new PasswordField();
    confirm_passwd_pf.setPromptText("Confirm Password");
    new_passwd_pane.add(confirm_passwd_pf,1,8);
    
    //
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent e)
        {
            if(user_id_tf.getText().isEmpty())
            {    
                Alert enter_id = new Alert(AlertType.INFORMATION);
                enter_id.setTitle("Enter User Id and Password"); 
                enter_id.setContentText("First enter your User Id then Password");
                enter_id.show();
                new_passwd_pf.setText(null);
                confirm_passwd_pf.setText(null);
            }  
        }
    };
    //
    new_passwd_pf.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
    
    //    
    confirm_passwd_pf.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
  
    //
    Button change_pw_btn = new Button("Change Password");
    new_passwd_pane.add(change_pw_btn,1,10);
    change_pw_btn.setOnAction(new EventHandler<ActionEvent>(){
        
        @Override
        public void handle(ActionEvent e)
        {
            
            if(!confirm_passwd_pf.getText().equals(new_passwd_pf.getText()))
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Re-enter Password"); 
                alert.setContentText("Passwords don't match");
                alert.show();
            }
            if(new_passwd_pf.getText().length()<5 && confirm_passwd_pf.getText().length()<5)
            {
                Alert warning = new Alert(AlertType.WARNING);
                warning.setTitle("Re-enter Password"); 
                warning.setContentText("Length of Password should be atleast 4 characters long");
                warning.show();
            }
            else 
            {
                Alert confirmation = new Alert(AlertType.CONFIRMATION,"Confirmation",ButtonType.YES,ButtonType.NO);
                confirmation.setContentText("Confirm Change Password ?"); 
                confirmation.show();
                
                if(confirmation.getResult()==ButtonType.NO)
                {
                   new_passwd_pf.setText(null); 
                   confirm_passwd_pf.setText(null); 
                }
            }
        } 
    });
    
    //
    change_pw_btn.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    
    Scene new_passwd_scene = new Scene(new_passwd_pane,450,350);
            
    new_passwd_scene.getStylesheets().add(Window_1.class.getResource("Windows.css").toExternalForm());
    new_passwd_page.setScene(new_passwd_scene);
    new_passwd_page.show();
        
        
    new_passwd_page.setScene(new_passwd_scene);
    new_passwd_page.show();
    }
}
