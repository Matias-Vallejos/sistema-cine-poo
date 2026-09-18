package cine;


public class Cortometraje extends Pelicula {
	private String festival;
	
	public Cortometraje(String titulo,String director, String clasificacion, int duracion, String festival) {
		super(titulo, director, clasificacion, duracion);
		this.festival= festival;
	}

	@Override
	public String toString() {
		return "Cortometraje "+ super.toString() +  " \n Presentado en " + festival;
	}

	public String getFestival() {
		return festival;
	}

	public void setFestival(String festival) {
		this.festival = festival;
	}
	
	@Override
	public void modificarPelicula() {
		String menu="";
		while (!menu.equals("Volver")) {
			menu=Utilidades.seleccionMenu("Modificar Cortometraje", toString());
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
				int duracion = Utilidades.validarInt("Ingrese la duración de la película en minutos\n Duracion actual: " + getDuracion() +" minutos\n Los cortos tienen que tener una duración máxima de 45 minutos", 1, 45);
				setDuracion(duracion);
				break;
			case "Modificar clasificación":
				String clasificacion = Utilidades.seleccionMenu("Clasificación de pelicula", "Elegir nueva clasificación\n Clasificación actual: " + getClasificacion()); 
				setClasificacion(clasificacion);
				break;
			case "Modificar festival":
				String festival=Utilidades.validarString("Elegir nuevo festival\n Festival actual: " + getFestival());
				setFestival(festival);
				break;
			}
		}
	}
	@Override
	public double precioDescuento(double precio) {
		double descuento = precio*0.5;
		return descuento;
	}
}
