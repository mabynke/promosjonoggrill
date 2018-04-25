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

// TODO: Ikke vise passordet i klartekst

public class EndrePassordKontroller {
	 	
	@FXML
	private Button lagreKnapp;
	
	@FXML
	private TextField gammeltPassordFelt;
	
	@FXML
	private TextField nyttPassordFelt;
	
	@FXML
	private TextField gjentaPassordFelt;
	
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
	    		alert.setHeaderText("Endre passord");
	    		alert.setContentText("Er du sikker på at du vil endre passord?");
	    		Optional<ButtonType> result = alert.showAndWait();
	    		if (result.get() == ButtonType.OK) {
		    		Info.passord.set(Info.brukernavn.indexOf(Info.bruker), nyttPassordFelt.getText());
		    		stage.close();
	    		}
	    	}
    }
    
    @FXML
    private void klikkAvbryt() {
    	stage.close();
    }
    
    private boolean gyldigInput() {
    	if (gammeltPassordFelt.getText() == null || nyttPassordFelt.getText() == null || gjentaPassordFelt.getText() == null) {
    		return false;
    	}
    	else if (Info.passord.get(Info.brukernavn.indexOf(Info.bruker)).equals(gammeltPassordFelt.getText()) && nyttPassordFelt.getText().equals(gjentaPassordFelt.getText())) {
    		return true;
    	}
    	return true;
    }
    
}
