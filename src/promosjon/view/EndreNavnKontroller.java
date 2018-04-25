package promosjon.view;

import model.Info;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	        		stage.close();
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
}
