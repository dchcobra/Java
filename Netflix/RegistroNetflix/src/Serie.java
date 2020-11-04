
public class Serie extends Netflix{
	private String nombreEstudio;
	private int numTemporadas;
	private int añoTemporada;
	static String tipo = "Serie";
	
	public Serie(int lID, String lnombre, String lfechaR, String lnombreEstudio,
			int lnumTemporadas, int lañoTemporada) {
		super(lID, lnombre, lfechaR);
		nombreEstudio = lnombreEstudio;
		numTemporadas = lnumTemporadas;
		añoTemporada = lañoTemporada;
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
	
	//Asignamos el añoTemporada segun el usuario introduzca y Recogemos el valor del año de temporada (setañoTemporada)
	public void setañoTemporada(int value) {
		añoTemporada = value;
	}
	public int getañoTemporada() {
		return añoTemporada;
	}
	
	public void setTipo(String value) {
		value = "Serie";
		tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	
	public String toString() {
		return String.format("Contenido: %s%sEstudio: %s\nNumero temporadas: %s\nAño primera temporada: %s"
								, getTipo()
								, super.toString()
								, getnombreEstudio()
								, getnumTemporadas()
								, getañoTemporada());
	}

}
