/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Service.articles_service;
import Service.comment_service;
import entities.Comment;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author MOUEFEK
 */
public class CommentController implements Initializable {
    public static int cmd;
    @FXML
    private TableView<Comment> tvcomment;
    @FXML
    private TableColumn<Comment, Integer> colid;
    @FXML
    private TableColumn<Comment, Integer> colarticle;
    @FXML
    private TableColumn<Comment, String> colcomment;
    @FXML
    private TextField tfsearch;
    ObservableList list ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficher();
    }    
    
     public void afficher(){
        comment_service ps = new comment_service();
        List<Comment> c = ps.recuperer();
        list = FXCollections.observableList(c);
        tvcomment.setItems(list);
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colarticle.setCellValueFactory(new PropertyValueFactory<>("id_article_id"));
        colcomment.setCellValueFactory(new PropertyValueFactory<>("commentaire")); 
    }
     
    @FXML
      public void Select(MouseEvent event){
        int index;
        index = tvcomment.getSelectionModel().getSelectedIndex();
        cmd=colid.getCellData(index);
        System.out.println(cmd);
    }
    
    
    @FXML
    public void Delete(ActionEvent event) {
        comment_service ps = new comment_service();
        ps.supprimer(cmd);
        afficher();
    }
    
    
    
    
    
    
    
    
    
    
    
}
