import java.util.ArrayList;

public class Serie extends Netflix{
	private String nombreEstudio;
	private int numTemporadasTotal;
	private String valoracionTemporadas[] = new String[numTemporadasTotal];
	
	private int aņoPrimeraTemporada;
	static String tipo = "Serie";
	
	public Serie(int lID, String lnombre, String lfechaR, String lValoracion, String lNombreEstudio, int lNumTemporadasTotal, int lAņoPrimeraTemporada) {
		super(lID, lnombre, lfechaR, lValoracion);
		nombreEstudio = lNombreEstudio;
		numTemporadasTotal = lNumTemporadasTotal;
		aņoPrimeraTemporada = lAņoPrimeraTemporada;
	}
	
	//Asignamos el estudio segun el usuario introduzca y Recogemos el valor estudio (setnombreEstudio)
	public void setnombreEstudio(String value) {
		nombreEstudio = value;
	}
	public String getNombreEstudio() {
		return nombreEstudio;
	}
	
	
	//Asignamos el numTemporadas segun el usuario introduzca y Recogemos el valor temporadas (setnumTemporadas)
	public int getNumTemporadas() {
		return valoracionTemporadas.length;
	}

	//Asignamos a la variable tipo el valor: Serie
	public void setTipo(String value) {
		value = "Serie";
		tipo = value;
	}
	public String getTipo() {
		return tipo;
	}
	
	//Asignamos el aņoTemporada segun el usuario introduzca y Recogemos el valor del aņo de temporada (setaņoTemporada)
	public void setAņoPrimeraTemporada(int value) {
		aņoPrimeraTemporada = value;
	}
	public int getAņoPrimeraTemporada() {
		return aņoPrimeraTemporada;
	}
	
	public void setNumTemporadasTotal(int value) {
		numTemporadasTotal = value;
	}
	
	public int getNumTemporadasTotal() {
		return numTemporadasTotal;
	}
	
	//Hacemos que muestre el contenido Serie
	public String toString() {
		return String.format("Contenido: %s%sEstudio: %s\nNumero temporadas: %s\nAņo primera temporada: %s\n"
								, getTipo()
								, super.toString()
								, getNombreEstudio()
								, getNumTemporadasTotal()
								, getAņoPrimeraTemporada());
	}
}
