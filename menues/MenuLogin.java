package menues;

import java.util.ArrayList;
import java.util.Scanner;
import modelos.Articulo;
import modelos.Usuarios;

public class MenuLogin {

	private Scanner sc;
	private boolean continuar;
	private ArrayList<Usuarios> listaUsuarios;
	private ArrayList<Articulo> listArticulos;

	public MenuLogin(Scanner sc, ArrayList<Usuarios> listaUsuarios, ArrayList<Articulo> listArticulos) {
		super();
		this.sc = sc;
		this.listaUsuarios = listaUsuarios;
		this.listArticulos = listArticulos;
	}

	public void iniciar() {
		continuar = true;

		while (continuar) {
			System.out.println("Bienvenido al Login:");
			System.out.println("Desea ingresar como Usuario o Empleado(u/e)");
			char respuesta = this.sc.next().charAt(0);

			if (Character.toLowerCase(respuesta) == 'u') {
				MenuClientes menuCliente = new MenuClientes(listaUsuarios);
				menuCliente.iniciar();
			} else if(Character.toLowerCase(respuesta) == 'e') {
				MenuEmpleados menuEmpleado = new MenuEmpleados(listaUsuarios);
				menuEmpleado.iniciar();
			}else {
				System.out.println("Clave invalida");
				continue;
			}
			
			System.out.println("Desea ingresar al menu de articulos?(S/N)");
			char rta = this.sc.next().charAt(0);
			if(Character.toLowerCase(rta) == 's') {
				MenuArticulos menuArticulos = new MenuArticulos(listArticulos);
				menuArticulos.iniciar();
			}else if(Character.toLowerCase(rta) == 'n'){
				System.out.println("Fin del programa");
				continuar = false;
			}else {
				System.out.println("Fin del programa");
				continuar = false;
			}
				
				
		}

	}

}
