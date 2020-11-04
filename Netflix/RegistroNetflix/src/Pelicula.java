
public class Pelicula extends Netflix {
	private String director;
	private int añoPublicacion;
	static String tipo = "Pelicula";
	
	public Pelicula(int lID, String lnombre, String lfechaR, String lvaloracion, String ldirector,
			int lañoPublicacion) {
		super(lID, lnombre, lfechaR, lvaloracion);
		director = ldirector;
		añoPublicacion = lañoPublicacion;
	}
	//Le introducimos a la variable director el valor que introduzca el usuario
	public void setDirector(String value) {
		director = value;
	}
	public String getDirector() {
		return director;
	}
	//Asignamos a la variable añoPublicacion el valor que introduzca el usuario
	public void setAñoPublicacion(int value) {
		añoPublicacion = value;
	}
	public int getAñoPublicacion() {
		return añoPublicacion;
	}
	
	//Asignamos a la variable tipo el valor: Pelicula
	public void setTipo(String value) {
		value = "Pelicula";
		tipo = value;
	}
	public String getTipo() {
		return tipo;
	}
	
	public String toString() {
		return String.format("Contenido: %s%sDirector: %s\nAño publicacion: %s\n"
								, getTipo()
								, super.toString()
								, getDirector()
								, getAñoPublicacion());
	}
}
