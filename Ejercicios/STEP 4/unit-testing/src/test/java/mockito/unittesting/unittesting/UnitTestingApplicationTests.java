package mockito.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations= {"classpath:test-configuration.propierties"})
public class UnitTestingApplicationTests {

	@Test
	public void contextLoads() {
	}

}
