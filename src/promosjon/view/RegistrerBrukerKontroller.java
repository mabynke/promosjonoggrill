package promosjon.view;

import model.Info;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrerBrukerKontroller {
	
	@FXML
	private TextField brukernavnFelt;
	
	@FXML
	private TextField navnFelt;
	
	@FXML
	private TextField epostFelt;
	
	@FXML
	private PasswordField passordFelt;
	
	@FXML
	private PasswordField gjentaPassordFelt;
	
	@FXML
	private Button registrerKnapp;
	
	private Stage stage;
	private boolean registrerKlikket;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	public boolean erRegistrerKlikket() {
		return registrerKlikket;
	}
	
	@FXML
	private void klikkRegistrer() {
		if (gyldigInput()) {
			Info.brukernavn.add(brukernavnFelt.getText());
			Info.passord.add(passordFelt.getText());
			Info.epost.add(epostFelt.getText());
			Info.navn.add(navnFelt.getText());
			registrerKlikket = true;
			stage.close();
		}
	}
	
	@FXML
	private void klikkAvbryt() {
		stage.close();
	}
	
	private boolean gyldigInput() {
		String navn = navnFelt.getText();
		String brukernavn = brukernavnFelt.getText();
		String passord = passordFelt.getText();
		String epost = epostFelt.getText();
		if (navn == null || brukernavn == null || passord == null || epost == null) {
			return false;
		}
		boolean navnB = Info.navn.contains(navn);
		boolean brukernavnB = Info.brukernavn.contains(brukernavn);
		boolean passordB = Info.passord.contains(passord);
		boolean epostB = Info.epost.contains(epost);
		if (navnB || brukernavnB || passordB || epostB) {
			return false;
		}
		return true;
	}

}