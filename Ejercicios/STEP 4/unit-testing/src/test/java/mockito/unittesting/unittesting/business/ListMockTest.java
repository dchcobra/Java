package mockito.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {
/* CHAPTER 2 - STEP 9 */
	
	//List mock = mock(List.class);
	List<String> mock = mock(List.class); //CHAPTER 2 - STEP 10


	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
/* CHAPTER 2 - STEP 10 */
	
	@Test
	public void returnWithGeneriParametes() {
		when(mock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(1));
	}
/* CHAPTER 2 - STEP 11 */
	@Test
	public void verificationBasics() {
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);


	}
	
/* CHAPTER 2 - STEP 12 */
	@Test
	public void argumentCapturing() {
		mock.add("SomeString");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
	
		assertEquals("SomeString", captor.getValue());
	}
/* CHAPTER 2 - STEP 13 */
	@Test
	public void multipleArgumentCapturing() {
		mock.add("SomeString1");
		mock.add("SomeString2");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
	
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));

	}
	
/* CHAPTER 2 - STEP 14 */
	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());
		
		when(arrayListSpy.size()).thenReturn(5); //Change the size to 5 when you call arrayListSpy.size()
		System.out.println(arrayListSpy.size());
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size()); //Position 4 & 5 are empties

	}
	
}
