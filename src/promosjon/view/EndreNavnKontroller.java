package promosjon.view;

import model.Info;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EndreNavnKontroller {
	@FXML
    private Button lagreKnapp;

    @FXML
    private TextField nyttNavnFelt;

    @FXML
    private Button avbrytKnapp;
    
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
    		Info.navn.set(Info.brukernavn.indexOf(Info.bruker), nyttNavnFelt.getText());
    		lagreKlikket = true;
    		stage.close();
    	}
    }
    
    @FXML
    private void klikkAvbryt() {
    	stage.close();
    }
    
    private boolean gyldigInput() {
    	if (nyttNavnFelt.getText() == null) {
    		return false;
    	}
    	return true;
    }
}
