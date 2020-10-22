import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
	private Runner r;
	private int racerId = 123456;
	private String name = "TestName";
	private int age = 19;
	private String raceActivity = "Corriendo";
	
	@Before
	public void setUp() throws Exception {
		r = new Runner();
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testConstructors() {
		assertNotNull("Default Runner could not be created", r);
		Runner r2 = new Runner(name, age, racerId);
		assertNotNull("Explicit Runner could not be created", r2);
		assertEquals("Name not set correctly on R2"
				, name
				, r2.getName() );
		assertEquals("Age not set correctly on R2"
				, age
				, r2.getAge() );
		assertEquals("RacerId not set correctly on R2"
				, racerId
				, r2.getRacerId());
	}
	
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
	
	@Test
	public void performRaceActivity() {
		String pra = r.performRaceActivity();
		assertTrue("Perform race activity did not contain activity"
				, pra.contains(raceActivity));
	}
	
	@Test
	public void testToString() {
		r.setName(name);
		r.setAge(age);
		r.setRacerId(racerId);
		
		//Da 1 error
		String rts = r.toString();
		assertTrue("To String does not contain name"
				, rts.contains(String.format("%d", name)));
		assertTrue("To String does not contain age"
				, rts.contains(String.format("%d", age)));
		assertTrue("To String does not contain racer id"
				, rts.contains(String.format("%d", racerId)));
		String rc = r.getClass().toString();
		assertTrue("To String does not contain class" 
				, rts.contains(rc));
		assertTrue("To string does not contain performRaceActivity" 
				, rts.contains(raceActivity));
	}

}
