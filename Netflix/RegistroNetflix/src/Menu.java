
public class Menu {
	public static void main(String[] args) {
		//Creacion de variables
		String contenido;
		int ID;
		String NombreContenido;
		String Fecha;
		
		/* Existen estos tipos
		contenido = "Pelicula";
		contenido = "Serie de TV"
		contenido = "Documental"
		*/
		
		contenido = "Pelicula";
		Netflix t = new Netflix(contenido, 2, "Stranger Things", "1/2/2020");
		System.out.println(t);
		contenido = "Serie de TV";
		Netflix f = new Netflix(contenido, 3, "Lost in space", "4/10/2019");
		System.out.println(f);
	}
}
