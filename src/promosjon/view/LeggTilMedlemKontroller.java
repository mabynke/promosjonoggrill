package promosjon.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		String brukernavn = brukernavnFelt.getText();
		if (gyldigInput()) {
			String navn = Info.navn.get(Info.brukernavn.indexOf(brukernavn));
			Info.brukersLag().add(navn);
			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Forespørsel sendt");
    			alert.setHeaderText("");
    			alert.setContentText("Forespørsel er sendt til " + brukernavn);
    			alert.showAndWait();
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fant ikke brukeren");
			alert.setHeaderText("");
			alert.setContentText("Fant ingen brukere med brukernavn " + brukernavn);
			alert.showAndWait();
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
