package com.mv.kroger;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class BinaraySearchTest {

	private BinaraySearch obj = new BinaraySearch();
	
	@Test
	public void testBinarySearch() throws Exception {
		int[] testCase = {12, 44, 4, 19, 43, 17, 36, 36, 5, 7};
		Arrays.sort(testCase);
		int target = 19;
		assertTrue(5 == obj.binarySearch(testCase, target));
		target = 10;
		assertTrue( -1 == obj.binarySearch(testCase, target));
	}
	
	@Test
	public void testBinarySearch2() throws Exception {
		int arrayLength = 10;
		int[] testCase = new int[arrayLength];
		int num = 0;
		while(num < arrayLength) {
			testCase[num] = (int )(Math. random() * 50 + 1);
			System.out.print(testCase[num] + ", ");
			num++;
		}
		System.out.println();
		obj.quickSort(testCase);
		for (int j = 0; j < testCase.length; j++) {
			System.out.print(testCase[j] + ", ");
		}
	}
	
	@Ignore
	@Test
	public void testBinarySearch3() throws Exception {
		int arrayLength = 10;
		int[] testCase = {27, 28, 3, 2, 25, 47, 5, 44, 38, 24};
		obj.quickSort(testCase);
		for (int j = 0; j < testCase.length; j++) {
			System.out.print(testCase[j] + ", ");
		}
	}

}
