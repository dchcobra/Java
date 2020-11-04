import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		//Creacion de variables
		int ID;
		String NombreContenido;
		String Fecha;
		
		/* Existen estos tipos
		contenido = "Pelicula";
		contenido = "Serie de TV"
		contenido = "Documental"
		*/
		/* prueba para ver si funcionaba
		contenido = "Pelicula";
		Netflix t = new Netflix(2, "Stranger Things", "1/2/2020");
		System.out.println(t);
		contenido = "Serie de TV";
		Netflix f = new Netflix(3, "Lost in space", "4/10/2019");
		System.out.println(f);
		*/
		
		/*
		boolean salir = false;
		while (!salir) {
			mostrarMenu(); //Muestra las distintas opciones
			//recogemos el valor de la opcion
			Scanner lector = new Scanner(System.in);
			int opcion = lector.nextInt();
			//Segun el numero que introduzca el usuario, hara una cosa u otra
			switch (opcion) {
				case 1: 
					System.out.println("1");
					break;
				case 2:
					System.out.println("2");
					break;
				case 3:
					System.out.println("3");
					break;
				case 4:
					System.out.println("Saliendo...");
					salir = true;
					break;
			}
		} 
		*/ 
		
		//Debug de una Pelicula
		Pelicula p = new Pelicula(1, "Fast&Forious", "2/4/2020", "10", "Paul", 2018);
		System.out.println(p);
		//Debug de una Serie
		Serie s = new Serie(2, "Stranger Things", "1/2/2020", "5", "nombreE", 1, 2019);
		System.out.println(s);
		//Debug de un Documental
		Documental d = new Documental(3, "Dinosaurios 211.a.c", "12/9/2020", "8", "Leopoldo", 2014);
		System.out.println(d);
		
	}
	
	//muestra las opciones segun lo que quiera introducir el usuario
	public static void mostrarMenu() {
		System.out.println("NETFLIX HISTORIAL");
		System.out.println("****************************************");
		System.out.println("Que contenido quieres indtroducir?\n"
				+ "1. Guardar historial de una Pelicula\n"
				+ "2. Guardar historial de una Serie de TV\n"
				+ "3. Guardar historial de un Documental\n"
				+ "4. Salir\n");
		System.out.println("****************************************\n");
	}
	
}

