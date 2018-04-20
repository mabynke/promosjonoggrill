package promosjon.view;

import java.util.ArrayList;

import model.Info;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    		stage.close();
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
