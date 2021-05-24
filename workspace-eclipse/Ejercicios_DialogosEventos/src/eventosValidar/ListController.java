package eventosValidar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button boton;
    
    @FXML
    private TextField texto;

    @FXML
    void initialize() {
    	
    	TextInputDialog dialogo = new TextInputDialog();
    	dialogo.setTitle("Ejemplo de dialogo");
    	dialogo.setHeaderText("Dialogo para introducir texto");
    	
    	DialogPane pantallaDialogo = dialogo.getDialogPane();
    	
    	pantallaDialogo.addEventFilter(KeyEvent.KEY_TYPED, e ->{
    		if(Character.isLowerCase(e.getCharacter().charAt(0))) {
    			e.consume();
    		}
    	});
    	
    	pantallaDialogo.setOnKeyPressed(new EventHandler<KeyEvent>() {
    		public void handle(KeyEvent e) {
    			if(e.getCode().equals(KeyCode.ENTER) || e.getCode().equals(KeyCode.ESCAPE)) {
    				e.consume();
    			}
    		}
		});
    	
    	
        boton.setOnAction(e -> {
        	dialogo.showAndWait().ifPresent(response -> {
        		texto.setText(dialogo.getResult());
        		texto.requestFocus();
        	});
        });
        
        texto.setOnMouseEntered(e -> {
        	texto.setCursor(Cursor.HAND);
        });

    }
}