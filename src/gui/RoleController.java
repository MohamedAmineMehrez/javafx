/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.RoleService;
import entities.Role;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author EXTRA
 */
public class RoleController implements Initializable {
public static int cmd;
 RoleService ps = new RoleService();
    @FXML
    private TableView<Role> tvRole;
    @FXML
    private TableColumn<Role, Integer> colid;
    @FXML
    private TableColumn<Role, String> collibille;
    @FXML
    private TextField tflibille;
    @FXML
    private Button btnAjoutr;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    ObservableList list ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
       
       
       
    }    
     @FXML
    private void Ajouter(ActionEvent event)throws SQLException {
        Role r = new Role();
         String libille = tflibille.getText();
    
             
           //  test on email existance
             
             if (ps.afficher_libille().contains(libille) == true) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Failure");
                 alert.setHeaderText(null);
                 alert.setContentText("Role already exists");
                 alert.showAndWait();
                 
                 
                 //recuperer user a ajouter
                 
                 
             
         } 
            
      else if(!(tflibille.getText().isEmpty())){
             r.setLibille(tflibille.getText());
        ps.ajouter(r);
       
        afficher();}
        
             
        else{
       Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Libelle est vide !");
        a.show();
        }
      
    }
    public void afficher(){
         RoleService ps = new RoleService();
        List<Role> roles = ps.recuperer();
        list = FXCollections.observableList(roles);
        tvRole.setItems(list);
        
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        collibille.setCellValueFactory(new PropertyValueFactory<>("Libille"));
    }
@FXML
    public void Select(MouseEvent event){
        int index;
       // Role r = new Role();
        index = tvRole.getSelectionModel().getSelectedIndex();
            cmd=colid.getCellData(index);
            System.out.println(cmd);
            String dmd=collibille.getCellData(index);
            System.out.println(dmd);
            tflibille.setText(dmd);
    }
    @FXML
    public void update(ActionEvent event) {
    Role j = new Role();
       
        j.setLibille(tflibille.getText());   
            RoleService ps = new RoleService();
            ps.modifier(j,cmd);
            afficher();
        }
    @FXML 
    public void Delete(ActionEvent event){
       RoleService rs=new RoleService()   ;
       rs.supprimer(cmd);
       afficher();
    }

    @FXML
    private void Retour(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        tvRole.getScene().setRoot(root);
    } catch (IOException ex) {
        Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
