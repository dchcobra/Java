public class Temporada {
	private static String Temp = "Temporada";
	private int numTemporada;
	private int valoracionTemp;
	
	public Temporada(int lNumTemporada, int lValoracionTemp) {
		numTemporada = lNumTemporada;
		valoracionTemp = lValoracionTemp;
	}
		
	public void setValoracionTemp(int value) {
		valoracionTemp = value;
	}
	
	public int getValoracionTemp() {
		return valoracionTemp;
	}
	
	public String getTemp() {
		return Temp;
	}
	
	public void setNumTemporada(int value) {
		numTemporada = value;
	}
	
	public int getNumTemporada() {
		return numTemporada;
	}
	
	public String toString() {
		return String.format("%s: %s (%s)"
				, getTemp()
				, getNumTemporada()
				, getValoracionTemp());
	}

}
