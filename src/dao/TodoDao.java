package dao;

import java.util.List;

import model.Todo;

public interface TodoDao {
	
	public boolean createToDo(Todo todo);
	
	public boolean deleteToDo(int id);
	
	public boolean updateToDo(Todo todo);
	
	public List<Todo> getAllTodos();

	public List<Todo> getSelectedTodo(int id);

//	public boolean updateTodoStatus(String id[]);
	
	public List<Todo> selectTodo(String username);
	
}
