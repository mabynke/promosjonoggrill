package promosjon.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Info;

// TODO: Passe på at det er en bruker på listen
// TODO: Passe på at brukeren selv er på listen
// TODO: Passe på at kartet viser posisjonen til personene på listen

public class KonkurransestatusKontroller {
	
	@FXML
	private ListView<String> informasjon; // TODO: info skal legges i hver sin label, ikke i listview
	
	@FXML
	private Button hjem;
	
	private Stage stage;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	private void initialize() {
		ObservableList<String> obs = FXCollections.observableArrayList();
		int index = Info.konkurranser.indexOf(Info.konkurranse);
		for (String element : Info.konkurranseInformasjon.get(index)) {
			obs.add(element);
		}
		informasjon.setItems(obs);
	}
	
	@FXML
	private void klikkHjem() {
		// Denne må passe på å faktisk gå til hovedmenyen. Men det blir ikke aktuelt i testen
		stage.close();
	}

}
