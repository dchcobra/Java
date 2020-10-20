
public class ClasesConstructores {
	public static void main(String[] args) {
		Runner r = new Runner();
		Swimmer s = new Swimmer();
		Swimmer s2 = new Swimmer(3);
		Runner r2 = new Runner(4);
		
		System.out.println(r);
		System.out.println(s);
		System.out.println(s2);
		System.out.println(r2);

	}
}
