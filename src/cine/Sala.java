package cine;

public class Sala {
	private String nombre;
	private int capacidad;
	private double precioBase;
	
	public Sala(String nombre, int capacidad, double precioBase) {
		this.nombre= nombre;
		this.capacidad=capacidad;
		this.precioBase=precioBase;
	}

	@Override
	public String toString() {
		return nombre + ", capacidad=" + capacidad + ", precioBase=" + precioBase + "$";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
}
