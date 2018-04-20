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
	
	@FXML
	private void initialize() {
		int index = Info.konkurranser.indexOf(Info.valgtKonkurranse);
		ObservableList<String> obs = FXCollections.observableArrayList();
		for (String detalj : Info.konkurranseInformasjon.get(index)) {
			obs.add(detalj);
		}
		arrangorLapp.setText(obs.get(0));
		datoLapp.setText(obs.get(1));
		beskrivelseLapp.setText(obs.get(2));
	}
	
	@FXML
	private void klikkMeldPaaAv() {
		if (statusKnapp.getText().equals("Meld på")) {
			Info.konkurranse = Info.valgtKonkurranse;
			statusKnapp.setText("Meld av");
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
