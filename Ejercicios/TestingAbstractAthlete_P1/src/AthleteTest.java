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

}
