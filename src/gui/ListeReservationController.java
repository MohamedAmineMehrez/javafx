/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Guide;
import Entities.Reservation;
import Services.GuideService;
import Services.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ListeReservationController implements Initializable {

    @FXML
    private AnchorPane paneFarRight;
    @FXML
    private TableView<Reservation> tabEvent;
    @FXML
    private TableColumn<Reservation, String> nomGuide;
    @FXML
    private TableColumn<Reservation, String> dateRes;
    @FXML
    private TableColumn<Reservation, Integer> heureDeb;
   
  
    @FXML
    private Button newRes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Reservation> res = FXCollections.observableArrayList();

        ServiceReservation ps = new ServiceReservation();
        res.addAll(ps.afficher());
     
        nomGuide.setCellValueFactory(new PropertyValueFactory<>("Nom Guide "));
        dateRes.setCellValueFactory(new PropertyValueFactory<>("Date Reservation "));
        heureDeb.setCellValueFactory(new PropertyValueFactory<>(" Heure Debut "));
        
     tabEvent.setItems(res);
    }    

    @FXML
    private void newRes(ActionEvent event) {
        try {
            System.out.println("You clicked me!");
            Parent helllo = FXMLLoader.load(getClass().getResource("AjouterGuide.fxml"));
            Scene scene1 = new Scene(helllo);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene1); 
            app_stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage()); 
        }
    }
    
}
