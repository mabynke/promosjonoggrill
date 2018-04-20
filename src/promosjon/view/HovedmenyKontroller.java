package promosjon.view;

import java.io.IOException;
import java.util.ArrayList;

import promosjon.Main;
import model.Info;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HovedmenyKontroller {
    
    @FXML
    private Button konkurransestatusKnapp;
    
    @FXML
    private Button konkurranserKnapp;
    
    @FXML
    private Button minProfilKnapp;
    
    @FXML
    private Button lagstyringKnapp;
    
    @FXML
    private Button loggUtKnapp;
    
    private Stage stage;
    private Main main;
    
    public void setMain(Main main) {
        this.main = main;
    }
    
    public void settStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private void klikkKonkurransestatus() {
        visKonkurransestatus();
    }
    
    @FXML
    private void klikkKonkurranser() {
        visKonkurranser();
    }
    
    @FXML
    private void klikkMinProfil() {
        visMinProfil();
    }
    
    @FXML
    private void klikkLagstyring() {
        if (Info.erPaaLag()) {
            visMittLag(Info.brukersLag());
        }
        else {
            visNyttLag();
        }
    }
    
    @FXML
    private void klikkLoggUt() {
        Info.loggUt();
        main.visInnlogging();
    }
    
    public void visKonkurransestatus() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/konkurransestatus.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            KonkurransestatusKontroller controller = loader.getController();
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void visKonkurranser() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/konkurranser.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            KonkurranserKontroller controller = loader.getController();
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void visMinProfil() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/minprofil.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            MinProfilKontroller controller = loader.getController();
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void visMittLag() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/mittlag.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            MittLagKontroller controller = loader.getController();
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
public void visNyttLag() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/nyttlag.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            NyttLagKontroller controller = loader.getController();
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}