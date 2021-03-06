
public class Pelicula extends Netflix {
	private String director;
	private int aņoPublicacion;
	static String tipo = "Pelicula";
	
	public Pelicula(int lID, String lnombre, String lfechaR, String lvaloracion, String ldirector,
			int laņoPublicacion) {
		super(lID, lnombre, lfechaR, lvaloracion);
		director = ldirector;
		aņoPublicacion = laņoPublicacion;
	}
	//Le introducimos a la variable director el valor que introduzca el usuario
	public void setDirector(String value) {
		director = value;
	}
	public String getDirector() {
		return director;
	}
	//Asignamos a la variable aņoPublicacion el valor que introduzca el usuario
	public void setAņoPublicacion(int value) {
		aņoPublicacion = value;
	}
	public int getAņoPublicacion() {
		return aņoPublicacion;
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
		return String.format("Contenido: %s%sDirector: %s\nAņo publicacion: %s\n"
								, getTipo()
								, super.toString()
								, getDirector()
								, getAņoPublicacion());
	}

}
