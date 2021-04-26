package basicoDinamico;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * Clase auxiliar que se empleará para el modelo de datos del TableView
 * 
 * @author SBF
 * 
 */
public class Person {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
    private final SimpleIntegerProperty age;
 
    public Person(String fName, String lName, String email, Integer age) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
        this.age = new SimpleIntegerProperty(age);
    }
 
    public String getFirstName() {
        return firstName.get();
    }
    
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
        
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String fName) {
        lastName.set(fName);
    }
    
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String fName) {
        email.set(fName);
    }

	public Integer getAge() {
		return age.get();
	}
	public void setAge(Integer fAge) {
		age.set(fAge);
    }        
        
}