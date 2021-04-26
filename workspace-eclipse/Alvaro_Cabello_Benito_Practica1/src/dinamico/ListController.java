package dinamico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Socio> tabla;
    
    @FXML
    private TableColumn<Socio, String> nombreCol;

    @FXML
    private TableColumn<Socio, String> apellidosCol;
    
    @FXML
    private TableColumn<Socio, String> dniCol;

    
    @FXML
    private TableColumn<Socio, String> emailCol;

    
    @FXML
    private TableColumn<Socio, String> telefonoCol;

    
    @FXML
    private TableColumn<Socio, Integer> edadCol;
    
    @FXML
    private TableColumn<Socio, String> generoCol;
    
    @FXML
    private TableColumn<Socio, String> localidadCol;

    
    private ObservableList<Socio> datos = FXCollections.observableArrayList(
    		new Socio("Álvaro", "Cabello Benito", "65485245F", "alvarocbcp@gmail.com", "654654845", 20, "Hombre", "Madrid"),
    		new Socio("Pablo", "Herrán Castrillo", "74125854G", "pabloherran@gmail.com", "689532147", 56, "Hombre", "Barcelona"),
    		new Socio("Pablo", "Hormigo González", "45852474J", "pablohormigo@gmail.com", "654654545", 86, "Hombre", "Valencia")
    		);

    @FXML
    void initialize() {
    	
    	nombreCol.setCellValueFactory(new PropertyValueFactory<Socio, String>("Nombre"));
    	apellidosCol.setCellValueFactory(new PropertyValueFactory<Socio, String>("Apellidos"));
    	dniCol.setCellValueFactory(new PropertyValueFactory<Socio, String>("DNI"));
    	emailCol.setCellValueFactory(new PropertyValueFactory<Socio, String>("Email"));
    	telefonoCol.setCellValueFactory(new PropertyValueFactory<Socio, String>("Tlfn"));
    	edadCol.setCellValueFactory(new PropertyValueFactory<Socio, Integer>("Edad"));
    	generoCol.setCellValueFactory(new PropertyValueFactory<Socio, String>("Genero"));
    	localidadCol.setCellValueFactory(new PropertyValueFactory<Socio, String>("Localidad"));
    	
    	tabla.setItems(datos);
    }
}