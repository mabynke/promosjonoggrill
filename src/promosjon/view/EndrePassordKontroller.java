package promosjon.view;

import model.Info;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EndrePassordKontroller {
	 	@FXML
	    private Button lagreKnapp;

	    @FXML
	    private TextField gammeltPassordFelt;

	    @FXML
	    private TextField nyttPassordFelt;

	    @FXML
	    private TextField gjentaPassordFelt;

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
	    		Info.passord.set(Info.brukernavn.indexOf(Info.bruker), nyttPassordFelt.getText());
	    		lagreKlikket = true;
	    		stage.close();
	    	}
	    }
	    
	    @FXML
	    private void klikkAvbryt() {
	    	stage.close();
	    }
	    
	    private boolean gyldigInput() {
	    	if (gammeltPassordFelt.getText() == null || nyttPassordFelt.getText() == null || gjentaPassordFelt.getText() == null) {
	    		return false;
	    	}
	    	else if (Info.passord.get(Info.brukernavn.indexOf(Info.bruker)).equals(gammeltPassordFelt.getText()) && nyttPassordFelt.getText().equals(gjentaPassordFelt.getText())) {
	    		return true;
	    	}
	    	return true;
	    }


	    
	    
	    
	    
	    
	   /* 
	    @FXML
	    void Back(ActionEvent event) throws IOException {
	    	Parent Loginmenu = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
			Scene second = new Scene(Loginmenu);
			
			Node node = (Node) event.getSource();
			
			Stage LoginMenu = (Stage) node.getScene().getWindow();
			
			LoginMenu.setScene(second);
			LoginMenu.show();

	    }

	    @FXML
	    void Create(ActionEvent event) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
	    	
	    	if(getName.getText().trim().equals("") ||getUsername.getText().trim().equals("") || getPassword.getText().trim().equals("") || (getCoach.getValue() == null && RegisterAsCoach.isSelected() == false) || (getCoach.getValue() != null && RegisterAsCoach.isSelected() == true)) {
	    		ErrorMessage.setText("You must fill in all spots");
	    	}
	    	else {
	    		
	    		String name = getName.getText();
				String username = getUsername.getText();
				String password = getPassword.getText();
				Boolean coach = RegisterAsCoach.isSelected();
				String coachUsername = getCoach.getValue();
				
				Query.createUser(name, username, password, coach, coachUsername);
				
				CurrentUser.CURRENT_USERNAME = username;
				
				if (coach) {
					CurrentUser.CURRENT_ID = Query.getCoachID(CurrentUser.CURRENT_USERNAME);
				}
				else {
					CurrentUser.CURRENT_ID = Query.getAthleteID(CurrentUser.CURRENT_USERNAME);				
				}
				CurrentUser.CURRENT_COACH = coach;
				    		
				Parent Loginmenu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
				Scene second = new Scene(Loginmenu);
				
				Node node = (Node) event.getSource();
				
				Stage LoginMenu = (Stage) node.getScene().getWindow();
				
				LoginMenu.setScene(second);
				LoginMenu.show();
	    	}*/
}
