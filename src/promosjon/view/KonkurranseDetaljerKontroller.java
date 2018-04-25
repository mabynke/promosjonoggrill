package promosjon.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		}
		else if (statusKnapp.getText().equals("Meld av")) {
			Info.konkurranse = null;
			statusKnapp.setText("Meld på");
		}
		else {
			throw new IllegalStateException("Det står hverken meld på eller meld av");
		}
	}
	
	@FXML
	private void klikkTilbake() {
		stage.close();
	}
	
}
