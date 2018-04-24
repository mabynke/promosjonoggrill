package promosjon;
	
import java.io.IOException;

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
			Info.brukernavn.add("a"); Info.passord.add("a"); Info.epost.add("a@a.no"); Info.navn.add("Navn Navnesen");
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
