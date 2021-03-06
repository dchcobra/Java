
public class Documental extends Netflix {	
	private String director;
	private int aņoPublicacion;
	static String tipo = "Documental";
	public Documental(int lID, String lnombre, String lfechaR, String lvaloracion, String ldirector, int laņoPublicacion) {
		super(lID, lnombre, lfechaR, lvaloracion);
		director = ldirector;
		aņoPublicacion = laņoPublicacion;
	}
	//Le ponemos el valor que pase el usuario a director
	public void setDirector(String value) {
		director = value;
	}
	public String getDirector () {
		return director;
	}
	
	//Le ponemos el valor que pase el usuario a aņoPublicacion
	public void setAņoPublicacion(int value) {
		aņoPublicacion = value;
	}
	public int getAņoPublicacion() {
		return aņoPublicacion;
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
		return String.format("Contenido: %s%sDirector: %s\nAņo publicacion: %s"
							, getTipo()
							, super.toString()
							, getDirector()
							, getAņoPublicacion());
	}
}
