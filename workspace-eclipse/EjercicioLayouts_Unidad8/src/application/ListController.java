package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxListCell;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup genero;

    @FXML
    private ChoiceBox<Object> localizacion;
    
    @FXML
    private ListView<String> cualificaciones;
    
    public static final ObservableList nombres = FXCollections.observableArrayList();
    public static final ObservableList principal = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        localizacion.setValue("Select a value...");
        localizacion.getItems().addAll("New York", "Orlando", new Separator(), "London", "Manchester");

        nombres.addAll("Objects", "Classes", "Functions", "Variables", "Compiler", "Debugger", "Projects", "Beans", "Libraries", "Modules");
        
        for(int i=0; i<10; i++) {
        	principal.add("Indeterminate (pick a choice)");
        }
        
        cualificaciones.setEditable(true);
        cualificaciones.setItems(principal);
        cualificaciones.setCellFactory(ComboBoxListCell.forListView(nombres));
        
    }
}