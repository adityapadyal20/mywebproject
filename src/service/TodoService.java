package service;

import java.util.List;

import model.Todo;

public interface TodoService {
	public boolean createTodo(Todo todo);
	
	public boolean updateTodo(Todo todo);
	
	public boolean deleteTodo(int id);
	
//	public boolean updateTodoStatus(String id[]);
	
	public List<Todo> getAllTodos();
	
	public List<Todo> getselectedTodo(int id);
	
	public List<Todo> selectTodo(String username);
}
