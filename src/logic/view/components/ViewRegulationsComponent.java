package logic.view.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class ViewRegulationsComponent implements ViewComponent{
	 Logger loggerR = Logger.getLogger(this.getClass().getName());

		
		@Override
		public Node buildComponent() {
			String toPrintR = "In RegulationsComponenet";
			String pathR = FXMLPaths.REGULATIONS.getPath();
			FXMLLoader regulationsLoader = new FXMLLoader();
			ScrollPane regulations = new ScrollPane();
			
			regulationsLoader.setRoot(regulations);
			
			try (FileInputStream src = new FileInputStream(pathR)){
				regulationsLoader.load(src);
			} catch (IOException e) {
	        	loggerR.log(Level.SEVERE, String.format(" %s The erro says:  %s", toPrintR, e.toString()));

				return null;
			} 
			
			return regulations;
		}
}
