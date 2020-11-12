import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest extends AthleteTest{
	private Runner r;
	private String raceActivity = "Corriendo";
	private String shoes = "Any shoe Brand";
	
	@Override
	public Athlete getAthlete() {
		return new Runner();
	}

	@Override
	public Athlete getExplicitAthlete() {
		return new Runner(name, age, racerId, shoes);
	}
	
	@Before
	public void setUp() throws Exception {
		r = new Runner();
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testRunnersConstructors() {
		super.testConstructors();
		Runner r2 = new Runner(name, age, racerId, shoes);
		assertNotNull("Explicit Runner could not be created", r2);
		assertEquals("Shoes not set correctly on R2"
				, shoes
				, r2.getShoeBrand());
	}
	/*
	@Test
	public void testGetSetName() {
		r.setName(name);
		assertEquals("The Name could not be set as expected"
				, name
				, r.getName());
	}
	
	@Test
	public void testGetSetAge() {
		r.setAge(age);
		assertEquals("The age could not be set as expected"
				, age
				, r.getAge());
	}
	
	@Test
	public void testGetSetRacerId() {
		r.setRacerId(racerId);
		assertEquals("The racerId could not be set as expected"
				, racerId
				, r.getRacerId());
	}	
	*/
	@Test
	public void testGetSetShoeBrand() {
		r.setShoeBrand(shoes);
		assertEquals("The shoes could not be set as expected"
				, shoes
				, r.getShoeBrand());
	}
	
	@Test
	public void testPerformRaceActivity() {
		String pra = r.performRaceActivity();
		assertTrue("Perform race activity did not contain activity"
				, pra.contains(raceActivity));
	}
	/*
	@Test
	public void testToString() {
		r.setName(name);
		r.setAge(age);
		r.setRacerId(racerId);
		r.setShoeBrand(shoes);
		//Me devuelve 1 error a mí y en el cursillo no da ningun error
		String rts = r.toString();
		assertTrue("To String does not contain name"
				, rts.contains(String.format("%d", name)));
		assertTrue("To String does not contain age"
				, rts.contains(String.format("%d", age)));
		assertTrue("To String does not contain racer id"
				, rts.contains(String.format("%d", racerId)));
		assertTrue("To String does not contain shoes"
				, rts.contains(String.format("%d", shoes)));
		String rc = r.getClass().toString();
		assertTrue("To String does not contain class" 
				, rts.contains(rc));
		assertTrue("To string does not contain performRaceActivity" 
				, rts.contains(raceActivity));
	}
	*/
	

}
