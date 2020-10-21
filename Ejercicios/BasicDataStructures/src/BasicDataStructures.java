import java.util.ArrayList;
import java.util.Scanner;


public class BasicDataStructures {
	
	public static void main(String[] args) {
		final int MAX_RACE_RUNNERS = 5;
		// corredores == raceRunners 
		Runner[] corredores = new Runner[MAX_RACE_RUNNERS];
		// ContadorCorredores == raceRunnerCount
		int ContadorCorredores = 0;
		ArrayList<Swimmer> raceSwimmers = new ArrayList<Swimmer>();
		// opcionMenu == menuChoice
		boolean menuFuncionamiento = true;
		
		while (menuFuncionamiento) {
			int opcionMenu = printMenu();
			switch (opcionMenu) {
				case 1:
					System.out.println("Has escogido crear un nuevo corredor");
					if (ContadorCorredores < MAX_RACE_RUNNERS) {
						corredores[ContadorCorredores] = getNuevoCorredor();
						ContadorCorredores++;
					} else {
						System.out.println("La carrera esta llena, no se pueden añadir más corredores");
					}
					break;
				case 2:
					System.out.println("Has escogido crear un nuevo nadador");
					raceSwimmers.add(getNuevoNadador());
					break;
				case 3:
					System.out.println("Gracias por usar la herramienta DCHCOBRA");
					menuFuncionamiento = false;
					break;
			}
		}
		
		
		System.out.println("RESULTADO");
		System.out.println("CORREDORES: ");
		for (int i = 0; i < ContadorCorredores; i++) {
			System.out.println(corredores[i]);
		}
		System.out.println("NADADORES: ");
		for (int i = 0; i < raceSwimmers.size(); i++) {
			System.out.println(raceSwimmers.get(i));
		}
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
