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

}
