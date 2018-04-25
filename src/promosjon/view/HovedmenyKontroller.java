package promosjon.view;

import java.io.IOException;
import java.util.Optional;

import promosjon.Main;
import model.Info;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
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
        System.out.println("Satt main: " + main);
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
            visMittLag();
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
        		if (Info.konkurranse == null) {
        			ikkePåmeldt();
        		}
        		else {
	            FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("view/status.fxml"));
	            BorderPane page = (BorderPane) loader.load();
	            
	            Stage dialogStage = new Stage();
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(stage);
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);
	            KonkurransestatusKontroller controller = loader.getController();
	            controller.settStage(dialogStage);;
	            dialogStage.showAndWait();
        		}
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void ikkePåmeldt() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Ikke påmeldt konkurranse");
		alert.setHeaderText("");
		alert.setContentText("Du er ikke påmeldt en konkurranse");
		alert.showAndWait();
		}
		

	public void visKonkurranser() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/konkurranser.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
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
            loader.setLocation(Main.class.getResource("view/minProfil.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            MinProfilKontroller controller = loader.getController();
            controller.settMain(main);
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
            loader.setLocation(Main.class.getResource("view/mittLag.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            MittLagKontroller controller = loader.getController();
            controller.settMain(main);
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
            loader.setLocation(Main.class.getResource("view/nyttLag.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            NyttLagKontroller controller = loader.getController();
            controller.settMain(main);
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}