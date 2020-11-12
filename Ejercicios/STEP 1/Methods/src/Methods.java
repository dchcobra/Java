
public class Methods {
	public static void main(String[] args) {
		
		Runner r = new Runner();
		r.setID(8);
		
		Swimmer s = new Swimmer();
		s.setID(10);
		
		Swimmer s2 = new Swimmer(3);
		
		System.out.println(r);
		System.out.println(s);
		System.out.println(s2);

		System.out.println("X equals Y?" + Utilities.nullSafeEquals("X", "Y"));
		
	}
}
