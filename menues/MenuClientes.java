package menues;
import java.util.*;

import modelos.Usuarios;
public class MenuClientes {
	
	Scanner sc = new Scanner(System.in);
	private boolean continuar = true;
	private ArrayList<Usuarios> listaUsuarios;
	
	public MenuClientes(ArrayList<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public void iniciar() {
		while(continuar) {
			System.out.println("Bienvenido al registro de clientes, a continuacion seleccione una opcion");
			System.out.println("1- Registro clientes");
			System.out.println("2- Mostrar listado Clientes");
			System.out.println("3- Volver al Login");
			int opcion = this.sc.nextInt();
			
			switch (opcion) {
			case 1: 
				this.registroCliente();
				break;
			case 2:
				this.mostrarListadoClientes(listaUsuarios);
				break;
			case 3:
				continuar = false;
				break;
			default:
				System.out.println("Opcion no valida. Por favor, elija una opcion valida.");
				break;
			}
		}
	}

	private void registroCliente() {
		System.out.println("Ingrese el nombre del cliente");
		String nombre = this.sc.next();
		System.out.println("Ingrese apellido del cliente");
		String apellido = this.sc.next();
		System.out.println("Ingrese contrasenia");
		String contrasenia = this.sc.next();
		System.out.println("Confirme la contrasenia");
		String confirmarContrasenia = this.sc.next();
		if(!contrasenia.equalsIgnoreCase(confirmarContrasenia)) {
			System.out.println("Las constrasenias no coincides, intentelo de nuevo");
		}else {
			System.out.println("Seleccione la letra (c) para continuar con el registro: ");
			String tipoUsuario = this.sc.next();
			if(tipoUsuario.equalsIgnoreCase("c")) {
				Usuarios cliente = new Usuarios (nombre, apellido, contrasenia);
				listaUsuarios.add(cliente);
				System.out.println("Registro de usuario exitoso");
			}else {
				System.out.println("Tipo de usuario invalido");
			}
		}
	
	}
	
	private void mostrarListadoClientes(ArrayList<Usuarios> listaUsuarios) {
		
		if(listaUsuarios.isEmpty()) {
			System.out.println("No se encuentra ningun Cliente en el sistema");
		}else {
			for (Usuarios usuarios : this.listaUsuarios) {
				System.out.println("Listado de Clientes registrados");
				System.out.println("Los Clientes registrados son: " + usuarios.getNombre() + " " + usuarios.getApellido());
				System.out.println("-------------------------------------------------");
			}
		}
		
	}
}
