package Entities;

public class Persona {
	private String Nombre;
	private String DNI;
	
	public Persona(String Apellido, String Nombre, String DNI) {
		this.Apellido = Apellido;
		this.Nombre = Nombre;
		this.DNI = DNI;
	}
	
	private String Apellido;
	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

}
