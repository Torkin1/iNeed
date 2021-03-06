package logic.view;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import logic.beans.ListAllFavorsToValidateBean;
import logic.view.components.ToolBarComponent;
import logic.view.components.ViewValidateAFavorComponent;



public class ViewValidateAFavor extends View {
		
		Logger loggerV = Logger.getLogger(this.getClass().getName());
		private ListAllFavorsToValidateBean listAllFavorsToValidateBean;
		
		public ListAllFavorsToValidateBean getAllFavorsToValidateBean() {
			return listAllFavorsToValidateBean;
		}

		public void setAllFavorsToValidateBean(ListAllFavorsToValidateBean allFavors) {
			this.listAllFavorsToValidateBean = allFavors;
		}

		@Override
		public Scene buildScene() {
			BorderPane  root = new BorderPane();
			ToolBar toolBar = (ToolBar) (new ToolBarComponent()).buildComponent();
			ScrollPane viewValidateAFavor = (ScrollPane) (new ViewValidateAFavorComponent()).buildComponent();
			loggerView.log(Level.INFO,"In ViewMap");
			
			VBox vBox = new VBox();
			vBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			vBox.getChildren().addAll(viewValidateAFavor);
			root.setTop(toolBar);
			root.setCenter(vBox);
			return new Scene(root);

		}
		

}
