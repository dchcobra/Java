package mockito.unittesting.unittesting.business;

import java.util.Arrays;

import mockito.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
/* CHAPTER 2 - STEP 2
	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value:data) {
			sum += value;
		}
		return sum;
	}
*/
	/* CHAPTER 2 - STEP 3 */
	
	SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
/*
	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value:data) {
			sum += value;
		}
		return sum;
	}
	*/
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.retrieveAllData();
		for(int value:data) {
			sum += value;
		}
		return sum;
	}
	
	/* CHAPTER 3 - STEP 19 */

	public int calculateSum(int[] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
}
