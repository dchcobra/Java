
public abstract class Athlete implements RaceParticipant, Person{

	private int racerId;
	private String name;
	private int age;
	
	public Athlete() {
		
	}
	
	public Athlete (String namel, int agel, int racerIdl) {
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
	
	public abstract String performRaceActivity();
	
	public String toString() {
		return String.format("%s]\\tName: %s \\tAge: %d \tRacerID: %d"
				, getClass()
				, getName()
				, getAge()
				, getRacerId());
	}

}

