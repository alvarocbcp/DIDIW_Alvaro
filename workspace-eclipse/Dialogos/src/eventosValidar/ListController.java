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
    private TextField tf;

    @FXML
    private Button btn;

    @FXML
    void initialize() {
    	TextInputDialog td = new TextInputDialog();
    	td.setTitle("Ejemplo de dialogo");
    	td.setHeaderText("Dialogo para introducir texto");
    	
    	DialogPane dp = td.getDialogPane();
    	
    	dp.addEventFilter(KeyEvent.KEY_TYPED, e->{
    		if(Character.isLowerCase(e.getCharacter().charAt(0))) {
    			e.consume();
    		}
    	});
    	
    	dp.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				if(e.getCode().equals(KeyCode.ENTER) || e.getCode().equals(KeyCode.ESCAPE)) {
					e.consume();
				}
			}
		});
    	
    	btn.setOnAction(e->{
    		td.showAndWait().ifPresent(response ->{
    			tf.setText(td.getResult());
    			tf.requestFocus();
    		});
    	});
    	
    	tf.setOnMouseEntered(e->{
    		tf.setCursor(Cursor.HAND);
    	});
    	
    }
}