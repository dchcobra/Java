import java.util.*;

public class Netflix {
	private String nombre;
	private String fechaR;
	private String valoracion;
	private String tipo = getTipo();
	private int temporadas = getNumTemporadasTotal();
	private int ID;
	private ArrayList<String> valoracionTemporadas = new ArrayList<String>();
	
	//Constructor que no hace nada
	public Netflix() {	
	}


	//Constructor que hace que el objeto siempre tenga ID, nombre y fecha
	public Netflix(int lID, String lnombre, String lfechaR, String lvaloracion) {
		ID = lID;
		nombre = lnombre;
		fechaR = lfechaR;
		valoracion = lvaloracion;
	}
	//Asignamos el ID segun el usuario introduzca
	public void setID(int value) {
		ID = value;
	}
	//Recogemos el valor de ID (setID)
	public int getID() {
		return ID;
	}
	//Asignamos el nombre segun el usuario introduzca
	public void setNombre(String value) {
		nombre = value;
	}
	//Recogemos el valor nombre (setnombre)
	public String getNombre() {
		return nombre;
	}
	//Asignamos el dia segun el usuario introduzca
	public void setDiaReproduccion(String value) {
		fechaR = value;
	}
	//Recogemos el valor dia (setsetDiaReproduccion)
	public String getDiaReproduccion() {
		return fechaR;
	}
	
	public void setValoracion(String value) {
		valoracion = value;
	}
	
	public String getValoracion() {
		return valoracion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int getNumTemporadasTotal() {
		return temporadas;
	}
	public void setValoracionTemporadas(String t, int i) {
			int x = i - 1;
			if (valoracionTemporadas.size() == 0 || valoracionTemporadas.size() <= x) {
				if (valoracionTemporadas.size() == x) {
					valoracionTemporadas.add(0, t);
				} else {
					valoracionTemporadas.add(t);					
				}
			} else if (!(valoracionTemporadas.get(x).substring(11, 13).equals(t.toString().substring(11,13)))) {
				valoracionTemporadas.add(x, t);
			} else if (valoracionTemporadas.get(x).substring(11, 13).equals(t.toString().substring(11,13))) {
				valoracionTemporadas.add(x, t);
				valoracionTemporadas.remove(i);
			}
		}

	public ArrayList<String> getValoracionTemporadas() {
		return valoracionTemporadas;
	} 
	
	public String toString() {
		if (valoracionTemporadas.size() == 0) {
			return String.format("\nID: %s.\nHa visto: %s\nLa vió el dia: %s\nValoracion: %s\n"
					, getID()
					, getNombre()
					, getDiaReproduccion()
					, getValoracion());
		} else {
			return String.format("\nID: %s.\nHa visto: %s\nLa vió el dia: %s\nValoracion: %s\n%s\n"
					, getID()
					, getNombre()
					, getDiaReproduccion()
					, getValoracion()
					, getValoracionTemporadas());			
		}
	}

}
