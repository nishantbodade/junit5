package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort() {
		int[] numbers= {2,5,7,3,1};
		int[] expected={1,2,3,5,7};
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
		
	}


	@Test(expected = NullPointerException.class)
	public void testArraySort_ExceptionTest() {
		int[] numbers= null;
		int[] expected={1,2,3,5,7};
		Arrays.sort(numbers);
	
		
	}
	

	@Test(timeout = 1000)
	public void testArraySort_Performance() {
		int[] numbers= {2,5,7,3,1};
	
	for(int i=0;i<1000;i++) {
		numbers[0]=i;
		Arrays.sort(numbers);
		
	}
		
	}
}
