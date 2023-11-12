package modelos;

public class Usuarios {
	protected String nombre;
	protected String apellido;
	protected String contrasenia;
	
	public Usuarios(String nombre, String apellido, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	
	
}
