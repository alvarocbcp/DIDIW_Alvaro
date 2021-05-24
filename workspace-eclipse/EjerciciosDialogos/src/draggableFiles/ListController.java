package draggableFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label1;

    @FXML
    private Label label2;
    
    @FXML
    private ImageView destinoImagen;

    @FXML
    void initialize() {
    	
    	label1.setOnDragDetected(event ->{
    		Dragboard db = label1.startDragAndDrop(TransferMode.MOVE);
    		ClipboardContent cbc = new ClipboardContent();
    		cbc.putString(label1.getText());
    		db.setContent(cbc);
    	});
    	
    	label2.setOnDragOver(event ->{
    		if(event.getGestureSource()!=label2 && event.getDragboard().hasString()) {
    			event.acceptTransferModes(TransferMode.MOVE);
    		}
    	});
    	
    	label2.setOnDragDropped(event ->{
    		Dragboard db = event.getDragboard();
    		boolean booleano = false;
    		if(db.hasString()) {
    			label2.setText(db.getString());
    			booleano = true;
    		}
    		event.setDropCompleted(booleano);
    	});
    	
    	label1.setOnDragDone(event ->{
    		if(event.getTransferMode() == TransferMode.MOVE) {
    			label1.setText("Operacion drag terminada");
    		}
    	});
    }
    
    @FXML
    private void handlerDragOver(DragEvent event) {
    	if(event.getDragboard().hasFiles()) {
    		event.acceptTransferModes(TransferMode.ANY);
    	}
    }
    
    @FXML
    private void handleDrop(DragEvent event) {
    	List<File> lista = event.getDragboard().getFiles();
    	try {
			Image imagen = new Image(new FileInputStream(lista.get(0)));
			destinoImagen.setImage(imagen);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
