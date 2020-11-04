
public class Serie extends Netflix{
	private String nombreEstudio;
	private int numTemporadas;
	private int a�oTemporada;
	static String tipo = "Serie";
	
	public Serie(int lID, String lnombre, String lfechaR, String lnombreEstudio,
			int lnumTemporadas, int la�oTemporada) {
		super(lID, lnombre, lfechaR);
		nombreEstudio = lnombreEstudio;
		numTemporadas = lnumTemporadas;
		a�oTemporada = la�oTemporada;
	}
	
	//Asignamos el estudio segun el usuario introduzca y Recogemos el valor estudio (setnombreEstudio)
	public void setnombreEstudio(String value) {
		nombreEstudio = value;
	}
	public String getnombreEstudio() {
		return nombreEstudio;
	}
	
	//Asignamos el numTemporadas segun el usuario introduzca y Recogemos el valor temporadas (setnumTemporadas)
	public void setnumTemporadas(int value) {
		numTemporadas = value;
	}
	public int getnumTemporadas() {
		return numTemporadas;
	}
	
	//Asignamos el a�oTemporada segun el usuario introduzca y Recogemos el valor del a�o de temporada (seta�oTemporada)
	public void seta�oTemporada(int value) {
		a�oTemporada = value;
	}
	public int geta�oTemporada() {
		return a�oTemporada;
	}
	
	public void setTipo(String value) {
		value = "Serie";
		tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	
	public String toString() {
		return String.format("Contenido: %s%sEstudio: %s\nNumero temporadas: %s\nA�o primera temporada: %s"
								, getTipo()
								, super.toString()
								, getnombreEstudio()
								, getnumTemporadas()
								, geta�oTemporada());
	}

}
