
public class Runner implements RaceParticipant, Person{
	
	private int racerId;
	private String name;
	private int age;
	
	public Runner() {
		
	}
	
	public Runner (String namel, int agel, int racerIdl) {
		name = namel;
		age = agel;
		racerId = racerIdl;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String namel) {
		name = namel;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int agel) {
		age = agel;
	}
	
	public void setRacerId (int racerIdl) {
		racerId = racerIdl;
	}
	
	public int getRacerId() {
		return racerId;
	}
	
	public String performRaceActivity() {
		return "Corriendo...";
	}
	
	public String toString() {
		return String.format("%s]\tRacerID: %d\tActivity: %s\n"
				, getClass()
				, getName()
				, getAge()
				, getRacerId()
				, performRaceActivity());
	}

}
