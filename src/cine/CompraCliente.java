package cine;

public class CompraCliente {
	private Funcion funcion;
	private int cantidadTickets;
	private double precioTotal;
	private int id;
	private static int idCompra = 1;
	
	public CompraCliente(int cantidadTickets, Funcion funcion) {
		this.funcion=funcion;
		this.cantidadTickets=cantidadTickets;
		this.precioTotal= funcion.getPrecio()*cantidadTickets;
		this.id=idCompra;
		idCompra++;
	}

	@Override
	public String toString() {
		return "#" +id + " Tickets=" + cantidadTickets + ", Precio Total=$"
				+ precioTotal + "\n funcion: " +funcion.toString();
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public int getCantidadTickets() {
		return cantidadTickets;
	}

	public void setCantidadTickets(int cantidadTickets) {
		this.cantidadTickets = cantidadTickets;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
