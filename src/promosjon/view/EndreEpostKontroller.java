package promosjon.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Info;

public class EndreEpostKontroller {
	@FXML
    private Button lagreKnapp;

    @FXML
    private TextField bekreftEpostFelt;

    @FXML
    private TextField nyEpostFelt;

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
    		Info.epost.set(Info.brukernavn.indexOf(Info.bruker), nyEpostFelt.getText());
    		lagreKlikket = true;
    		stage.close();
    	}
    }
    
    @FXML
    private void klikkAvbryt() {
    	stage.close();
    }
    
    private boolean gyldigInput() {
    	if (bekreftEpostFelt.getText() == null || nyEpostFelt.getText() == null) {
    		return false;
    	}
    	else if (nyEpostFelt.getText().equals(bekreftEpostFelt.getText())) {
    		return true;
    	}
    	return true;
    }
}
