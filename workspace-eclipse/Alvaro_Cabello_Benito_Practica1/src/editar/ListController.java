package editar;

import java.net.URL;
import java.util.ResourceBundle;

import dinamico.Socio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ListController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	//Pantalla de añadir socio

	@FXML
	private TextField nombreAnadir;

	@FXML
	private TextField apellAnadir;

	@FXML
	private TextField dniAnadir;

	@FXML
	private TextField emailAnadir;

	@FXML
	private TextField tlfnAnadir;
	
	@FXML
	private TextField edadAnadir;

	@FXML
	private RadioButton hombreAnadir;

	@FXML
	private RadioButton mujerAnadir;

	@FXML
	private ToggleGroup genero;

	@FXML
	private ComboBox<String> localidad;
	
	//Pantalla de eliminar socio

	@FXML
	void initialize() {
		localidad.getItems().addAll("Álava", "Albacete", "Alicante",
				"Almería", "Asturias", "Ávila", "Badajoz", "Barcelona", 
				"Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón",
				"Ciudad Real", "Córdoba", "Cuenca", "Gerona", "Granada",
				"Guadalajara", "Guipúzcoa", "Huelva", "Huesca",
				"Islas Baleares", "Jaén", "La Coruña", "La Rioja",
				"Las Palmas", "León", "Lérida", "Lugo", "Madrid", "Málaga",
				"Murcia", "Navarra", "Orense", "Palencia", "Pontevedra",
				"Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla",
				"Soria", "Tarragona", "Teruel", "Toledo", "Valencia",
				"Valladolid", "Vizcaya", "Zamora", "Zaragoza");
	}

	@FXML
	public Socio recibirDatos(ActionEvent event) {  

		String nombre = nombreAnadir.getText();
		String apell = apellAnadir.getText();
		String dni = dniAnadir.getText();
		String email = nombreAnadir.getText();
		String tlf = tlfnAnadir.getText();
		Integer edad = Integer.parseInt(edadAnadir.getText());
		String genero = "";
		Boolean Hombre = hombreAnadir.isSelected();
		Boolean Mujer = mujerAnadir.isSelected();		
		String local = localidad.getValue();
		
		if(Hombre == false && Mujer == false) {
			genero = null;
		}
		else if(Hombre == true && Mujer == false) {
			genero = "Hombre";
		}
		else {
			genero = "Mujer";
		}
		
		Socio s = new Socio(nombre, apell, dni, email, tlf, edad, genero, local);
		return s;
	}
}