package promosjon.view;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Info;

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
	        		stage.close();
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
}
