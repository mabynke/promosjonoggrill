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
	   	ObservableList<String> konkurranser = FXCollections.observableArrayList();
	   	for(String element : Info.konkurranser) {
	   		konkurranser.add(element);
	   	}
	   	listView.setItems(konkurranser);
	}
	private Stage stage;
	
	@FXML public void handleMouseClick(MouseEvent arg0) {
		Info.valgtKonkurranse = listView.getSelectionModel().getSelectedItem();
		visKonkurranse();
	}
	
	@FXML
	private void klikkHjem() {
		stage.close();
	}
	
	public void visKonkurranse() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/konkurransedetaljer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            KonkurranseKontroller controller = loader.getController();
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
