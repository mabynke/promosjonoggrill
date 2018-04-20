package promosjon.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Info;

public class LeggTilMedlemKontroller {
	
	@FXML
	private TextField brukernavnFelt;
	
	@FXML
	private Button leggTilKnapp;
	
	@FXML
	private Button avbrytKnapp;
	
	private Stage stage;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	private void klikkLeggTil() {
		if (gyldigInput()) {
			Info.brukersLag().add(brukernavnFelt.getText());
		}		
		stage.close();
	}
	
	@FXML
	private void klikkAvbryt() {
		stage.close();
	}
	
	private boolean gyldigInput() {
		return Info.brukernavn.contains(brukernavnFelt.getText());
	}

}
