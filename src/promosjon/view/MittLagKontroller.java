package promosjon.view;

import java.io.IOException;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Info;
import promosjon.Main;

public class MittLagKontroller {
	
	@FXML
	private Label lagnavnLapp;
	
	@FXML
	private ListView<String> medlemmer;
	
	@FXML
	private Button fjernMedlemKnapp;
	
	@FXML
	private Button leggTilMedlemKnapp;
	
	@FXML
	private Button slettLagKnapp;
	
	private Stage stage;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	private void initialize() {
		ObservableList<String> obs = FXCollections.observableArrayList();
		for (String medlem : Info.brukersLag()) {
			obs.add(medlem);
		}
		medlemmer.setItems(obs);
	}
	
	@FXML
	private void klikkFjernMedlem() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Fjern medlem");
		alert.setContentText("Er du sikker på at du vil fjerne denne personen?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			Info.fjernFraLag(medlemmer.getSelectionModel().getSelectedItem());
		}
	}
	
	@FXML
	private void klikkLeggTilMedlem() {
		visLeggTilMedlem();
	}
	
	@FXML
	private void klikkSlettLag() {
		Info.slettLag();
		visHovedmeny();
	}
	
	@FXML
	private void klikkHjem() {
		visHovedmeny();
	}
	
	public void visLeggTilMedlem() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/leggtilmedlem.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			LeggTilMedlemKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void visHovedmeny() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/hovedmeny.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			HovedmenyKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
