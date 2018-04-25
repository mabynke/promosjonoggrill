package promosjon.view;

import java.io.IOException;
import java.util.ArrayList;

import model.Info;
import promosjon.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NyttLagKontroller {
	@FXML
    private Button okKnapp;

    @FXML
    private TextField lagNavnFelt;

    @FXML
    private Button avbrytKnapp;
    
    @FXML
    private Button hjemKnapp;
    
    private Stage stage;
    private boolean lagreKlikket;
    
    private Main main;
    
    public void settMain(Main main) {
        this.main = main;
        System.out.println("Satt main: " + main);
    }
    
    public void settStage(Stage stage) {
    	this.stage = stage;
    }
    
    public boolean erLagretKlikket() {
    	return lagreKlikket;
    }
    
    @FXML
    private void klikkLagret()	{
    	if (gyldigInput()) {
    		ArrayList<String> lagMedlemmer = new ArrayList<String>();
    		Info.lagNavn.add(lagNavnFelt.getText());
    		lagMedlemmer.add(Info.bruker);
    		Info.lagListe.add(lagMedlemmer);
    		lagreKlikket = true;
    		visMittLag();
    	}
    }
    
    public void visMittLag() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/mittLag.fxml"));
            BorderPane page = (BorderPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            MittLagKontroller controller = loader.getController();
            controller.settMain(main);
            controller.settStage(dialogStage);;
            dialogStage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void klikkAvbryt() {
    	stage.close();
    }
    
    private boolean gyldigInput() {
    	if (lagNavnFelt.getText() == null || Info.lagNavn.contains(lagNavnFelt.getText())) {
    		return false;
    	}

    	return true;
    }
}
