import java.util.Scanner;

public class SwitchTemaryOperators {
	
	public static void main(String[] args) {
		
		Runner r = new Runner();
		r.setID(8);
		r.setName("David");
		
		Swimmer s = new Swimmer();
		s.setID(10);
		
		Swimmer s2 = new Swimmer(3, "Raul");
		
		System.out.println(r);
		System.out.println(s);
		System.out.println(s2);

		System.out.println("X equals Y?" + Utilities.nullSafeEquals("X", "Y"));
		
		System.out.println("rName = sName?" + Utilities.nullSafeEquals(r.getName(), s.getName()));
		System.out.println("rName = s2Name?" + Utilities.nullSafeEquals(r.getName(), s2.getName()));
		System.out.println("rName = David?" + Utilities.nullSafeEquals(r.getName(), "David"));

		System.out.println("sName = s2Name?" + Utilities.nullSafeEquals(s.getName(), s2.getName()));
		System.out.println("sName = rName?" + Utilities.nullSafeEquals(s.getName(), r.getName()));
		System.out.println("sName = null?" + Utilities.nullSafeEquals(s.getName(), null));

		System.out.println("s2Name = rName?" + Utilities.nullSafeEquals(s2.getName(), r.getName()));
		System.out.println("s2Name = sName?" + Utilities.nullSafeEquals(s2.getName(), s.getName()));
		System.out.println("s2Name = Raul?" + Utilities.nullSafeEquals(s2.getName(), "Raul"));
		
// Corredor == raceRunner
		Runner Corredor;
// Nadador == raceSwimmer
		Swimmer Nadador;
// opcionMenu == menuChoice
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
				break;
			default:
				break;
			}
			System.out.println("Añadido");
	}
		
		public static int printMenu() {
			Scanner input = new Scanner(System.in);
			System.out.println("**************************************");
			System.out.println("*********Welcome to DCHCOBRA**********");
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
