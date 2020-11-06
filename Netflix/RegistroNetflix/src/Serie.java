
public class Serie extends Netflix{
	private String nombreEstudio;
	private int numTemporadas;
	private int aņoTemporada;
	static String tipo = "Serie";
	
	public Serie(int lID, String lnombre, String lfechaR, String lvaloracion, String lnombreEstudio,
			int lnumTemporadas, int laņoTemporada) {
		super(lID, lnombre, lfechaR, lvaloracion);
		nombreEstudio = lnombreEstudio;
		numTemporadas = lnumTemporadas;
		aņoTemporada = laņoTemporada;
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
	
	//Asignamos el aņoTemporada segun el usuario introduzca y Recogemos el valor del aņo de temporada (setaņoTemporada)
	public void setaņoTemporada(int value) {
		aņoTemporada = value;
	}
	public int getaņoTemporada() {
		return aņoTemporada;
	}
	//Asignamos a la variable tipo el valor: Serie
	public void setTipo(String value) {
		value = "Serie";
		tipo = value;
	}
	public String getTipo() {
		return tipo;
	}
	
	public static String[] getTemporadas() {
		String[] temporadas = null;
		return temporadas;
	}
	
	//Hacemos que muestre el contenido Serie
	public String toString() {
		return String.format("Contenido: %s%sEstudio: %s\nNumero temporadas: %s\nAņo primera temporada: %s\n"
								, getTipo()
								, super.toString()
								, getnombreEstudio()
								, getnumTemporadas()
								, getaņoTemporada());
	}
}
