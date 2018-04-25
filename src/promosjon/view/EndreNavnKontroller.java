package promosjon.view;

import model.Info;
import promosjon.Main;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EndreNavnKontroller {
	@FXML
    private Button lagreKnapp;

    @FXML
    private TextField nyttNavnFelt;

    @FXML
    private Button avbrytKnapp;
    
    private Stage stage;
    private boolean lagreKlikket;
    
    public void settStage(Stage stage) {
    	this.stage = stage;
    }
    
    public boolean erLagretKlikket() {
    	return lagreKlikket;
    }
    
    @FXML
    private void klikkLagret()	{
    		if (gyldigInput()) {
	    		Alert alert = new Alert(AlertType.CONFIRMATION);
	    		alert.setHeaderText("Endre navn");
	    		alert.setContentText("Er du sikker på at du vil endre navn?");
	    		Optional<ButtonType> result = alert.showAndWait();
	    		if (result.get() == ButtonType.OK) {
	        		Info.navn.set(Info.brukernavn.indexOf(Info.bruker), nyttNavnFelt.getText());
	        		visMinProfil();
	    		}
	    	}
    	}
    
    @FXML
    private void klikkAvbryt() {
    	stage.close();
    }
    
    private boolean gyldigInput() {
    	if (nyttNavnFelt.getText() == null) {
    		return false;
    	}
    	return true;
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
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
