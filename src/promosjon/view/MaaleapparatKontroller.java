package promosjon.view;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Info;

// TODO: Legge et måleapparat til i listen

public class MaaleapparatKontroller {
	@FXML
	private ListView<String> list;
	
	@FXML
    private Button kobleTilKnapp;

    @FXML
    private Button avbrytKnapp;
    
    @FXML
    private void initialize() {
    	ObservableList<String> apparater = FXCollections.observableArrayList();
    	for(String element : Info.maaleapparater) {
    		apparater.add(element);
    	}
    	list.setItems(apparater);
    }
    
    private Stage stage;
    private boolean kobleTilKlikket;
    
    public void settStage(Stage stage) {
    	this.stage = stage;
    }
    
    public boolean erKobletTilKlikket() {
    	return kobleTilKlikket;
    }
    
    @FXML
    private void klikkKobleTil()	{
	    	String valgtApparat = list.getSelectionModel().getSelectedItem();
	    	Info.tilkobledeMaaleapparater.set(Info.maaleapparater.indexOf(valgtApparat), true);
	    	kobleTilKlikket = true;
	    	kobletTil();
	    	stage.close();
    }
    
    private void kobletTil() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Koblet til");
		alert.setHeaderText("");
		alert.setContentText("Ditt måleapparat er nå koblet til.");
		alert.showAndWait();
	}
    
    @FXML
    private void klikkAvbryt() {
    		stage.close();
    }
    
}
