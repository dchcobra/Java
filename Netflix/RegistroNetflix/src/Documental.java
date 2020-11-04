
public class Documental extends Netflix {	
	private String director;
	private int añoPublicacion;
	static String tipo = "Documental";
	public Documental(int lID, String lnombre, String lfechaR, String lvaloracion, String ldirector, int lañoPublicacion) {
		super(lID, lnombre, lfechaR, lvaloracion);
		director = ldirector;
		añoPublicacion = lañoPublicacion;
	}
	//Le ponemos el valor que pase el usuario a director
	public void setDirector(String value) {
		director = value;
	}
	public String getDirector () {
		return director;
	}
	
	//Le ponemos el valor que pase el usuario a añoPublicacion
	public void setAñoPublicacion(int value) {
		añoPublicacion = value;
	}
	public int getAñoPublicacion() {
		return añoPublicacion;
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
		return String.format("Contenido: %s%sDirector: %s\nAño publicacion: %s"
							, getTipo()
							, super.toString()
							, getDirector()
							, getAñoPublicacion());
	}
}
