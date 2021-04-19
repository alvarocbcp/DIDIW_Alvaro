package ejercicio3;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainEjercicio3 extends Application {
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainEjercicio3.class.getResource("Ejercicio3.fxml"));
			rootLayout = (BorderPane)loader.load();
			rootLayout.getStylesheets().add("ejercicio3/Ejercicio3.css");
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setTitle("Ejercicio3 CSS");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

