package main;
import java.util.*;

import menues.MenuLogin;
import modelos.Articulo;
import modelos.Usuarios;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
		
		ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();

		MenuLogin menuLogin = new MenuLogin(sc, listaUsuarios, listaArticulos);
		
		menuLogin.iniciar();
		
		sc.close();

	}

}
