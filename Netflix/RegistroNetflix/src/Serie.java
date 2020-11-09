public class Serie extends Netflix{
	private String nombreEstudio;
	private int numTemporadasTotal;
	private String valoracionTemporadas[] = new String[numTemporadasTotal];
	
	private int a�oPrimeraTemporada;
	static String tipo = "Serie";
	
	public Serie(int lID, String lnombre, String lfechaR, String lValoracion, String lNombreEstudio, int lNumTemporadasTotal, int lA�oPrimeraTemporada) {
		super(lID, lnombre, lfechaR, lValoracion);
		nombreEstudio = lNombreEstudio;
		numTemporadasTotal = lNumTemporadasTotal;
		a�oPrimeraTemporada = lA�oPrimeraTemporada;
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
	
	public void setValoracionTemporadas() {
		valoracionTemporadas[0] = "hola";

	}
	
	//Asignamos el a�oTemporada segun el usuario introduzca y Recogemos el valor del a�o de temporada (seta�oTemporada)
	public void setA�oPrimeraTemporada(int value) {
		a�oPrimeraTemporada = value;
	}
	public int getA�oPrimeraTemporada() {
		return a�oPrimeraTemporada;
	}
	
	public void setNumTemporadasTotal(int value) {
		numTemporadasTotal = value;
	}
	
	public int getNumTemporadasTotal() {
		return numTemporadasTotal;
	}
	
	//Hacemos que muestre el contenido Serie
	public String toString() {
		return String.format("Contenido: %s%sEstudio: %s\nNumero temporadas: %s\nA�o primera temporada: %s\n%s\n"
								, getTipo()
								, super.toString()
								, getNombreEstudio()
								, getNumTemporadasTotal()
								, getA�oPrimeraTemporada());
	}
}
