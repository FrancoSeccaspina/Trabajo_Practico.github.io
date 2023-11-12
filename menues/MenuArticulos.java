package menues;

import java.util.*;
import modelos.Articulo;

public class MenuArticulos {
	Scanner sc = new Scanner(System.in);
	private boolean continuar = true;
	private ArrayList<Articulo> listaArticulos;

	public MenuArticulos(ArrayList<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

	public void iniciar() {
		while (continuar) {
			System.out.println("Bienvenido al registro de Articulos, seleccione una opcion:");
			System.out.println("1- Cargar un nuevo articulo");
			System.out.println("2- Editar articulo");
			System.out.println("3- Eliminar articulo");
			System.out.println("4- Mostrar listado de articulos");
			System.out.println("5- Volver al menu principal");
			int opcion = this.sc.nextInt();

			switch (opcion) {
			case 1:
				this.cargarArticulo();
				break;
			case 2:
				this.editarArticulo();
				break;
			case 3:
				this.eliminarArticulo();
				break;
			case 4:
				this.listadoDeArticulos(listaArticulos);
				break;
			case 5:
				continuar = false;
				break;
			default:
				System.out.println("Opción no válida. Por favor, elija una opción válida.");
				break;
			}
		}
	}

	private void eliminarArticulo() {
		System.out.println("Ingrese numero de articulo a borrar");
		String codigoArticulo = this.sc.next();

		Iterator<Articulo> iterator = listaArticulos.iterator();
		while (iterator.hasNext()) {
			Articulo articulo = iterator.next();
			if (articulo.getCodigoArticulo().equals(codigoArticulo)) {
				iterator.remove();
				System.out.println("Articulo eliminado con exito");
				return;
			}
		}
		System.out.println("No se encontro el codigo de barra a eliminar.");
	}

	private void editarArticulo() {
		System.out.println("Ingrese el codigo de barra del articulo a editar: ");
		String codigoArticulo = this.sc.next();
		boolean encontrado = false;

		for (Articulo articulo : this.listaArticulos) {
		    if (articulo.getCodigoArticulo().equals(codigoArticulo)) {
		        encontrado = true;
		        System.out.println("Codigo del articulo: " + articulo.getCodigoArticulo());
		        System.out.println("Nombre del articulo: " + articulo.getDescripcion());
		        System.out.println("Precio actual: " + articulo.getPrecioNeto());
		        System.out.println("Cantidad de stock actual: " + articulo.getStock());

		        System.out.print("Ingrese la nueva cantidad de stock: ");
		        int nuevoStock = this.sc.nextInt();

		        while (nuevoStock < 0) {
		            System.out.println("La cantidad de stock no puede ser negativa. Vuelva a ingresar:");
		            nuevoStock = this.sc.nextInt();
		        }

		        articulo.setStock(nuevoStock);
		        System.out.println("Cantidad de stock actualizada con éxito.");

		        System.out.println("¿Desea editar el precio? (s/n)");
		        char editarPrecio = this.sc.next().charAt(0);
		        if (Character.toLowerCase(editarPrecio) == 's') {
		            System.out.println("Ingrese el nuevo precio: ");
		            double otroPrecio = this.sc.nextDouble();
		            while (otroPrecio < 0) {
		                System.out.println("El precio no puede ser negativo. Vuelva a ingresar:");
		                otroPrecio = this.sc.nextDouble();
		                articulo.setPrecio(otroPrecio);
          }
		            System.out.println("Precio actualizado con éxito.");
		        }
		    }
		}

		if (!encontrado) {
		    System.out.println("No se encontró un artículo con el código proporcionado. Vuelva a intentarlo.");
		}
	}

	private void cargarArticulo() {
		System.out.println("Ingrese nombre del articulo: ");
		String descripcion = this.sc.next();

		String codigoArticulo;
		while (true) {
			System.out.println("Ingrese el codigo de barra del articulo: ");
			codigoArticulo = this.sc.next();
			if (!existeArticulo(codigoArticulo)) {
				break;
			} else {
				System.out.println("Codigo de barra ya existente. Ingrese uno nuevo.");
			}
		}

		double precioNeto;
		while (true) {
			System.out.print("Ingrese el precio del articulo: ");
			precioNeto = this.sc.nextDouble();
			if (precioNeto >= 0) {
				break;
			} else {
				System.out.println("El precio neto no puede ser menor que 0. Intente nuevamente.");
			}
		}

		System.out.println("Ingrese cantidad de stock: ");
		int stock = this.sc.nextInt();

		System.out.print("¿Este articulo esta en demanda? (S/N): ");
		String respuesta = this.sc.next().toLowerCase();
		char porDemanda;
		if (respuesta.equals("s") || respuesta.equals("n")) {
			porDemanda = respuesta.charAt(0);
		} else {
			System.out.println("Respuesta no valida. Por favor, responda con S o N.");
			return;
		}

		char desCategoria;
		while (true) {
			System.out.println("Ingrese la categoria del articulo (A, B, C): ");
			desCategoria = Character.toUpperCase(this.sc.next().charAt(0));
			if (desCategoria == 'A' || desCategoria == 'B' || desCategoria == 'C') {
				break;
			} else {
				System.out.println("Categoria no válida. Ingrese A, B o C.");
			}
		}

		double precioConDescuento = calcularPrecioConDescuento(precioNeto, stock, desCategoria);

		Articulo articulo = new Articulo(codigoArticulo, descripcion, precioNeto, precioConDescuento, stock, porDemanda,
				desCategoria);

		listaArticulos.add(articulo);
		System.out.println("Articulo agregado con exito.");
	}

	private double calcularPrecioConDescuento(double precioNeto, int stock, char desCategoria) {
		double precioFinal = precioNeto;

		switch (Character.toUpperCase(desCategoria)) {
		case 'A':
			precioFinal *= 0.7; // Aplica un 30% de descuento
			break;
		case 'B':
			precioFinal *= 0.76; // Aplica un 24% de descuento
			break;
		case 'C':
			precioFinal *= 0.85; // Aplica un 15% de descuento
			break;
		default:
			System.out.println("No se aplicara ningun descuento.");
			break;
		}

		return precioFinal;
	}

	private boolean existeArticulo(String codigoArticulo) {
		for (Articulo articulo : this.listaArticulos) {
			if (articulo.getCodigoArticulo().equals(codigoArticulo)) {
				System.out.println("Codigo de barras ya existente. Intentelo nuevamente.");
				return true;
			}
		}
		return false;
	}

	private void listadoDeArticulos(ArrayList<Articulo> listaArticulos) {
		if (listaArticulos.isEmpty()) {
			System.out.println("No se encuentran articulos en el sistema.");
		} else {
			System.out.println("Listado de articulos en el sistema:");

			for (Articulo articulo : this.listaArticulos) {
				System.out.println("El Articulo " + articulo.getDescripcion() + " y su precio $"
						+ articulo.getPrecioNeto() + " y su categoria es " + "(" + articulo.getCategoria() + ")");
			}
		}
	}
}