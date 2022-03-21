package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.stub.TodoServiceStub;

public class TodoBusinessImplMockTest {

	@Test
	public void usingAMock() {
		TodoService todoServiceMock =mock(TodoService.class);
		
	List<String> todo=Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	
	when(todoServiceMock.retrieveTodos("dummy")).thenReturn(todo);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("dummy");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void usingABDDMock() {
		
		//given
		TodoService todoServiceMock =mock(TodoService.class);
		
		List<String> todo=Arrays.asList("Learn Spring MVC", "Learn Spring",
					"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("dummy")).willReturn(todo);//syntax change for BDD
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//when
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("dummy");
		
		//then
		
		assertThat( todos.size(),is(2));//more readable in BDD
		
		
		
		
	}
}