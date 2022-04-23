/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author EXTRA
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnrole;
    @FXML
    private Button btnuser;
    @FXML
    private TextField tfplz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void onclickRole(ActionEvent event){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Role.fxml"));
            Parent root = loader.load();
            RoleController controller = loader.getController();
            btnrole.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void onclickUser(ActionEvent event){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("User.fxml"));
            Parent root = loader.load();
            UserController controller = loader.getController();
            btnuser.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
