package promosjon.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Info;

// TODO: Passe på at det er en bruker på listen
// TODO: Passe på at brukeren selv er på listen
// TODO: Passe på at kartet viser posisjonen til personene på listen

public class KonkurransestatusKontroller {
	
	@FXML
	private Label konkurransenavn;
	
	@FXML
	private Label lengde;
	
	@FXML
	private Label tid;
	
	@FXML
	private Label arrangor;
	
	@FXML
	private ListView<String> deltakere;
	
	@FXML
	private Button hjem;
	
	private Stage stage;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	private void initialize() {
		ArrayList<String> detaljer = Info.konkurranseInformasjon.get(Info.konkurranser.indexOf(Info.konkurranse));
		konkurransenavn.setText(Info.konkurranse);
		lengde.setText(detaljer.get(1));
		tid.setText(detaljer.get(2));
		arrangor.setText(detaljer.get(0));
		ObservableList<String> obs = FXCollections.observableArrayList();
		int index = Info.konkurranser.indexOf(Info.konkurranse);
		for (String element : Info.brukerePaameldtKonkurranse.get(index)) {
			if (element.equals(Info.bruker)) {
				obs.add(element + "  -  109.2 km");
			}
			else {
				obs.add(element + "  -  237.7 km");
			}
			
		}
		deltakere.setItems(obs);
	}
	
	@FXML
	private void klikkHjem() {
		// Denne må passe på å faktisk gå til hovedmenyen. Men det blir ikke aktuelt i testen
		stage.close();
	}

}
