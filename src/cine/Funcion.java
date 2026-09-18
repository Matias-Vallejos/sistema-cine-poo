package cine;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Funcion {
	private int id;
	private static int idFuncion = 1;
	private LocalDate fecha;
	private Pelicula pelicula;
	private double precio;
	private Sala sala;
	private int ticketsVendidos;
	private boolean funcionActiva;

	public Funcion(LocalDate fecha, Pelicula pelicula, Sala sala) {
		this.fecha = fecha;
		this.pelicula = pelicula;
		this.sala = sala;
		this.precio = sala.getPrecioBase() - pelicula.precioDescuento(sala.getPrecioBase());
		this.ticketsVendidos = 0;
		this.id= idFuncion;
		idFuncion++;
		this.funcionActiva=true;
		
	}

	public boolean isFuncionActiva() {
		return funcionActiva;
	}

	public void setFuncionActiva(boolean funcionActiva) {
		this.funcionActiva = funcionActiva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketsVendidos() {
		return ticketsVendidos;
	}

	public void setTicketsVendidos(int ticketsVendidos) {
		this.ticketsVendidos = ticketsVendidos;
	}

	@Override
	public String toString() {
		return "#" + id + "- " + fecha + ", pelicula: '" + pelicula.getTitulo() + "' clasificación: " +pelicula.getClasificacion()+" \nprecio: " + precio + "$- "
				+ sala.getNombre() + "- ticketsVendidos: " + ticketsVendidos + "- funcionActiva: " + funcionActiva;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public void terminarFuncion(Cine cine) {
		String terminar = Utilidades.seleccionMenu("Terminar Función", "Terminar la siguiente función: \n" + toString());
		if (terminar.equals("Terminar función")) {
			setFuncionActiva(false);
			JOptionPane.showMessageDialog(null, "La función fue terminada con éxito");
		}
	}
	public int ticketsDisponibles() {
		int ticketsDisponibles = sala.getCapacidad() - getTicketsVendidos();
		return ticketsDisponibles;
	}
	public int edadMinima() {
		switch(getPelicula().getClasificacion()) {
		case "ATP": return 0;
		case "PG-13": return 13;
		case "PG-17": return 17;
		}
		return 0;
	}
	
}
