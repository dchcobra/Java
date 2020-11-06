import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		//Creacion de variables
		int ID;
		String NombreContenido;
		String Fecha;
		String valoracion = null;
		String ext1;
		int ext2;
		int ext3;
		//String valoracionyf;
		
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
		
		/* PRUEBAS SI FUNCIONABAN LOS OBJETOS
		//Debug de una Pelicula
		Pelicula p = new Pelicula(1, "Fast&Forious", "2/4/2020", "10", "Paul", 2018);
		System.out.println(p);
		//Debug de una Serie
		Serie s = new Serie(2, "Stranger Things", "1/2/2020", "5", "nombreE", 1, 2019);
		System.out.println(s);
		//Debug de un Documental
		Documental d = new Documental(3, "Dinosaurios 211.a.c", "12/9/2020", "8", "Leopoldo", 2014);
		System.out.println(d);
		*/
		// varable para iterar por la array de objetos
		int i = 0;
		// Array de objetos donde se guardan el historial de lo que ha visto el usuario
		Netflix registro[] = new Netflix[100];
		
		
		boolean salir = false;
		while (!salir) {
			mostrarMenu(); //Muestra las distintas opciones
			//recogemos el valor de la opcion
			Scanner lector = new Scanner(System.in);
			int opcion = lector.nextInt();
			Scanner lectorID = new Scanner(System.in);
			Scanner lectorNombre = new Scanner(System.in);
			Scanner lectorFecha = new Scanner(System.in);
			Scanner lectorValoracion = new Scanner(System.in);
			Scanner lectorValoracionyn = new Scanner(System.in);
			Scanner lectorExt1 = new Scanner(System.in);
			Scanner lectorExt2 = new Scanner(System.in);
			Scanner lectorExt3 = new Scanner(System.in);
			int valoracionsn;
			//Segun el numero que introduzca el usuario, hara una cosa u otra
			
			switch (opcion) {
				case 1: 
					System.out.println("Introduce el ID de la pelicula: ");
					ID = lectorID.nextInt();
					System.out.println("Introduce el nombre de la pelicula: ");
					NombreContenido = lectorNombre.nextLine();
					System.out.println("Introduce la fecha de reproduccion de la pelicula: ");
					Fecha = lectorFecha.nextLine();
					System.out.println("Quieres introducir la valoracion? 1 = si / 2 = no");
					valoracionsn = lectorValoracionyn.nextInt();
					if (valoracionsn == 1) {
						System.out.println("Introduce la valoracion: ");
						valoracion = lectorValoracion.nextLine();
					} else if (valoracionsn == 2) {
						valoracion = "Sin valoracion";
					}
					System.out.println("Introduce el director de la pelicula: ");
					ext1 = lectorExt1.nextLine();
					System.out.println("Introduce el a�o de publicacion: ");
					ext2 = lectorExt3.nextInt();
					Pelicula p = new Pelicula(ID, NombreContenido, Fecha, valoracion, ext1, ext2);
					registro[i] = p; // Guarda el objeto en la ultima posicion disponible
					i++; // Suma una posicion para siempre estar en la ultima posicion de la array
					break;
				case 2:
					System.out.println("Introduce el ID de la serie: ");
					ID = lectorID.nextInt();
					System.out.println("Introduce el nombre de la serie: ");
					NombreContenido = lectorNombre.nextLine();
					System.out.println("Introduce la fecha de reproduccion de la serie: ");
					Fecha = lectorFecha.nextLine();
					System.out.println("Quieres introducir la valoracion? 1 = si / 2 = no");
					valoracionsn = lectorValoracionyn.nextInt();
					if (valoracionsn == 1) {
						System.out.println("Introduce la valoracion: ");
						valoracion = lectorValoracion.nextLine();
					} else if (valoracionsn == 2) {
						valoracion = "Sin valoracion";
					}
					System.out.println("Introduce el nombre del estudio: ");
					ext1 = lectorExt1.nextLine();
					System.out.println("Introduce el numero de temporadas que tiene: ");
					ext2 = lectorExt2.nextInt();
					System.out.println("Introduce el a�o de publicacion de la primera temporada: ");
					ext3 = lectorExt3.nextInt();
					Serie s = new Serie(ID, NombreContenido, Fecha, valoracion, ext1, ext2, ext3);
					registro[i] = s; // Guarda el objeto en la ultima posicion disponible
					i++; // Suma una posicion para siempre estar en la ultima posicion de la array
					break;
				case 3:
					System.out.println("Introduce el ID del documental: ");
					ID = lectorID.nextInt();
					System.out.println("Introduce el nombre del documental: ");
					NombreContenido = lectorNombre.nextLine();
					System.out.println("Introduce la fecha de reproduccion del documental: ");
					Fecha = lectorFecha.nextLine();
					System.out.println("Quieres introducir la valoracion? 1 = si / 2 = no");
					valoracionsn = lectorValoracionyn.nextInt();
					if (valoracionsn == 1) {
						System.out.println("Introduce la valoracion: ");
						valoracion = lectorValoracion.nextLine();
					} else if (valoracionsn == 2) {
						valoracion = "Sin valoracion";
					}
					System.out.println("Introduce el nombre del director: ");
					ext1 = lectorExt1.nextLine();
					System.out.println("Introduce el a�o de publicacion: ");
					ext2 = lectorExt3.nextInt();
					Documental d = new Documental(ID, NombreContenido, Fecha, valoracion, ext1, ext2);
					registro[i] = d; // Guarda el objeto en la ultima posicion disponible
					i++; // Suma una posicion para siempre estar en la ultima posicion de la array
					break;
				case 4:
					//Recorre el array de objetos mostrandolos
					for (int x = 0; x < registro.length; x++) {
						if (registro[x] == null) {
							break;
						} else {
							System.out.println(registro[x]);							
						}
					}
					break;
				case 5:
					Scanner lectorVal = new Scanner(System.in);
					System.out.println("Introduce el nombre del contenido para darle una valoracion: ");
					String valoracion2 = lectorVal.nextLine();
					// Los breaks son para que salgan del bucle cuando no hayan mas registros
					for (int x = 0; x < registro.length; x++) {
						if (registro[x] != null) {
							if (valoracion2.equals(registro[x].getNombre())) {
								if (registro[x].getTipo() == "Pelicula" || registro[x].getTipo() == "Documental") {
									System.out.println("Introduce la valoracion para " + registro[x].getNombre() + ":");
									Scanner lectorNewVal = new Scanner(System.in);
									String reemplaza = lectorNewVal.nextLine();
									registro[x].setValoracion(reemplaza);
									break;
								}	else if (registro[x].getTipo() == "Serie"){
									System.out.println("1. Introducir valoracion global | 2. Introducir valoracion por temporadas");
									Scanner lector12 = new Scanner(System.in);
									opcion = lector12.nextInt();
									if (opcion == 1) {
										System.out.println("Introduce la valoracion para " + registro[x].getNombre() + ":");
										Scanner lectorNewVal = new Scanner(System.in);
										String reemplaza = lectorNewVal.nextLine();
										registro[x].setValoracion(reemplaza);
										break;										
									} else if (opcion == 2 ) {
										String valTemporada;
										//Esto hay que cambiarlo para que en vez de mostrarlo se guarde la informacion
										System.out.println("A que temporada quieres introducir valoracion?");
										for (int z = 1 ; z <= registro[x].getnumTemporadas() ; z++) {
											System.out.println("Temporada " + z + ": ");
										}
										Scanner lectorTemporadaEscogida = new Scanner(System.in);
										int TempEscogida = lectorTemporadaEscogida.nextInt();
										System.out.println("Introduce la valoracion para la temporada: ");
										Scanner lectorvalTemporada = new Scanner(System.in);
										valTemporada = lectorvalTemporada.nextLine();
										//Esto hay que cambiarlo para que en vez de mostrarlo se guarde la informacio
										for (int z = 1 ; z <= registro[x].getnumTemporadas() ; z++) {
											if (TempEscogida == z) {
												System.out.println("Temporada " + z + ": " + valTemporada);
											} else {
												System.out.println("Temporada " + z + ": ");
											}
										}
										break;
									} else {
										System.out.println("Opcion mal introducida, saliendo al menu...");
										break;
									}
								}
							} 
						} else {
							System.out.println("No existe este registro");
							break;
						}
					}
					break;
				case 6:
					//Sale del menu
					System.out.println("Saliendo...");
					salir = true;
					break;
			}
		} 
	}
	
	//muestra las opciones segun lo que quiera introducir el usuario
	public static void mostrarMenu() {
		System.out.println("\nNETFLIX HISTORIAL");
		System.out.println("****************************************");
		System.out.println("Que contenido quieres introducir?\n"
				+ "1. Guardar historial de una Pelicula\n"
				+ "2. Guardar historial de una Serie de TV\n"
				+ "3. Guardar historial de un Documental\n"
				+ "4. Mostrar historial\n"
				+ "5. Introducir valoracion\n"
				+ "6. Salir\n");
		System.out.println("****************************************\n");
	}
	
}

