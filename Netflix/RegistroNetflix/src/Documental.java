
public class Documental extends Netflix {	
	private String director;
	private int a�oPublicacion;
	static String tipo = "Documental";
	public Documental(int lID, String lnombre, String lfechaR, String lvaloracion, String ldirector, int la�oPublicacion) {
		super(lID, lnombre, lfechaR, lvaloracion);
		director = ldirector;
		a�oPublicacion = la�oPublicacion;
	}
	//Le ponemos el valor que pase el usuario a director
	public void setDirector(String value) {
		director = value;
	}
	public String getDirector () {
		return director;
	}
	
	//Le ponemos el valor que pase el usuario a a�oPublicacion
	public void setA�oPublicacion(int value) {
		a�oPublicacion = value;
	}
	public int getA�oPublicacion() {
		return a�oPublicacion;
	}
	
	//Asignamos a la variable tipo el valor: Documental
	public void setTipo(String value) {
		value = "Documental";
		tipo = value;
	}
	public String getTipo() {
		return tipo;
	}
	
	public String toString() {
		return String.format("Contenido: %s%sDirector: %s\nA�o publicacion: %s"
							, getTipo()
							, super.toString()
							, getDirector()
							, getA�oPublicacion());
	}
}
