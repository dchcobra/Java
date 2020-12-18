package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	@Test
	public void sum_with3numbers() {
		MyMath myMath = new MyMath();
		int result = myMath.sum(new int[] {1, 2, 3});
		assertEquals(6, result);
	}
	
	@Test
	public void sum_with1numbers() {
		MyMath myMath = new MyMath();
		int result = myMath.sum(new int[] {3});
		assertEquals(3, result);
	}

}
