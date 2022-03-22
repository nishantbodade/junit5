package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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

	@Test
	public void testMethodCall() {
		
		//given
		TodoService todoServiceMock =mock(TodoService.class);
		
		List<String> todo=Arrays.asList("Learn Spring MVC", "Learn Spring",
					"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("dummy")).willReturn(todo);//syntax change for BDD
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//when
		 todoBusinessImpl
				.deleteTodosRelatedToSpring("dummy");
		
		//then
		 verify(todoServiceMock,times(1)).deleteToDo("Learn to Dance");//how many time to call ,in this one time only
		verify(todoServiceMock).deleteToDo("Learn to Dance");//method call check ,on Learn to Dance string value pass
		verify(todoServiceMock,never()).deleteToDo("todoServiceMock");//never call
		//then(todoServiceMock).should().deleteToDo("Learn to Dance");// then should nevel call or call
		
		
		
	}

	@Test
	public void testBDDArgumentCapture() {
		
		//declare args
		ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
		
		//define args capture on specific methods call
		//capture the args
		
		//given
		TodoService todoServiceMock =mock(TodoService.class);
		
		List<String> todo=Arrays.asList("Learn Spring MVC", "Learn Spring",
					"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("dummy")).willReturn(todo);//syntax change for BDD
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//when
		 todoBusinessImpl
				.deleteTodosRelatedToSpring("dummy");
		
		//then

		then(todoServiceMock).should().deleteToDo(argumentCaptor.capture());// then should nevel call or call
		//then(todoServiceMock).should(times(2)).deleteToDo(argumentCaptor.capture());// thwo times or more times method calls then do this
		assertThat(argumentCaptor.getValue(), is("Learn to Dance"));
		
		
		
		//assertThat(argumentCaptor.getAllValues().size(), is(2));//check the size
		
		
		
	}
}