package promosjon.view;

import java.io.IOException;

import promosjon.Main;
import model.Info;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InnloggingKontroller {
	
	@FXML
	private TextField brukernavnFelt;
	
	@FXML
	private TextField passordFelt;
	
	@FXML
	private Button loggInnKnapp;
	
	@FXML
	private Button registrerBrukerKnapp;
	
	private Stage stage;
	private boolean loggInnKlikket;
	
	public void settStage(Stage stage) {
		this.stage = stage;
	}
	
	public boolean erLoggInnKlikket() {
		return loggInnKlikket;
	}
	
	@FXML
	private void klikkLoggInn() {
		if (gyldigInput()) {
			loggInnKlikket = true;
			if (Info.konkurranse != null) {
				visKonkurransestatus();
			}
			else {
				visHovedmeny();
			}
		}
	}
	
	@FXML
	private void klikkRegistrerBruker() {
		visRegistrerBruker();
	}
	
	private boolean gyldigInput() {
		if (Info.brukernavn.contains(brukernavnFelt.getText())) {
			if (Info.passord.get(Info.brukernavn.indexOf(brukernavnFelt.getText())).equals(passordFelt.getText())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean visRegistrerBruker() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/registrerbruker.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			RegistrerBrukerKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
			return controller.erRegistrerKlikket();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
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

	public void visKonkurransestatus() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/konkurransestatus.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(stage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			RegistrerBrukerKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


}
