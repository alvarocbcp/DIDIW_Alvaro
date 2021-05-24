package dinamico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

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
    
    @FXML
    private ImageView papelera;

    @FXML
    public static ObservableList<Socio> datos = FXCollections.observableArrayList(
    		);

    @FXML
    void initialize() {
    	
    	papelera.setOnDragOver(event ->{
    		if(event.getGestureSource()!=papelera && event.getDragboard().hasString()) {
    			event.acceptTransferModes(TransferMode.MOVE);
    		}
    	});
    	
    	tabla.setOnDragDetected(event ->{
    		Dragboard db = tabla.startDragAndDrop(TransferMode.ANY);
    		ClipboardContent cbc = new ClipboardContent();
    		String selected = tabla.getSelectionModel().getSelectedItem().getDNI();
    		cbc.putString(selected);
    		db.setContent(cbc);
    		
    	});
    	
    	tabla.setOnDragDone(event ->{
    		if(event.getTransferMode() == TransferMode.MOVE) {
    			Alert alert = new Alert(AlertType.CONFIRMATION);
    			alert.setTitle("CONFIRMACIÓN");
    			alert.setHeaderText("Confirme el borrado");
    			alert.setContentText("¿Desea borrar el socio?");
    			alert.showAndWait().ifPresent(response ->{
    				if(response==ButtonType.OK) {
    					datos.remove(tabla.getSelectionModel().getSelectedIndex());
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
    	});
    	
    	papelera.setOnDragDropped(event ->{
    		Dragboard db = event.getDragboard();
    		boolean booleano = false;
    		if(db.hasString()) {
    			booleano = true;
    		}
    		event.setDropCompleted(booleano);
    	});
    	
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