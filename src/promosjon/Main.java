package promosjon;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import promosjon.view.InnloggingKontroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Info;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,335,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			// Legge til debugbruker for at vi skal slippe å lage bruker hver gang vi tester 
			Info.brukernavn.add("a"); Info.passord.add("a"); Info.epost.add("a@a.no"); Info.navn.add("Navn Navnesen");
			// Legge til en annen bruker som testeren kan legge til på laget sitt
			Info.brukernavn.add("ola"); Info.passord.add("ola"); Info.epost.add("ola@nordmann.no"); Info.navn.add("Ola Nordmann");
			
			Info.maaleapparater.add("FitBit Charge 2");
			
			Info.konkurranser.add("Gløshaugen rundt");
			ArrayList<String> konkInfo1 = new ArrayList<>(Arrays.asList("NTNU", "4 km", "25.04.18 - 17.05.18", "bla bla bla..."));
			Info.konkurranseInformasjon.add(konkInfo1);
			Info.brukerePaameldtKonkurranse.add(new ArrayList<String>());
			Info.konkurranser.add("Oslo til Trondheim");
			ArrayList<String> konkInfo2 = new ArrayList<>(Arrays.asList("Bekk", "560 km", "26.04.18 - 05.05.18", "bla bla bla..."));
			Info.konkurranseInformasjon.add(konkInfo2);
			Info.brukerePaameldtKonkurranse.add(new ArrayList<String>());
			
			visInnlogging();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean visInnlogging() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/innlogging.fxml"));
			BorderPane page = (BorderPane) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			InnloggingKontroller controller = loader.getController();
			controller.settStage(dialogStage);;
			dialogStage.showAndWait();
			return controller.erLoggInnKlikket();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
