package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void LetsMockListMethod() {
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}

	@Test
	public void LetsMockList_ReturnMultipleValues() {
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void LetsMockListGet() {
		List listMock=mock(List.class);
		//ArgumentMatcher
		when(listMock.get(0)).thenReturn("Nishant");
		when(listMock.get(anyInt())).thenReturn("Nishant");
		assertEquals("Nishant", listMock.get(0));
		assertEquals("Nishant", listMock.get(25));
		//assertEquals(null, listMock.get(0));//if u dont tell what to retun then default values will retunr
	}
	
	@Test(expected = RuntimeException.class)
	public void LetsMockListExceptionTest() {
		List listMock=mock(List.class);
	
		when(listMock.get(0)).thenThrow(new RuntimeException("something"));
		
		listMock.get(0);
	}

	
	@Test
	public void LetsMockListGetDefault() {
		List listMock=mock(List.class);
		
		
		assertEquals(null, listMock.get(0));//if u dont tell what to retun then default values will retunr
	}
}
