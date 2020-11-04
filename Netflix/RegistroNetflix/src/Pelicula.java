
public class Pelicula extends Netflix {
	private String director;
	private int a�oPublicacion;
	static String tipo = "Pelicula";
	
	public Pelicula(int lID, String lnombre, String lfechaR, String lvaloracion, String ldirector,
			int la�oPublicacion) {
		super(lID, lnombre, lfechaR, lvaloracion);
		director = ldirector;
		a�oPublicacion = la�oPublicacion;
	}
	//Le introducimos a la variable director el valor que introduzca el usuario
	public void setDirector(String value) {
		director = value;
	}
	public String getDirector() {
		return director;
	}
	//Asignamos a la variable a�oPublicacion el valor que introduzca el usuario
	public void setA�oPublicacion(int value) {
		a�oPublicacion = value;
	}
	public int getA�oPublicacion() {
		return a�oPublicacion;
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
		return String.format("Contenido: %s%sDirector: %s\nA�o publicacion: %s\n"
								, getTipo()
								, super.toString()
								, getDirector()
								, getA�oPublicacion());
	}
}
