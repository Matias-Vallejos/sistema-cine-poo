package cine;

public class Largometraje extends Pelicula{
	private String distribuidora;
	
	public Largometraje(String titulo,String director, String clasificacion, int duracion, String distribuidora) {
		super(titulo, director, clasificacion, duracion);
		this.distribuidora= distribuidora;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	@Override
	public String toString() {
		return "Largometraje "+ super.toString() +  " \n Distribuido por  " + distribuidora;
	}
	
	@Override
	public void modificarPelicula() {
		String menu="";
		while (!menu.equals("Volver")) {
			menu=Utilidades.seleccionMenu("Modificar Largometraje", toString());
			switch(menu) {
			case "Modificar titulo":
				String titulo=Utilidades.validarString("Elegir nuevo título\n Título actual: " + getTitulo());
				setTitulo(titulo);
				break;
			case "Modificar director":
				String director=Utilidades.validarString("Elegir nuevo director\n Director actual: " + getDirector());
				setDirector(director);
				break;
			case "Modificar duracion":
				int duracion = Utilidades.validarInt("Ingrese la duración de la película en minutos\n Duracion actual: " + getDuracion() +" minutos\nLos largometrajes tienen que tener una duración mínima de 45 minutos", 45, 1440);
				setDuracion(duracion);
				break;
			case "Modificar clasificación":
				String clasificacion = Utilidades.seleccionMenu("Clasificación de pelicula", "Elegir nueva clasificación\n Clasificación actual: " + getClasificacion()); 
				setClasificacion(clasificacion);
				break;
			case "Modificar distribuidora":
				String distribuidora=Utilidades.validarString("Elegir nueva distribuidora\n Distribuidora actual: " + getDistribuidora());
				setDistribuidora(distribuidora);
				break;
			}
		}
	}
	@Override
	public double precioDescuento(double precio) {
		double descuento = 0;
		if (getDuracion()<120) {
			descuento = 1000;
		}
		return descuento;
	}
}
