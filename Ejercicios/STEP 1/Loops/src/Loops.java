import java.util.Scanner;

public class Loops {
	
	public static void main(String[] args) {
// Corredor == raceRunner
		Runner Corredor;
// Nadador == raceSwimmer
		Swimmer Nadador;
// opcionMenu == menuChoice
		boolean menuFuncionamiento = true;
		
		while (menuFuncionamiento) {
			int opcionMenu = printMenu();
			switch (opcionMenu) {
				case 1:
					System.out.println("Has escogido crear un nuevo corredor");
					Corredor = getNuevoCorredor();
					System.out.println("Has creado el corredor: " + Corredor.toString());
					break;
				case 2:
					System.out.println("Has escogido crear un nuevo nadador");
					Nadador = getNuevoNadador();
					System.out.println("Has creado el nadador: " + Nadador.toString());
					break;
				case 3:
					System.out.println("Gracias por usar la herramienta DCHCOBRA");
					menuFuncionamiento = false;
					break;
				default:
					break;
			}
		}
		System.out.println("Primer bucle completado");
		// Hara el bloque de codigo mientras menuFuncionamiento es True
		do {
			int opcionMenu = printMenu();
			switch (opcionMenu) {
				case 1:
					System.out.println("Has escogido crear un nuevo corredor");
					Corredor = getNuevoCorredor();
					System.out.println("Has creado el corredor: " + Corredor.toString());
					menuFuncionamiento = true;
					break;
				case 2:
					System.out.println("Has escogido crear un nuevo nadador");
					Nadador = getNuevoNadador();
					System.out.println("Has creado el nadador: " + Nadador.toString());
					menuFuncionamiento = true;
					break;
				case 3:
					System.out.println("Gracias por usar la herramienta DCHCOBRA");
					menuFuncionamiento = false;
					break;
				default:
					break;
			}
		} while (menuFuncionamiento);
		
		System.out.println("Segundo bucle hecho");
		// Defines las vueltas que vas a hacer (4 vueltas en este ejemplo)
		for (int i = 0; i < 4; i++) {
			int opcionMenu = printMenu();
			switch (opcionMenu) {
				case 1:
					System.out.println("Has escogido crear un nuevo corredor");
					Corredor = getNuevoCorredor();
					System.out.println("Has creado el corredor: " + Corredor.toString());
					menuFuncionamiento = true;
					break;
				case 2:
					System.out.println("Has escogido crear un nuevo nadador");
					Nadador = getNuevoNadador();
					System.out.println("Has creado el nadador: " + Nadador.toString());
					menuFuncionamiento = true;
					break;
				case 3:
					System.out.println("Gracias por usar la herramienta DCHCOBRA");
					menuFuncionamiento = false;
					break;
				default:
					break;
			}
		}
		System.out.println("Tercer bucle hecho");
	}
		
		public static int printMenu() {
			Scanner input = new Scanner(System.in);
			System.out.println("**************************************");
			System.out.println("*********Bienvenido a DCHCOBRA********");
			System.out.println("**************************************");
			System.out.println("Que es lo que quieres hacer hoy?******");
			System.out.println("Introduce 1 para añadir corredor******");
			System.out.println("Introduce 2 para añadir nadador*******");
			System.out.println("Introduce 3 para salir****************");
			System.out.println("--------------------------------------");
			System.out.println("**************************************");

			int resultado = Integer.parseInt(input.nextLine());
			return resultado;
		}
		
		public static Swimmer getNuevoNadador() {
			Scanner input = new Scanner(System.in);
			Swimmer r = new Swimmer();
			System.out.println("Introduce el nombre del nadador");
			r.setName(input.nextLine());
			System.out.println("Introduce el ID del nadador");
			r.setID(Integer.parseInt(input.nextLine()));
			return r;
		}
		
		public static Runner getNuevoCorredor() {
			Scanner input = new Scanner(System.in);
			Runner r = new Runner();
			System.out.println("Introduce el nombre del corredor");
			r.setName(input.nextLine());
			System.out.println("Introduce el ID del corredor");
			r.setID(Integer.parseInt(input.nextLine()));
			return r;
	}
}
