package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private AnchorPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();   
			loader.setLocation(Main.class.getResource("/eventosValidar/Ejercicio1_Principal.fxml"));      
			rootLayout = (AnchorPane) loader.load();  
			
			Scene scene = new Scene(rootLayout);    
			primaryStage.setScene(scene);      
			primaryStage.setTitle("PHCComponentes");  
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
