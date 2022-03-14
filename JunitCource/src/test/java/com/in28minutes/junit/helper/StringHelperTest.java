package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	StringHelper helper=new StringHelper();
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstTwoPossition() {
		//AACD => CD 	CDAA=>CDAA  ACDA=>CDA
	
		//expectec,actual
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
		
	}
	
	@Test
	public void testTruncateAInFirst2Positions2() {
		
		//expectec,actual
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
		
	}

}
