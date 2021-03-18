package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;

public class ListController {

    @FXML
    private ComboBox<String> location;

    @FXML
    private ToggleGroup genero;

    @FXML
    void initialize() {
        location.getItems().addAll("New York", "Orlando");

    }
}