package serviceimpl;

import java.util.List;

import dao.TodoDao;
import daoimpl.TodoDaoImpl;
import model.Todo;
import service.TodoService;

public class TodoServiceImpl implements TodoService {
	
	TodoDao todoDao = new TodoDaoImpl();

	public boolean createTodo(Todo todo) {
		
		return todoDao.createToDo(todo);
	}

	public boolean updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		return todoDao.updateToDo(todo);
	}

	public boolean deleteTodo(int id) {
		// TODO Auto-generated method stub
		return todoDao.deleteToDo(id);
	}

	public List<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		return todoDao.getAllTodos();
	}

	public List<Todo> getselectedTodo(int id) {
		// TODO Auto-generated method stub
		return todoDao.getSelectedTodo(id);
	}

	public List<Todo> selectTodo(String username) {
		// TODO Auto-generated method stub
		return todoDao.selectTodo(username);
	}

	/*public boolean updateTodoStatus(String id[]) {
		// TODO Auto-generated method stub
		return todoDao.updateTodoStatus(id);
	}*/
	
}