import Utilities.*;

public class PackagesAndJars {
	
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


	}
}