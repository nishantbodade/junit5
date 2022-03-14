package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test
	public void test() {
		//AACD => CD 	CDAA=>CDAA  ACDA=>CDA
		StringHelper helper=new StringHelper();
		//expectec,actual
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}

}
