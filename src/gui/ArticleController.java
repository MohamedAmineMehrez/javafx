/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.articles_service;
import entities.Articles;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MOUEFEK
 */
public class ArticleController implements Initializable {
public static int cmd;
    @FXML
    private TableView<Articles> tvarticle;
    @FXML
    private TableColumn<Articles, Integer> colid;
    @FXML
    private TableColumn<Articles, Integer> colnomjeu;
    @FXML
    private TableColumn<Articles, String> coltitre;
    @FXML
    private TableColumn<Articles, String> coldescription;
    @FXML
    private TableColumn<Articles, Date> coldate;
    @FXML
    private TableColumn<Articles, String> colimg;
    ObservableList list ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }    
    
        public void afficher(){
        articles_service ps = new articles_service();
        List<Articles> ar = ps.recuperer();
        list = FXCollections.observableList(ar);
        tvarticle.setItems(list);
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colnomjeu.setCellValueFactory(new PropertyValueFactory<>("nom_jeux_id"));
        coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        colimg.setCellValueFactory(new PropertyValueFactory<>("image"));   
    } 
        
        @FXML
    public void modifier(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierArticle.fxml"));
            Parent root = loader.load();
            ModifierArticleController controller = loader.getController();
            tvarticle.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    @FXML
    public void interfaceajouterArticle(ActionEvent event){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterArticle.fxml"));
            Parent root = loader.load();
            AjouterArticleController controller = loader.getController();
            tvarticle.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @FXML
    public void RetrunInterface(ActionEvent event){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TestInterface.fxml"));
            Parent root = loader.load();
            TestInterfaceController controller = loader.getController();
            tvarticle.getScene().setRoot(root);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }    
        
    public void Select(MouseEvent event){
        int index;
        index = tvarticle.getSelectionModel().getSelectedIndex();
        cmd=colid.getCellData(index);
        System.out.println(cmd);
    }
    
    @FXML
    public void Delete(ActionEvent event) {
        articles_service ps = new articles_service();
        ps.supprimer(cmd);
        afficher();
    } 
    
    
}
