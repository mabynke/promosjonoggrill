package promosjon.view;

import java.io.IOException;

import promosjon.Main;
import model.Info;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MinProfilKontroller {

	@FXML
	private Label navnLapp;
	
	@FXML
	private Label brukernavnLapp;
	
	@FXML
	private Label epostLapp;
	
	@FXML
	private Button endreNavnKnapp;
	
	@FXML
	private Button endreEpostKnapp;
	
	@FXML
	private Button endrePassordKnapp;
	
	@FXML
	private Button maaleapparaterKnapp;
	
	@FXML
	private Button slettBrukerKnapp;
	
	@FXML
	private Button hjem;
	
	private Main main;
	
	public void settMain(Main main) {
		this.main = main;
	}
	
	private Stage stage;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	private void initialize() {
		navnLapp.setText(Info.hentNavn());
		brukernavnLapp.setText(Info.bruker);
		epostLapp.setText(Info.hentEpost());
	}
	
	@FXML
	private void klikkEndreNavn() {
		visEndreNavn();
	}
	
	@FXML
	private void klikkEndreEpost() {
		//TODO: Endring av epost reflekteres ikke før man går inn i vinduet på nytt
		visEndreEpost();
	}
	
	@FXML
	private void klikkEndrePassord() {
		visEndrePassord();
	}
	
	@FXML
	private void klikkMaaleapparater() {
		visMaaleapparater();
	}
	
	@FXML
	private void klikkSlettBruker() {
		// TODO: Virker ikke
		Info.slettBruker();
		main.visInnlogging();
	}
	
	@FXML
	private void klikkHjem() {
		stage.close();
	}
	
	public void visEndreNavn() { //TODO: får ikke åpnet endrenavn (skal kanskje ikke brukes uansett) 
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/endrenavn.fxml"));
			BorderPane page = (BorderPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			EndreNavnKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void visEndreEpost() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/endreEpost.fxml"));
			BorderPane page = (BorderPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			EndreEpostKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void visEndrePassord() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/endrePassord.fxml"));
			BorderPane page = (BorderPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			EndrePassordKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void visMaaleapparater() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/måleapparat.fxml"));
			BorderPane page = (BorderPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			MaaleapparatKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
