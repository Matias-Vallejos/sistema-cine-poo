package cine;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Cine {
	private String nombre;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Pelicula> listaPeliculas;
	private ArrayList<Funcion> listaFunciones;
	private ArrayList<Sala> listaSalas;
	
	public Cine(String nombre) {
		this.nombre=nombre;
		this.listaClientes= new ArrayList<Cliente>();
		this.listaPeliculas= new ArrayList<Pelicula>();
		this.listaFunciones= new ArrayList<Funcion>();
		this.listaSalas= new ArrayList<Sala>();
	}
	
	public ArrayList<Sala> getListaSalas() {
		return listaSalas;
	}

	public void setListaSalas(ArrayList<Sala> listaSalas) {
		this.listaSalas = listaSalas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	public ArrayList<Funcion> getListaFunciones() {
		return listaFunciones;
	}

	public void setListaFunciones(ArrayList<Funcion> listaFunciones) {
		this.listaFunciones = listaFunciones;
	}

	public void bienvenida() {
		JOptionPane.showMessageDialog(null, "Bienvenido al sistema de gestión del cine " + getNombre());
	}
	@Override
	public String toString() {
		return "Cine [nombre=" + nombre + ", listaClientes=" + listaClientes + ", listaPeliculas=" + listaPeliculas
				+ ", listaFunciones=" + listaFunciones + "]";
	}

	public void despedida() {
		JOptionPane.showMessageDialog(null, "El cine " + getNombre() + " te desea un buen día");
	}
	public void nuevaPelicula() {
		String tipo = Utilidades.seleccionMenu("Tipo de Pelicula", "Los cortometrajes pueden tener duracion de hasta 45 minutos y tienen que haber sido presentados en algún festival\n Los largometrajes tienen que tener distribuidora");
		String titulo = Utilidades.validarString("Ingrese el título de la película");
		String director = Utilidades.validarString("Ingrese el nombre del director");
		String clasificacion = Utilidades.seleccionMenu("Clasificación de pelicula", ""); 
		if (tipo.equals("Cortometraje")) {
			int duracion = Utilidades.validarInt("Ingrese la duración de la película en minutos\n Duración máxima de un cortometraje: 45 minutos", 1, 45);
			String festival = Utilidades.validarString("Ingrese el festival donde se presento el corto");
			Cortometraje pelicula = new Cortometraje(titulo, director, clasificacion, duracion, festival);
			listaPeliculas.add(pelicula);
		} else if (tipo.equals("Largometraje")) {
			int duracion = Utilidades.validarInt("Ingrese la duración de la película en minutos\n Duración mínima de un largometraje: 45 minutos ", 45, 1440);
			String distribuidora = Utilidades.validarString("Ingrese el nombre de la distribuidora");
			Largometraje pelicula = new Largometraje(titulo, director, clasificacion, duracion, distribuidora);
			listaPeliculas.add(pelicula);
			}
		JOptionPane.showMessageDialog(null, "Se agrego una nueva pelicula");
	}
	
	public Pelicula seleccionarPelicula() {
		Pelicula a=null;
			while(a==null) {
				a=(Pelicula)JOptionPane.showInputDialog(null, "Seleccione una película", null, 
		                JOptionPane.QUESTION_MESSAGE, null, listaPeliculas.toArray(), listaPeliculas.toArray()[0]);		
				if (a==null) {
					JOptionPane.showMessageDialog(null, "Seleccione una película de la lista");
				} 
			}
		return a;
	}
	public Sala seleccionarSala() {
		Sala a=null;
			while(a==null) {
				a=(Sala)JOptionPane.showInputDialog(null, "Seleccione una sala", null, 
		                JOptionPane.QUESTION_MESSAGE, null, listaSalas.toArray(), listaSalas.toArray()[0]);		
				if (a==null) {
					JOptionPane.showMessageDialog(null, "Seleccione una Sala de la lista");
				} 
			}
		return a;
	}
	public Funcion seleccionarFuncion() {
		Funcion a=null;
			while(a==null) {
				a=(Funcion)JOptionPane.showInputDialog(null, "Seleccione una función", null, 
		                JOptionPane.QUESTION_MESSAGE, null, listaFunciones.toArray(), listaFunciones.toArray()[0]);		
				if (a==null) {
					JOptionPane.showMessageDialog(null, "Seleccione una función de la lista");
				} 
			}
		return a;
	}
	public ArrayList<Funcion> getListaFuncionActiva(){
		ArrayList<Funcion> listaFuncionesActivas=new ArrayList<>();
		for (Iterator<Funcion> iterator = listaFunciones.iterator(); iterator.hasNext();) {
			Funcion funcion = (Funcion) iterator.next();
			if (funcion.isFuncionActiva()) {
				listaFuncionesActivas.add(funcion);
			}
		}
		return listaFuncionesActivas;
	}
	public Funcion seleccionarFuncionActiva() {
		ArrayList<Funcion> listaFuncionesActivas=getListaFuncionActiva();
		Funcion a=null;
		if (listaFuncionesActivas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay funciones activas");
		}
		else {
			while(a==null) {
				a=(Funcion)JOptionPane.showInputDialog(null, "Seleccione una función", null, 
		                JOptionPane.QUESTION_MESSAGE, null, listaFuncionesActivas.toArray(), listaFuncionesActivas.toArray()[0]);		
				if (a==null) {
					JOptionPane.showMessageDialog(null, "Seleccione una función de la lista");
				} 
			}
		}
		return a;
	}
	public void nuevaFuncion() {
		Pelicula pelicula = seleccionarPelicula();
		Sala sala = seleccionarSala();
		
		boolean valido = false;
		LocalDate fecha=null;
		while(!valido) {
			String fechaString = JOptionPane.showInputDialog("Ingrese la fecha en formato AAAA-MM-DD");
			if (fechaString!=null) {
				String[] fechaArray = fechaString.split("-");
				if (fechaArray.length ==3) {
				try {
					int anio = Integer.parseInt(fechaArray[0].trim());
					int mes = Integer.parseInt(fechaArray[1].trim());
					int dia = Integer.parseInt(fechaArray[2].trim());
					try {
						fecha= LocalDate.of(anio, mes, dia);
						LocalDate hoy = LocalDate.now();
						if(fecha.isBefore(hoy)) {
							JOptionPane.showMessageDialog(null, "La función no puede estar en el pasado");
						} else {
							valido=true;
							
						for (Iterator<Funcion> iterator = getListaFuncionActiva().iterator(); iterator.hasNext();) {
							Funcion funcion = (Funcion) iterator.next();
							if(funcion.getSala().equals(sala)&&funcion.getFecha().equals(fecha)){
								valido=false;
								JOptionPane.showMessageDialog(null, "Esa sala ya tiene una función activa en esa fecha");
							}
						}}
					} catch (DateTimeException e) {
						JOptionPane.showMessageDialog(null, "Fecha inválida. Formato válido AAAA-MM-DD");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Fecha inválida. Formato válido AAAA-MM-DD");
				}
			}}
		}
		Funcion funcion = new Funcion(fecha, pelicula, sala);
		String confirmarFuncion = Utilidades.seleccionMenu("Confirmar", "Confirmación de la siguiente función: \n" + funcion.toString());
		if (confirmarFuncion.equals("Sí")) {
			listaFunciones.add(funcion);
			JOptionPane.showMessageDialog(null, "Nueva función agregada\n" + funcion.toString());
		} else {
			JOptionPane.showMessageDialog(null, "La operación fue cancelada");
		}
	}
	public void nuevoCliente() {
		String nombre = Utilidades.validarString("Ingrese el nombre");
		boolean dnirepetido=true;
		int dni = 0;
			while (dnirepetido) {
			dnirepetido=false;
			dni = Utilidades.validarInt("Ingrese el dni", 1, Integer.MAX_VALUE);
			for (Iterator<Cliente> iterator = getListaClientes().iterator(); iterator.hasNext();) {
				Cliente cliente = (Cliente) iterator.next();
				if(dni==cliente.getDni()){
					dnirepetido=true;
					JOptionPane.showMessageDialog(null, "Ya existe ese dni en el sistema");
				}
			}
		}
		boolean valido = false;
		LocalDate fechaNac=null;
		while(!valido) {
			String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento en formato AAAA-MM-DD");
			if (fechaString!=null) {
				String[] fechaArray = fechaString.split("-");
				if (fechaArray.length ==3) {
				try {
					int anio = Integer.parseInt(fechaArray[0].trim());
					int mes = Integer.parseInt(fechaArray[1].trim());
					int dia = Integer.parseInt(fechaArray[2].trim());
					try {
						fechaNac= LocalDate.of(anio, mes, dia);
						LocalDate hoy = LocalDate.now();
						Period edad = Period.between(fechaNac, hoy);
						if (edad.getYears()>=11) {
						valido = true;
						} else {
							JOptionPane.showMessageDialog(null, "Fecha inválida. Se debe tener al menos 11 años para registrarse");
						}
					} catch (DateTimeException e) {
						JOptionPane.showMessageDialog(null, "Fecha inválida. Formato válido AAAA-MM-DD");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Fecha inválida. Formato válido AAAA-MM-DD");
				}
			}}
		}
		Cliente cliente = new Cliente(nombre, dni, fechaNac);
		listaClientes.add(cliente);
		JOptionPane.showMessageDialog(null, "Se agrego un nuevo cliente");
	}
	public Cliente seleccionarCliente() {
		Cliente a=null;
			while(a==null) {
				a=(Cliente)JOptionPane.showInputDialog(null, "Seleccione un cliente", null, 
		                JOptionPane.QUESTION_MESSAGE, null, listaClientes.toArray(), listaClientes.toArray()[0]);		
				if (a==null) {
					JOptionPane.showMessageDialog(null, "Seleccione un cliente de la lista");
				} 
			}
		return a;
	}

}
