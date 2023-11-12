package modelos;

public class Empleado extends Usuarios{
	private String confirmarContrasenia;

	public Empleado(String nombre, String apellido, String contrasenia, String ConfirmarContrasenia) {
		super(nombre, apellido, contrasenia);
	}
	
	public String getConfirmarContrasenia() {
		return confirmarContrasenia;
	}
}
