package dinamico;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Socio {
	public SimpleStringProperty nombre;
	public SimpleStringProperty apellidos;
	public SimpleStringProperty DNI;
	public SimpleStringProperty email;
	public SimpleStringProperty tlfn;
	public SimpleIntegerProperty edad;
	public SimpleStringProperty genero;
	public SimpleStringProperty localidad;
	
	public Socio() {
		
	}
	
	public Socio(String nom, String ape, String DNI, String email, String tl, Integer ed, String genero, String localidad) {
		this.nombre = new SimpleStringProperty(nom);
		this.apellidos = new SimpleStringProperty(ape);
		this.DNI = new SimpleStringProperty(DNI);
		this.email = new SimpleStringProperty(email);
		this.tlfn = new SimpleStringProperty(tl);
		this.edad = new SimpleIntegerProperty(ed);
		this.genero = new SimpleStringProperty(genero);
		this.localidad = new SimpleStringProperty(localidad);
	}
	
	public String getNombre() {
		return nombre.get();
	}
	
	public void setNombre(String nom) {
        nombre.set(nom);
	}
	
	public String getApellidos() {
		return apellidos.get();
	}
	
	public void setApellidos(String ape) {
        apellidos.set(ape);
	}
	
	public String getDNI() {
		return DNI.get();
	}
	
	public void setDNI(String dni) {
        DNI.set(dni);
	}

	public String getEmail() {
		return email.get();
	}
	
	public void setEmail(String em) {
        email.set(em);
    }

	public String getTlfn() {
		return tlfn.get();
	}
	
	public void setTelefono(String tl) {
        tlfn.set(tl);
    }

	public Integer getEdad() {
		return edad.get();
	}
	
	public void setEdad(Integer ed) {
        edad.set(ed);
    }
	
	public String getGenero() {
		return genero.get();
	}
	
	public void setGenero(String gen) {
        genero.set(gen);
	}
	
	public String getLocalidad() {
		return localidad.get();
	}
	
	public void setLocalidad(String loc) {
        localidad.set(loc);
	}

}
