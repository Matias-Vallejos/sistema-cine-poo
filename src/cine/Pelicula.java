package cine;

public abstract class Pelicula {
	private int id;
	private String titulo;
	private String director;
	private int duracion;
	private String clasificacion;
	private static int idPelicula = 1;
	
	public Pelicula(String titulo,String director, String clasificacion, int duracion) {
		this.id = idPelicula;
		idPelicula++;
		this.titulo = titulo;
		this.director= director;
		this.clasificacion= clasificacion;
		this.duracion= duracion;
	}

	@Override
	public String toString() {
		return "#" + id + "-> '" + titulo + "', dirigida por: " + director + "\n duracion:" + duracion
				+ " minutos, clasificacion " + clasificacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	public abstract void modificarPelicula();
	
	public abstract double precioDescuento(double precio);
	
}
