
public class Netflix {
	private String nombre;
	private String fechaR;
	private int valoracion;
	private int ID;
	private String tipo;
	
	//Constructor que no hace nada
	public Netflix() {	
	}

	//Constructor que hace que el objeto siempre tenga ID, nombre y fecha
	public Netflix(String ltipo, int lID, String lnombre, String lfechaR) {
		ID = lID;
		nombre = lnombre;
		fechaR = lfechaR;
		tipo = ltipo;
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
	//asignamos el valor a tipo
	public void setTipo(String value) {
		tipo = value;
	}
	//Recogemos el valor de settipo()
	public String getTipo() {
		return tipo;
	}
	
	/* Comentado de momento
	public void setValoracion(int value) {
		valoracion = value;
	}
	
	public int getValoracion() {
		return valoracion;
	}*/
	
	public String toString() {
		
		return String.format("%s\nID de la serie: %s.\nHa visto la serie: %s\nLa comenzo el dia: %s"
				, getTipo()
				, getID()
				, getNombre()
				, getDiaReproduccion());
	}
}
