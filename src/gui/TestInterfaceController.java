/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.darkprograms.speech.translator.GoogleTranslate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author MOUEFEK
 */
public class TestInterfaceController implements Initializable {

    @FXML
    private Button btnArticle;
    @FXML
    private Button btnJeux;
    @FXML
    private Button btncommentaire;
    @FXML
    private Button btntraduire;
    @FXML
    private Button btntest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void redirectArticle(ActionEvent event){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Article.fxml"));
            Parent root = loader.load();
            ArticleController controller = loader.getController();
            btnArticle.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
        @FXML
    public void redirectJeux(ActionEvent event){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Jeux.fxml"));
            Parent root = loader.load();
            JeuxController controller = loader.getController();
            btnJeux.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void redirectioncommentaire(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("comment.fxml"));
            Parent root = loader.load();
            CommentController controller = loader.getController();
            btnJeux.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void traduire(ActionEvent event) throws IOException {
        btntraduire.setText(GoogleTranslate.translate("en",btntraduire.getText()));
        btnJeux.setText(GoogleTranslate.translate("en",btnJeux.getText()));
        btncommentaire.setText(GoogleTranslate.translate("en",btncommentaire.getText()));
        btnArticle.setText(GoogleTranslate.translate("en",btnArticle.getText()));
    }
    
}
