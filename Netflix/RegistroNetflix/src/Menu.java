import java.util.Scanner;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		String[] temporadas = new String[100];

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
		
		// PRUEBAS SI FUNCIONABAN LOS OBJETOS
		//Debug de una Pelicula
		Pelicula p2 = new Pelicula(1, "Fast&Forious", "2/4/2020", "10", "Paul", 2005);
		//System.out.println(p);
		//Debug de una Serie
		Serie s2 = new Serie(2, "Stranger Things", "1/2/2020", "5", "nombreE", 3, 2018);
		//System.out.println(s2);
		//Debug de un Documental
		Documental d2 = new Documental(3, "Dinosaurios 211.a.c", "12/9/2020", "8", "Leopoldo", 2014);
		//System.out.println(d);
		
		// varable para iterar por la array de objetos
		int i = 0;
		// Array de objetos donde se guardan el historial de lo que ha visto el usuario
		Netflix registro[] = new Netflix[100];
		registro[0] = p2;
		registro[1] = s2;
		registro[2] = d2;
		
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
					System.out.println("Introduce el año de publicacion: ");
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
					System.out.println("Introduce el año de publicacion de la primera temporada: ");
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
					System.out.println("Introduce el año de publicacion: ");
					ext2 = lectorExt3.nextInt();
					Documental d = new Documental(ID, NombreContenido, Fecha, valoracion, ext1, ext2);
					registro[i] = d; // Guarda el objeto en la ultima posicion disponible
					i++; // Suma una posicion para siempre estar en la ultima posicion de la array
					break;
				case 4:
					//Recorre el array de objetos mostrandolos
					List<Netflix> register = Arrays.asList(registro);
					//lambda
					//register.stream().filter(one -> one != null).forEach((one) -> System.out.println(one));
					//method reference
					register.stream().filter(one -> one != null).forEach(System.out::print);
					//normal method
					/*for (int x = 0; x < registro.length; x++) {
						if (registro[x] == null) {
							break;
						} else {
							System.out.println(registro[x]);					
						}
					}
					*/
					break;
				case 5:
					String valoracion2 = scannerNameContentReplace();
					List<Netflix> registerInputVal = Arrays.asList(registro);
					//cambia la valoracion de las peliculas y de los documentales
					registerInputVal.stream().filter(one -> one != null && one.getNombre().equals(valoracion2) && (one.getTipo() == "Pelicula" || one.getTipo() == "Documental"))
					.forEach((one) -> one.setValoracion(scannerValReplace()));
					
					// cambia la valoracion a las series global o por temporadas
					registerInputVal.stream().filter(one -> one != null && one.getNombre().equals(valoracion2) && (one.getTipo() == "Serie"))
					.forEach((one) -> one.setValoracion(inputGlobalOrTemp(one)));
					
					/*for (int x = 0; x < registro.length; x++) {
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
										int valTemporada;
										System.out.println("A que temporada quieres introducir valoracion?");
										for (int z = 1 ; z <= registro[x].getNumTemporadasTotal() ; z++) {
											System.out.println("Temporada " + z + ": [" + z +"]");
										}
										Scanner lectorTemporadaEscogida = new Scanner(System.in);
										int TempEscogida = lectorTemporadaEscogida.nextInt();
										if (TempEscogida > registro[x].getNumTemporadasTotal()) {
											System.out.println("Esta serie no tiene tantas temporadas, saliendo al menu");
											break;
										}
										System.out.println("Introduce la valoracion para la temporada: ");
										Scanner lectorvalTemporada = new Scanner(System.in);
										valTemporada = lectorvalTemporada.nextInt();
										for (int z = 1 ; z <= registro[x].getNumTemporadasTotal() ; z++) {
											if (TempEscogida == z) {
												Temporada t = new Temporada(TempEscogida, valTemporada);
												registro[x].setValoracionTemporadas(t.toString(), TempEscogida);
											}
										}
										break;
									} else {
										System.out.println("Opcion mal introducida");
										break;
									}
								}
							}
						} else {
							System.out.println("No existe este registro");
							break;
						}
					}
					*/
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
	
	public static String scannerNameContentReplace() {
		System.out.println("Introduce el nombre del contenido para darle una valoracion: ");
		Scanner lectorVal = new Scanner(System.in);
		String Name = lectorVal.nextLine();
		return Name;
	}
	
	public static String scannerValReplace() {
		System.out.println("Introduce la valoracion para el registro:");
		Scanner lectorNewVal = new Scanner(System.in);
		String reemplaza = lectorNewVal.nextLine();
		return reemplaza;
	}
	
	public static String scannerTempReplace(Netflix one) {
		int valTemporada;
		System.out.println("A que temporada quieres introducir valoracion?");
		for (int z = 1 ; z <= ((Serie) one).getNumTemporadasTotal() ; z++) {
			System.out.println("Temporada " + z + ": [" + z +"]");
		}
		Scanner lectorTemporadaEscogida = new Scanner(System.in);
		int TempEscogida = lectorTemporadaEscogida.nextInt();
		if (TempEscogida > ((Serie) one).getNumTemporadasTotal()) {
			System.out.println("Esta serie no tiene tantas temporadas, saliendo al menu");
		}
		System.out.println("Introduce la valoracion para la temporada: ");
		Scanner lectorvalTemporada = new Scanner(System.in);
		valTemporada = lectorvalTemporada.nextInt();
		for (int z = 1 ; z <= ((Serie) one).getNumTemporadasTotal() ; z++) {
			if (TempEscogida == z) {
				Temporada t = new Temporada(TempEscogida, valTemporada);
				((Serie) one).setValoracionTemporadas(t.toString(), TempEscogida);
			}
		}
		return null;
	}
	
	public static String doestExist() {
		String DoesExist = "No existe este registro";
		return DoesExist;
	}
	
	public static String inputGlobalOrTemp(Netflix one) {
		System.out.println("Como quieres que sea la valoracion (1. Introducir valoracion global | 2. Introducir valoracion por temporadas)");
		Scanner lector12 = new Scanner(System.in);
		int opcion = lector12.nextInt();
		if (opcion == 1) {
			return scannerValReplace();
		} else if (opcion == 2) {
			return scannerTempReplace(one);
		} else {
			return doestExist();
		}
	}
}

