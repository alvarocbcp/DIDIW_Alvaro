package dinamico;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    public static ObservableList<Socio> datos = FXCollections.observableArrayList();
    
    @FXML
    public static ObservableList<Socio> datosAux = FXCollections.observableArrayList();
    
    @FXML
    private Slider slider;
    
    boolean existe = false;

    @FXML
    void initialize() {
    	
    	
    	
    	slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				int valorSlider = newValue.intValue();
				tabla.refresh();
				for(int i= 0; i<datos.size(); i++) {
					if(valorSlider==0) {
						Socio s = datos.get(i);
						datosAux.add(s);
					}
					else {
						System.out.println(datos.get(i).getEdad());
						if(datos.get(i).getEdad()>50) {
							Socio s = datos.get(i);
							for(int j = 0; j<datos.size(); j++) {
								if(s.getDNI()==datos.get(i).getDNI()) {
									existe = true;
								}
							}
							if(existe == false) {
								datosAux.add(s);
							}
						}
						tabla.setItems(datosAux);
						tabla.refresh();
					}
					return;
				}
				tabla.setItems(datosAux);
				tabla.refresh();
			}
			
    		
		});
    	
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
    			datos.remove(tabla.getSelectionModel().getSelectedIndex());
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