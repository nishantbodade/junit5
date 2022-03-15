package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterized {
	
	private String input;
	private String expectedoutput;
	
	
	
	

	public StringHelperParameterized(String input, String expectedoutput) {
		super();
		this.input = input;
		this.expectedoutput = expectedoutput;
	}

	StringHelper helper=new StringHelper();
	
	@Parameters
	public static Collection<String[]> testConditions() {
		String expectedoutput[][]= {
				{"AACD","CD"},
				{"ACD","CD"}
		};
		return Arrays.asList(expectedoutput);
		
	}
	
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstTwoPossition() {
		//AACD => CD 	CDAA=>CDAA  ACDA=>CDA
	
		//expectec,actual
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
		
	}
	
	@Test
	public void testTruncateAInFirst2Positions2() {
		
		//expectec,actual
		assertEquals(expectedoutput, helper.truncateAInFirst2Positions("ACD"));
		
	}
	
	

}
