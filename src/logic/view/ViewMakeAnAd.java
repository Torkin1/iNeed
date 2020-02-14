package logic.view;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import logic.beans.ViewProfileBean;
import logic.publishanad.PublishAnAdBean;
import logic.publishanad.PublishAnAdController;




public class ViewMakeAnAd extends View implements Initializable {
	
	public ViewMakeAnAd() {
		this.setFXMLPath("fxml_makeanad.fxml");
		pBean.setRequestedUsername(View.getProfileName());
	}
	
	 @FXML private TextField typeTextField;
	 @FXML private TextField categoryTextField;
	 @FXML private TextField titleTextField;
	 @FXML private TextArea bodyTextArea;
	 String formError = MSGError.ERROR_FORM.getMsg();
	 @FXML private Text actionPrinte;
	 @FXML private GridPane grid;
	 @FXML private MenuItem profileName;
	 ViewProfileBean pBean = new ViewProfileBean();
	 
	 Logger logger = Logger.getLogger(this.getClass().getName());

	 public void initialize(URL locationAd, ResourceBundle resourcesAD) {
		 profileName.setText(View.getProfileName());
		 String status = "My location " + locationAd + " my resoursources: " + resourcesAD;
		 logger.log(Level.SEVERE, status);
		}

	 @FXML protected void handleSubmitButtonSend(ActionEvent event) {
		 actionPrinte.setText("");
	     actionPrinte.setText("I'm sending");
	     PublishAnAdBean adBean = new PublishAnAdBean();
	     PublishAnAdController controller = PublishAnAdController.getInstance();
	     
	     adBean.setType(typeTextField.getText());
	     adBean.setTitle(titleTextField.getText());
	     adBean.setBody(bodyTextArea.getText());
	     adBean.setUsername(View.getProfileName());
	     
	     try {
			controller.createAd(adBean);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	 }
	 
	 @FXML protected void handleSubmitButtonRegulations(ActionEvent event) {
		 actionPrinte.setText("");
	     actionPrinte.setText("vado su Regulations");	
	 }
	 
	 @FXML protected void handleSubmitButtonMakeAnAd(ActionEvent event) {
		 actionPrinte.setText("");
	     actionPrinte.setText("vado su MakeAnAd");
    	 Context.getReference().goNext(GoNextTargets.VIEW_MAKEANAD.getStateName());	
	 } 
	 
	 @FXML protected void handleSubmitButtonViewFlow(ActionEvent event) {
		 actionPrinte.setText("");
	     actionPrinte.setText("vado su ViewFlow");
      	 logger.log(Level.SEVERE, "Print this when ViewFlow is clicked ");
    	 Context.getReference().goNext(GoNextTargets.VIEW_FLOW.getStateName());	
	    }
	 
	 @FXML protected void handleSubmitButtonValidateAFavor(ActionEvent event) {
		 actionPrinte.setText("");
	 		
		 actionPrinte.setText("ValidateAFavor");
	    }
	 
	 @FXML protected void handleSubmitButtonViewProfile(ActionEvent event) {
		 actionPrinte.setText("");
	     actionPrinte.setText("vado su User");
	 	Context.getReference().goNext(GoNextTargets.VIEW_USER.getStateName());

	    }
	 
	 @FXML protected void handleSubmitButtonExit(ActionEvent event) {
 		Context.getReference().goNext(GoNextTargets.VIEW_LOGIN.getStateName());
	    }
	 
	 @FXML protected void handleSubmitButtonViewMap(ActionEvent event) {
	 		 actionPrinte.setText("");
		     actionPrinte.setText("vado su map");
          	 logger.log(Level.SEVERE, "Print this when viewMap is clicked ");
	    	 Context.getReference().goNext(GoNextTargets.VIEW_MAP.getStateName());
		 }
	@FXML protected void handleSubmitButtonUser(ActionEvent event) {
	        actionPrinte.setText("");
	        actionPrinte.setText("Utente");        
	} 
}