package menues;

import java.util.*;

import modelos.Usuarios;

public class MenuEmpleados {

	Scanner sc = new Scanner(System.in);
	private boolean continuar = true;
	private ArrayList<Usuarios> listaUsuarios;

	public MenuEmpleados(ArrayList<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void iniciar() {
		while (continuar) {
			System.out.println("Bienvenido al registro de empleados, a continuacion seleccione una opcion");
			System.out.println("1- Registro emplado");
			System.out.println("2- Mostrar listado Empleados");
			System.out.println("3- Volver al Login");
			int opcion = this.sc.nextInt();

			switch (opcion) {
			case 1:
				this.registroEmpleado();
				break;
			case 2:
				this.mostrarListadoEmpleados(listaUsuarios);
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

	private void registroEmpleado() {
		System.out.println("Ingrese el nombre del empleado");
		String nombre = this.sc.next();
		System.out.println("Ingrese apellido del empleado");
		String apellido = this.sc.next();

		String contrasenia;
		String confirmarContrasenia;

		while (true) {
			System.out.println("Ingrese contrasenia");
			contrasenia = this.sc.next();
			System.out.println("Confirme la contrasenia");
			confirmarContrasenia = this.sc.next();

			if (contrasenia.equalsIgnoreCase(confirmarContrasenia)) {
				break;
			} else {
				System.out.println("Las contraseñas no coinciden. Inténtelo de nuevo.");
			}
		}

		System.out.println("Ingrese la clave de registro de empleado");
		String claveEmpleado = this.sc.next();
		if (claveEmpleado.equalsIgnoreCase("pepepiola123")) {
			System.out.println("Registro de empleado exitoso");
			Usuarios empleado = new Usuarios(nombre, apellido, contrasenia);
			listaUsuarios.add(empleado);
		} else {
			System.out.println("Clave de registro incorrecta.");
		}
	}

	private void mostrarListadoEmpleados(ArrayList<Usuarios> listaUsuarios) {

		if (listaUsuarios.isEmpty()) {
			System.out.println("No se encuentra ningun Empleado en el sistema");
		} else {
			for (Usuarios usuarios : this.listaUsuarios) {
				System.out.println("Listado de Empleados registrados");
				System.out.println(
						"Los Empleados registrados son: " + usuarios.getNombre() + " " + usuarios.getApellido());
				System.out.println("-------------------------------------------------");
			}
		}

	}

}
