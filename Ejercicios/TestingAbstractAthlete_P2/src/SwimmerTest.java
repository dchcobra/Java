import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SwimmerTest extends AthleteTest{
	private Swimmer r;
	private String raceActivity = "Swimming";
	
	@Override
	public Athlete getAthlete() {
		return new Swimmer();
	}

	@Override
	public Athlete getExplicitAthlete() {
		return new Swimmer(name, age, racerId);
	}

	
	@Before
	public void setUp() {
		r = new Swimmer();
	}

	@After
	public void tearDown() {
		r = null;
	}
	
	/*
	@Test
	public void testConstructors() {
		super.testConstructors();
	}
	*/
		
	@Test
	public void testPerformRaceActivity() {
		String pra = r.performRaceActivity();
		assertTrue("Perform race activity did not contain activity"
				, pra.contains(raceActivity));
	}
	
	@Test
	public void testToString() {
		super.testToString();
		r.setName(name);
		r.setAge(age);
		r.setRacerId(racerId);
		//Me devuelve 1 error a mí y en el cursillo no da ningun error
		String rts = r.toString();
		String rc = r.getClass().toString();
		assertTrue("To String does not contain class" 
				, rts.contains(rc));
		assertTrue("To string does not contain performRaceActivity" 
				, rts.contains(raceActivity));
	}

	

}
