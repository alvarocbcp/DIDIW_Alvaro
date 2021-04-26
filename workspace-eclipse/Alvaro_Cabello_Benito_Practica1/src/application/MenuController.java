package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MenuController {

	private BorderPane rootLayout;



	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private void initialize() {

	}

	@FXML
	private void abrirSocios(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(MenuController.class.getResource("/dinamico/Socios.fxml"));

		GridPane listadoControles;
		try {
			listadoControles = (GridPane) loader.load();

			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void cerrarSocios(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(MenuController.class.getResource("/dinamico/Bienvenida.fxml"));

		AnchorPane bienvenida;

		try {
			bienvenida = (AnchorPane) loader.load();

			rootLayout.setCenter(bienvenida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void anadirSocio(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(MenuController.class.getResource("/editar/Anadir.fxml"));
		
		GridPane anadir;
		try {
			anadir = (GridPane) loader.load();

			rootLayout.setCenter(anadir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
}
