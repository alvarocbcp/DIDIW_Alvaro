package dinamico;

import javafx.beans.property.SimpleStringProperty;

public class Socio {
	private final SimpleStringProperty nombre;
	private final SimpleStringProperty apellido1;
	private final SimpleStringProperty apellido2;
	private final SimpleStringProperty email;
	private final SimpleStringProperty tlfn;
	private final SimpleStringProperty edad;
	
	public Socio(String nom, String ape1, String ape2, String email, String tlfn, String edad) {
		this.nombre = new SimpleStringProperty(nom);
		this.apellido1 = new SimpleStringProperty(ape1);
		this.apellido2 = new SimpleStringProperty(ape2);
		this.email = new SimpleStringProperty(email);
		this.tlfn = new SimpleStringProperty(tlfn);
		this.edad = new SimpleStringProperty(edad);
	}
	
	public SimpleStringProperty getNombre() {
		return nombre;
	}
	
	public void setNombre(String nom) {
        nombre.set(nom);
    }

	public SimpleStringProperty getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String ape1) {
        apellido1.set(ape1);
    }

	public SimpleStringProperty getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String ape2) {
        apellido2.set(ape2);
    }

	public SimpleStringProperty getEmail() {
		return email;
	}
	
	public void setEmail(String em) {
        email.set(em);
    }

	public SimpleStringProperty getTlfn() {
		return tlfn;
	}
	
	public void setTelefono(String tl) {
        tlfn.set(tl);
    }

	public SimpleStringProperty getEdad() {
		return edad;
	}
	
	public void setEdad(String ed) {
        edad.set(ed);
    }

}
