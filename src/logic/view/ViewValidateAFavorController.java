package logic.view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

public class ViewValidateAFavorController  implements Initializable {
		
	public class ValidateCell extends TableCell<FavorDetailsBean, Boolean>{
		public class BValidateHandler implements EventHandler <ActionEvent>{

			@Override
			public void handle(ActionEvent event) {
				// TODO implement bValidate logic #234
				Button source = (Button) event.getSource();
				logger.log(Level.INFO, String.format("Button %s clicked", source.getText()));
			}	
		}
		final Button bValidate = new Button(BLabels.VALIDATE.getLabel());
		final StackPane spPaddedButton = new StackPane();
		ValidateCell(){
			spPaddedButton.setPadding(new Insets(3));
			spPaddedButton.getChildren().add(bValidate);
			this.bValidate.setOnAction(new BValidateHandler());
			
		}
		@Override
		protected void updateItem(Boolean item, boolean empty) {
			super.updateItem(item, empty);
			if (!empty) {
				this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
				this.setGraphic(spPaddedButton);
			}
			else {
				setGraphic(null);
			}
		}
	}
	
	public class isRowEmptyCallback implements Callback<TableColumn.CellDataFeatures<FavorDetailsBean, Boolean>, ObservableValue<Boolean>>{

		@Override
		public ObservableValue<Boolean> call(CellDataFeatures<FavorDetailsBean, Boolean> features) {
			return new SimpleBooleanProperty(features.getValue() != null);
		}
	 }
	 public class addButtonToRowCallback implements Callback<TableColumn<FavorDetailsBean, Boolean>, TableCell<FavorDetailsBean, Boolean>>{

		@Override
		public TableCell<FavorDetailsBean, Boolean> call(TableColumn<FavorDetailsBean, Boolean> tvFavorDetailBeanBooleanTableColumn) {
			return new ValidateCell();
		}
		 
	 }
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@FXML private TableView <FavorDetailsBean> tvFavors;
	@FXML private TableColumn <FavorDetailsBean, String> tcDateOfRequest;
	@FXML private TableColumn <FavorDetailsBean, String> tcOfferer;
	@FXML private TableColumn <FavorDetailsBean, Boolean> tcValidate;
	@FXML private Button bUpdate;
	
    @Override
    public void initialize(URL urlVAF, ResourceBundle resourceBundleVAF) { 
		 tcDateOfRequest.setCellValueFactory(new PropertyValueFactory<>("dateOfRequest"));
		 tcOfferer.setCellValueFactory(new PropertyValueFactory<>("offerer"));
		 tcValidate.setCellValueFactory(new isRowEmptyCallback());
		 tcValidate.setCellFactory(new addButtonToRowCallback());
    }
    
    @FXML protected void bUpdateHandler(ActionEvent event) {
    	// TODO: implement bUpdate logic #233
    	Button bClicked = (Button) event.getSource();
    	logger.log(Level.INFO, String.format("button %s clicked", bClicked.getText()));
    }

}
