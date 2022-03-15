package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {
	
	@BeforeClass
	//before class must be static
	public static void beforeClass() {
		System.out.println("before class");
		
	}

	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	
	@Before
	public void setup() {
		System.out.println("Before tests");
	}
	
	@After
	public void tearDown() {
		System.out.println("After tests");
	}
	
	@AfterClass
	//after class must be static
	public static void afterClass() {
		System.out.println("after class");
		
	}


}
