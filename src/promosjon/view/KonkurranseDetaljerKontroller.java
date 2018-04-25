package promosjon.view;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Info;

public class KonkurranseDetaljerKontroller {

	@FXML
	private Label konkurransenavn;
	
	@FXML
	private Label konkurransetype;
	
	@FXML
	private Label arrangorLapp;
	
	@FXML
	private Label datoLapp;
	
	@FXML
	private Label beskrivelseLapp;
	
	@FXML
	private Button statusKnapp;
	
	@FXML
	private Button tilbakeKnapp;
	
	private Stage stage;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	private void initialize() {
		
		konkurransenavn.setText(Info.valgtKonkurranse);
		konkurransetype.setText("individuell");
		int index = Info.konkurranser.indexOf(Info.valgtKonkurranse);
		ObservableList<String> obs = FXCollections.observableArrayList();
		for (String detalj : Info.konkurranseInformasjon.get(index)) {
			obs.add(detalj);
		}
		
		// Vise riktig melde av/på-knapp 
		if (Info.konkurranse == Info.valgtKonkurranse) {
			statusKnapp.setText("Meld av");
		}
		else if (Info.konkurranse != null) {
			statusKnapp.setVisible(false);
		}
		
		arrangorLapp.setText(obs.get(0));
		datoLapp.setText(obs.get(2));
		beskrivelseLapp.setText(obs.get(3));
	}
	
	@FXML
	private void klikkMeldPaaAv() {
		if (statusKnapp.getText().equals("Meld på")) {
			Info.konkurranse = Info.valgtKonkurranse;
			statusKnapp.setText("Meld av");
			int i = Info.konkurranser.indexOf(Info.valgtKonkurranse);
			Info.brukerePaameldtKonkurranse.get(i).add(Info.bruker);
			meldtPaa();
		}
		else if (statusKnapp.getText().equals("Meld av")) {
			//Info.konkurranse = null;
			//statusKnapp.setText("Meld på");
			meldeAv();
		}
		else {
			throw new IllegalStateException("Det står hverken meld på eller meld av");
		}
	}
	
	private void meldeAv() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Melde av");
	alert.setHeaderText("");
	alert.setContentText("Er du sikker på at du vil melde deg av konkurransen?");
	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK) {
		Info.konkurranse = null;
		statusKnapp.setText("Meld på");
	}
	}
	
	private void meldtPaa() {
		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Meldt på");
		alert.setHeaderText("");
		alert.setContentText("Du er nå meldt på konkurransen " + Info.valgtKonkurranse);
		alert.showAndWait();
	}
	
	@FXML
	private void klikkTilbake() {
		stage.close();
	}
	
}
