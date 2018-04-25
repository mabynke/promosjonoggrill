package promosjon.view;

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
import model.Info;
import promosjon.Main;

public class EndreEpostKontroller {
	@FXML
    private Button lagreKnapp;

    @FXML
    private TextField bekreftEpostFelt;

    @FXML
    private TextField nyEpostFelt;

    @FXML
    private Button avbrytKnapp;
    
    private Stage stage;
    
    public void settStage(Stage stage) {
    	this.stage = stage;
    }
    
    
    @FXML
    private void klikkLagret()	{
	    	if (gyldigInput()) {
	    		Alert alert = new Alert(AlertType.CONFIRMATION);
	    		alert.setHeaderText("Endre epost");
	    		alert.setContentText("Er du sikker på at du vil endre epost?");
	    		Optional<ButtonType> result = alert.showAndWait();
	    		if (result.get() == ButtonType.OK) {
	        		Info.epost.set(Info.brukernavn.indexOf(Info.bruker), nyEpostFelt.getText());
	        		visMinProfil();
	    		}
	    	}
    }
    
    @FXML
    private void klikkAvbryt() {
    	stage.close();
    }
    
    private boolean gyldigInput() {
    	if (bekreftEpostFelt.getText() == null || nyEpostFelt.getText() == null) {
    		return false;
    	}
    	else if (nyEpostFelt.getText().equals(bekreftEpostFelt.getText())) {
    		return true;
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
