package cine;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Utilidades {
	public static String[] menu(String tipoMenu) {
		switch(tipoMenu) {
		case "Menu principal":
			String[] menu= {"Gestión de Películas", "Gestión de Clientes", "Gestión de Funciones", "Salir"};
			return menu;
		case "Gestión de Películas": 
			String[] menuPeliculas = {"Nueva Pelicula", "Ver datos", "Modificar película", "Volver"};
			return menuPeliculas;
		case "Gestión de Clientes":
			String[] menuClientes = {"Nuevo Cliente", "Modificar datos", "Ver datos de clientes", "Realizar compra", "Ver historial", "Volver"};
			return menuClientes;
		case "Gestión de Funciones":
			String[] menuFunciones= {"Nueva función", "Ver funciones activas", "Terminar función activa", "Historial de funciones", "Volver"};
			return menuFunciones;
		case "Clasificación de pelicula":
			String[] clasificaciones= {"ATP", "PG-13", "PG-17"};
			return clasificaciones;
		case "Modificar Cortometraje":
			String[] modificarCorto= {"Modificar titulo", "Modificar director", "Modificar duracion", "Modificar clasificación", "Modificar festival", "Volver"};
			return modificarCorto;
		case "Modificar Largometraje":
			String[] modificarLargo= {"Modificar titulo", "Modificar director", "Modificar duracion", "Modificar clasificación", "Modificar distribuidora", "Volver"};
			return modificarLargo;
		case "Tipo de Pelicula":
			String[] tipoPelicula= {"Largometraje", "Cortometraje"};
			return tipoPelicula;
		case "Terminar Función":
			String[] terminar= {"Terminar función", "Cancelar"};
			return terminar;
		case "Modificar Cliente":
			String[] modificarCliente= {"Modificar nombre", "Modificar dni", "Modificar fecha de nacimiento", "Volver"};
			return modificarCliente;
		case "Confirmar":
			String[] confirmar= {"Sí", "No"};
			return confirmar;
	}
		return null;
	}
	
	public static String seleccionMenu(String tipo, String mensajeOpcional) {
		String[] menu=menu(tipo);
		if (mensajeOpcional.equals("")) {
			mensajeOpcional= "Seleccione una opción";
		}
		int menuNum = JOptionPane.showOptionDialog(null, mensajeOpcional, tipo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu, menu);
		while (menuNum==-1) {
			menuNum = JOptionPane.showOptionDialog(null, mensajeOpcional, tipo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu, menu);
		}
		return menu[menuNum];
	}
	
	public static String validarString(String tituloJOP) {
		String validado=JOptionPane.showInputDialog(tituloJOP);
		while (validado==null||validado.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Ingrese un valor válido");
			validado=JOptionPane.showInputDialog(tituloJOP);
		}
		return validado.trim();
	}
	
	public static int validarInt(String tituloJOP, int min, int maximo) {
		boolean valido = false;
		String paraParsear = "";
		int numero=0;
		while(!valido) {
			paraParsear = JOptionPane.showInputDialog(tituloJOP);
			if (paraParsear == null) {
				paraParsear = "";
			}
			try {
				numero=Integer.parseInt(paraParsear.trim());
				if (numero>=min && numero<=maximo) {
					valido=true;
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese un número válido");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ingrese un número válido");
			}
		}
		return numero;
	}

	public void datosTesteo(Cine cine) {
		//salas
		Sala sala1 = new Sala("Sala 1 - Tradicional", 100, 5000);
		Sala sala2 = new Sala("Sala 2 - 3D", 80, 6500);
		Sala sala3 = new Sala("Sala 3 - IMAX VIP", 50, 9000);
		cine.getListaSalas().add(sala1);
		cine.getListaSalas().add(sala2);
		cine.getListaSalas().add(sala3);
		//peliculas
		Largometraje peli1 = new Largometraje("El Viaje de Chihiro", "Hayao Miyazaki", "ATP", 125, "Toho / Studio Ghibli");
		Largometraje peli2 = new Largometraje("Batman: El Caballero de la Noche", "Christopher Nolan", "PG-13", 152, "Warner Bros");
		Cortometraje peli3 = new Cortometraje("Piper", "Alan Barillaro", "ATP", 6, "Pixar Short Films Festival");
		Cortometraje peli4 = new Cortometraje("La Casa de los Lobos", "Joaquín Cociña", "PG-17", 15, "BAFICI");
		cine.getListaPeliculas().add(peli1);
		cine.getListaPeliculas().add(peli2);
		cine.getListaPeliculas().add(peli3);
		cine.getListaPeliculas().add(peli4);
		//funciones
		Funcion funcion1 = new Funcion(LocalDate.of(2026, 8, 3), peli1, sala2);
		Funcion funcion2 = new Funcion(LocalDate.of(2025,12, 2), peli2, sala1);
		funcion2.setFuncionActiva(false);
		Funcion funcion3 = new Funcion(LocalDate.of(2026, 8, 5), peli3, sala3);
		Funcion funcion4 = new Funcion(LocalDate.of(2026, 5, 12), peli4, sala2);
		funcion4.setFuncionActiva(false);
		cine.getListaFunciones().add(funcion1);
		cine.getListaFunciones().add(funcion2);
		cine.getListaFunciones().add(funcion3);
		cine.getListaFunciones().add(funcion4);
		//clientes
		Cliente cliente1 = new Cliente("Martín Gómez", 41234567, LocalDate.of(1998, 5, 14));
		Cliente cliente2 = new Cliente("Lucía Fernández", 43890123, LocalDate.of(2002, 11, 30));
		Cliente cliente3 = new Cliente("Santiago Rodríguez", 45678901, LocalDate.of(2005, 3, 22));
		cine.getListaClientes().add(cliente1);
		cine.getListaClientes().add(cliente2);
		cine.getListaClientes().add(cliente3);
		//compras
		CompraCliente compra1 = new CompraCliente(5,funcion1);
		CompraCliente compra2 = new CompraCliente(3,funcion1);
		CompraCliente compra3 = new CompraCliente(2,funcion3);
		CompraCliente compra4 = new CompraCliente(6,funcion3);
		CompraCliente compra5 = new CompraCliente(25,funcion2);
		funcion1.setTicketsVendidos(8);
		funcion2.setTicketsVendidos(8);
		funcion2.setTicketsVendidos(28);
		cliente1.getListaCompras().add(compra1);
		cliente2.getListaCompras().add(compra3);
		cliente3.getListaCompras().add(compra2);
		cliente2.getListaCompras().add(compra4);
		cliente1.getListaCompras().add(compra5);
	}
	
}
