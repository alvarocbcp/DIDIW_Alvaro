package editar;

import java.net.URL;
import java.util.ResourceBundle;

import dinamico.Socio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;

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

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnModificar;

	@FXML
	private Button btnAnadir;

	Socio s = null;
	
	int posTabla = 0;

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
		
		btnEliminar.setOnMouseClicked(event ->{
			eliminar();
		});
		
		btnModificar.setOnMouseClicked(event ->{
			modificar();
		});
		
		btnAnadir.setOnMouseClicked(event ->{
			anadir();
		});
		
		nombreAnadir.addEventFilter(KeyEvent.KEY_TYPED, e->{
			if(Character.isDigit(e.getCharacter().charAt(0))) {
				e.consume();
			}
		});
		
		tlfnAnadir.addEventFilter(KeyEvent.KEY_TYPED, e->{
			if(Character.isAlphabetic(e.getCharacter().charAt(0))) {
				e.consume();
			}
		});
		
		edadAnadir.addEventFilter(KeyEvent.KEY_TYPED, e->{
			if(Character.isAlphabetic(e.getCharacter().charAt(0))) {
				e.consume();
			}
		});
		
	}

	@FXML
	public void anadir() {		
		if(nombreAnadir.getText().equals("")||apellAnadir.getText().equals("")||dniAnadir.getText().equals("")||emailAnadir.getText().equals("")||tlfnAnadir.getText().equals("")||edadAnadir.getText().equals("")||(!hombreAnadir.isSelected() && !mujerAnadir.isSelected())||localidad.getValue()==null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("Rellene campos");
			alert.setContentText("Para añadir un nuevo socio, rellene todos los campos");
			alert.show();
		}
		else {
			Boolean existe = false;

			Boolean Hombre = hombreAnadir.isSelected();
			Boolean Mujer = mujerAnadir.isSelected();
			String nombre = nombreAnadir.getText();
			String apell = apellAnadir.getText();
			String dni = dniAnadir.getText();
			String email = nombreAnadir.getText();
			String tlf = tlfnAnadir.getText();
			Integer edad = Integer.parseInt(edadAnadir.getText());
			String genero = "";
			if(Hombre == false && Mujer == false) {
				genero = null;
			}
			else if(Hombre == true && Mujer == false) {
				genero = "Hombre";
			}
			else {
				genero = "Mujer";
			}
			String local = localidad.getValue();



			for(int i = 0; i<dinamico.ListController.datos.size(); i++) {
				if(dinamico.ListController.datos.get(i).getDNI().equals(dni)) {
					existe = true;
				}
			}

			if(existe == false) {
				s = new Socio(nombre, apell, dni, email, tlf, edad, genero, local);
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("CONFIRMACIÓN");
				alert.setHeaderText("Confirme inserción");
				alert.setContentText("¿Desea de verdad añadir el socio?");
				alert.showAndWait().ifPresent(response ->{
					if(response==ButtonType.OK) {
						dinamico.ListController.datos.add(s);
						Alert a = new Alert(AlertType.INFORMATION);
						a.setTitle("AÑADIDO");
						a.setHeaderText("Socio añadido");
						a.setContentText("El socio ha sido añadido correctamente");
						a.show();
					}
					else if(response==ButtonType.CANCEL) {
						Alert a = new Alert(AlertType.INFORMATION);
						a.setTitle("CANCELADO");
						a.setHeaderText("Socio no insertado");
						a.setContentText("Se ha cancelado la inserción del socio en la tabla");
						a.show();
					}
				});
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("DNI Existente");
				alert.setContentText("El socio que desea añadir ya existe en la tabla");
				alert.show();
			}
		}
	}
	
	@FXML
	public void modificar() {
		Boolean existe = false;
		
		Boolean Hombre = hombreAnadir.isSelected();
		Boolean Mujer = mujerAnadir.isSelected();
		String nombre;
		String apell;
		String dni = dniAnadir.getText();
		String email;
		String tlf;
		Integer edad;
		String genero = "";
		String local;
		
		if(dniAnadir.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("Rellene DNI");
			alert.setContentText("Para modificar un socio, rellene el su DNI y los campos que desee modificar");
			alert.show();
		}
		else {
			for(int i=0; i<dinamico.ListController.datos.size(); i++) {
				if(dinamico.ListController.datos.get(i).getDNI().equals(dni)) {
					existe = true;
					posTabla = i;
					
					if(nombreAnadir.getText().equals("")) {
						nombre = dinamico.ListController.datos.get(i).getNombre();
					}
					else {
						nombre = nombreAnadir.getText();
					}
					
					if(apellAnadir.getText().equals("")) {
						apell = dinamico.ListController.datos.get(i).getApellidos();
					}
					else {
						apell = apellAnadir.getText();
					}
					
					if(emailAnadir.getText().equals("")) {
						email = dinamico.ListController.datos.get(i).getEmail();
					}
					else {
						email = nombreAnadir.getText();
					}
					
					if(tlfnAnadir.getText().equals("")) {
						tlf = dinamico.ListController.datos.get(i).getTlfn();
					}
					else {
						tlf = tlfnAnadir.getText();
					}
					
					if(edadAnadir.getText().equals("")) {
						edad = dinamico.ListController.datos.get(i).getEdad();
					}
					else {
						edad = Integer.parseInt(edadAnadir.getText());
					}
					
					if((!hombreAnadir.isSelected() && !mujerAnadir.isSelected())) {
						genero = dinamico.ListController.datos.get(i).getGenero();
					}
					else {
						if(Hombre == true && Mujer == false) {
							genero = "Hombre";
						}
						else {
							genero = "Mujer";
						}
					}
					
					if(localidad.getValue()==null) {
						local = dinamico.ListController.datos.get(i).getLocalidad();
					}
					else {
						local = localidad.getValue();
					}
					
					s = new Socio(nombre, apell, dni, email, tlf, edad, genero, local);
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("CONFIRMACIÓN");
					alert.setHeaderText("Confirme modificación");
					alert.setContentText("¿Desea modificar el socio?");
					alert.showAndWait().ifPresent(response ->{
						if(response==ButtonType.OK) {
							dinamico.ListController.datos.set(posTabla, s);
							Alert a = new Alert(AlertType.INFORMATION);
							a.setTitle("MODIFICADO");
							a.setHeaderText("Socio Modificado");
							a.setContentText("El socio ha sido modificado correctamente");
							a.show();
						}
						else if(response==ButtonType.CANCEL) {
							Alert a = new Alert(AlertType.INFORMATION);
							a.setTitle("CANCELADO");
							a.setHeaderText("Socio no modificado");
							a.setContentText("Se ha cancelado la modificación del socio en la tabla");
							a.show();
						}
					});
				}
			}
		}		
	}
	
	@FXML
	public void eliminar() {
		String dni = dniAnadir.getText();
		Boolean existe = false;
		
		for(int i=0; i<dinamico.ListController.datos.size(); i++) {
			if(dinamico.ListController.datos.get(i).getDNI().equals(dni)) {
				existe = true;
				posTabla = i;
			}
		}
		if(existe == true) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("CONFIRMACIÓN");
			alert.setHeaderText("Confirme el borrado");
			alert.setContentText("¿Desea borrar el socio con DNI: " + dni + "?");
			alert.showAndWait().ifPresent(response ->{
				if(response==ButtonType.OK) {
					dinamico.ListController.datos.remove(posTabla);
					Alert a = new Alert(AlertType.INFORMATION);
					a.setTitle("ELIMINADO");
					a.setHeaderText("Socio eliminado");
					a.setContentText("El socio ha sido eliminado correctamente");
					a.show();
				}
				else if(response==ButtonType.CANCEL) {
					Alert a = new Alert(AlertType.INFORMATION);
					a.setTitle("CANCELADO");
					a.setHeaderText("Socio no eliminado");
					a.setContentText("Se ha cancelado el borrado del socio");
					a.show();
				}
			});
		}
		else {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("ERROR");
			a.setHeaderText("Socio no encontrado");
			a.setContentText("El socio con DNI: " + dni + " no existe");
			a.show();
		}
	}

	/*
	@FXML
	public void recibirDatos(ActionEvent event) {  

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
	}
	 */
}