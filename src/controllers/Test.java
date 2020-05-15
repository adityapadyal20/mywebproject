package controllers;

import dao.TodoDao;
import daoimpl.TodoDaoImpl;
import model.Todo;

public class Test {

	public static void main(String[] args) {
		
		TodoDao todo = new TodoDaoImpl();
		
		for(Todo todo2:todo.getAllTodos()) {
			System.out.println(todo2);
		}
		
	}

}
