package promosjon.view;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Info;
import promosjon.Main;

public class KonkurranserKontroller {
	
	@FXML
	private ListView<String> listView;
	
	@FXML
	private Button hjemKnapp;
	
	@FXML
	private void initialize() {
		Info.konkurranser.add("Gløshaugen rundt");
		Info.konkurranser.add("Oslo til Trondheim");
	   	ObservableList<String> konkurranser = FXCollections.observableArrayList();
	   	for(String element : Info.konkurranser) {
	   		konkurranser.add(element);
	   	}
	   	listView.setItems(konkurranser);
	}
	
	private Stage stage;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML public void handleMouseClick(MouseEvent arg0) {
		Info.valgtKonkurranse = listView.getSelectionModel().getSelectedItem();
		visKonkurranseDetaljer();
	}
	
	@FXML
	private void klikkHjem() {
		stage.close();
	}
	
	public void visKonkurranseDetaljer() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/konkurransedetaljer.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            KonkurranseDetaljerKontroller controller = loader.getController();
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
