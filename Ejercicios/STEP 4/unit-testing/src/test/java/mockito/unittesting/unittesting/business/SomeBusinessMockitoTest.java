package mockito.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import mockito.unittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockitoTest {
	/* CHAPTER 2 - STEP 6 - 8*/
	@InjectMocks
	//SomeBusinessImpl business; @RunWith deprecateed
	SomeBusinessImpl business = new SomeBusinessImpl();

	
	@Mock
	//SomeDataService dataServiceMock; @RunWith deprecateed
	SomeDataService dataServiceMock = mock(SomeDataService.class);

	
	@BeforeEach
	public void before() {
		business.setSomeDataService(dataServiceMock);
	}
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		business.setSomeDataService(dataServiceMock);
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {  });
		business.setSomeDataService(dataServiceMock);
		assertEquals(0, business.calculateSumUsingDataService());	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		business.setSomeDataService(dataServiceMock);
		assertEquals(5, business.calculateSumUsingDataService());
	}
	
	
}
