package menues;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Articulo;
import modelos.Usuarios;

public class MenuPrincipal {
	private boolean activo = true;
	private Scanner sc;
	private ArrayList<Usuarios> listaUsuarios;
	private ArrayList<Articulo> listaArticulos;
	
	public MenuPrincipal(Scanner sc, ArrayList<Usuarios> listaUsuarios, ArrayList<Articulo> listaArticulos) {
		this.sc = sc;
		this.listaUsuarios = listaUsuarios;
	}
	
	public void iniciar() {
		while (activo) {
			this.menuOpciones();
			int opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 0:
				this.finalizar();
				break;

			case 1:
				MenuClientes menuCliente = new MenuClientes(listaUsuarios);
				menuCliente.iniciar();
				break;

			case 2:
				MenuEmpleados menuEmpleado = new MenuEmpleados(listaUsuarios);
				menuEmpleado.iniciar();
				break;

			case 3:
				MenuArticulos menuArticulo = new MenuArticulos(listaArticulos);
				menuArticulo.iniciar();
				break;

			case 4:

				break;
			default:
				System.out.println("Opcion no valida. Por favor, elija una opcion valida.");
				break;
			}
		}
		if (activo) {
			System.out.println("¿Desea ingresar otro socio/a? (S/N)");
			String respuesta = sc.next();
			if (respuesta.equalsIgnoreCase("n")) {
				finalizar();

			}
		}
	}
	public void menuOpciones() { // Ya copiado
		System.out.println("Bienvenido, seleccione una opcion");
		System.out.println("0- Salir");
		System.out.println("1- Registro de clientes ");
		System.out.println("2- Registro de empleados");
		System.out.println("3- Ingresar al menu de articulos");
	}
	private void finalizar() { // Ya copiado
		activo = false;
		System.out.println("Saliendo del programa");
	}
}
