package cine;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Utilidades util = new Utilidades();
		Cine cine= new Cine("Java");
		util.datosTesteo(cine);
		
		
		cine.bienvenida();
		
		String menu=""; 
		do {
			menu=Utilidades.seleccionMenu("Menu principal", "");
			switch(menu){
				case "Gestión de Películas":
					while(!menu.equals("Volver")) {
						switch(menu=Utilidades.seleccionMenu("Gestión de Películas", "")) {
							case "Nueva Pelicula":
								cine.nuevaPelicula();
								break;
							case "Ver datos":
								JOptionPane.showMessageDialog(null, cine.seleccionarPelicula().toString());
								break;
							case "Modificar película":
								cine.seleccionarPelicula().modificarPelicula();
								break;
						}
					}
					break;
				case "Gestión de Clientes":
					while(!menu.equals("Volver")) {
						switch(menu=Utilidades.seleccionMenu("Gestión de Clientes", "")) {
							case "Nuevo Cliente":
								cine.nuevoCliente();
								break;
							case "Modificar datos":
								cine.seleccionarCliente().modificarCliente(cine);
								break;
							case "Ver datos de clientes":
								JOptionPane.showMessageDialog(null, cine.seleccionarCliente().toString());
								break;
							case "Realizar compra":
								cine.seleccionarCliente().nuevaCompra(cine);
								break;
							case "Ver historial":
								CompraCliente compra = cine.seleccionarCliente().seleccionarCompra();
								if (compra!=null) {
								JOptionPane.showMessageDialog(null, compra.toString());
								}
								break;
						}
					}
					break;
				case "Gestión de Funciones":
					while(!menu.equals("Volver")) {
						switch(menu=Utilidades.seleccionMenu("Gestión de Funciones", "")) {
							case "Nueva función":
								cine.nuevaFuncion();
								break;
							case "Ver funciones activas":
								Funcion funcionActiva = cine.seleccionarFuncionActiva();
								if (funcionActiva!=null) {
								JOptionPane.showMessageDialog(null, funcionActiva.toString());
								}
								break;
							case "Terminar función activa":
								Funcion funcionTerminar = cine.seleccionarFuncionActiva();
								if (funcionTerminar!=null) {
									funcionTerminar.terminarFuncion(cine);
									}
								
								break;
							case "Historial de funciones":
								JOptionPane.showMessageDialog(null, cine.seleccionarFuncion().toString());
								break;
						}
					}
					break;			
			}
		} while (!menu.equals("Salir"));
			
		cine.despedida();
	}
}
