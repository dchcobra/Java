package raceManagerObjects;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BikerTest {
	private Biker r;
	private int racerId = 123456;
	private String name = "TestName";
	private int age = 19;
	private String raceActivity = "Biking";
	private boolean usesClips = false;
	@Before
	public void setUp() throws Exception {
		r = new Biker();
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testConstructors() {
		assertNotNull("Default Biker could not be created", r);
		Biker r2 = new Biker(name, age, racerId, usesClips);
		assertNotNull("Explicit Biker could not be created", r2);
		assertEquals("Name not set correctly on R2"
				, name
				, r2.getName() );
		assertEquals("Age not set correctly on R2"
				, age
				, r2.getAge() );
		assertEquals("RacerId not set correctly on R2"
				, racerId
				, r2.getRacerId());
		assertEquals("usesClips not set correctly on R2"
				, usesClips
				, r2.getUsingClips());
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
	public void testGetSetShoeBrand() {
		r.setUsingClips(usesClips);
		assertEquals("The clips could not be set as expected"
				, usesClips
				, r.getUsingClips());
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
		r.setUsingClips(usesClips);
		//Me devuelve 1 error a mí y en el cursillo no da ningun error
		String rts = r.toString();
		assertTrue("To String does not contain name"
				, rts.contains(String.format("%d", name)));
		assertTrue("To String does not contain age"
				, rts.contains(String.format("%d", age)));
		assertTrue("To String does not contain racer id"
				, rts.contains(String.format("%d", racerId)));
		assertTrue("To String does not contain using Clips"
				, rts.contains(String.format("%d", usesClips)));
		String rc = r.getClass().toString();
		assertTrue("To String does not contain class" 
				, rts.contains(rc));
		assertTrue("To string does not contain performRaceActivity" 
				, rts.contains(raceActivity));
	}

}
