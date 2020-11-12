import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class AthleteTest {
	private Athlete a1;
	private Athlete a2;
	protected String name = "Test Athlete";
	protected int age = 19;
	protected int racerId = 312;
	
	
	public abstract Athlete getAthlete();
	public abstract Athlete getExplicitAthlete();
	
	public AthleteTest() {
		a1 = getAthlete();
		a2 = getExplicitAthlete();
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructors() {
		assertNotNull("Default Runner could not be created", a1);
		assertNotNull("Explicit Runner could not be created", a2);
		assertEquals("Name not set correctly on a2"
				, name
				, a2.getName() );
		assertEquals("Age not set correctly on a2"
				, age
				, a2.getAge() );
		assertEquals("RacerId not set correctly on a2"
				, racerId
				, a2.getRacerId());
	}
	
	@Test
	public void testGetSetName() {
		a1.setName(name);
		assertEquals("The Name could not be set as expected"
				, name
				, a1.getName());
	}
	
	@Test
	public void testGetSetAge() {
		a1.setAge(age);
		assertEquals("The age could not be set as expected"
				, age
				, a1.getAge());
	}
	
	@Test
	public void testGetSetRacerId() {
		a1.setRacerId(racerId);
		assertEquals("The racerId could not be set as expected"
				, racerId
				, a1.getRacerId());
	}
	
	public abstract void testPerformRaceActivity();
	
	@Test
	public void testToString() {
		a1.setName(name);
		a1.setAge(age);
		a1.setRacerId(racerId);
		//Me devuelve 1 error a mí y en el cursillo no da ningun error
		String rts = a1.toString();
		assertTrue("To String does not contain name"
				, rts.contains(String.format("%d", name)));
		assertTrue("To String does not contain age"
				, rts.contains(String.format("%d", age)));
		assertTrue("To String does not contain racer id"
				, rts.contains(String.format("%d", racerId)));
		String rc = a1.getClass().toString();
		assertTrue("To String does not contain class" 
				, rts.contains(rc));
	}

}
