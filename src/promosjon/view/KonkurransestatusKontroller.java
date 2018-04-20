package promosjon.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Info;

public class KonkurransestatusKontroller {
	
	@FXML
	private ListView<String> informasjon;
	
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
		stage.close();
	}

}
