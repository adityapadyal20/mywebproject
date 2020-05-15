package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.TodoDao;
import model.Todo;
import model.User;
import utils.JDBCUtils;

public class TodoDaoImpl implements TodoDao{
	
	public boolean createToDo(Todo todo) {
		final String sql = "insert into todos(description,target_date,username,title)values(?,?,?,?)";
		Connection con = JDBCUtils.getConnection();
		int i = -1;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, todo.getDescription());
			preparedStatement.setDate(2,  java.sql.Date.valueOf(todo.getTargetDate()));
			preparedStatement.setString(3, todo.getUsername());
			preparedStatement.setString(4, todo.getTitle());
			
			i = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (i==1 ? true:false);
		
	}



	public boolean updateToDo(Todo todo) {
		final String sql = "update todos set title=?,description=?,username=?,target_date=? where id = ?";	
		Connection con = JDBCUtils.getConnection();
		int i = -1;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, todo.getTitle());
			preparedStatement.setString(2, todo.getDescription());
			preparedStatement.setString(3, todo.getUsername());
			preparedStatement.setDate(4, java.sql.Date.valueOf(todo.getTargetDate()));
			preparedStatement.setInt(5, todo.getId());
			i = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (i==1 ? true:false);
	}

	public List<Todo> getAllTodos() {
		final String sql = "select * from todos";
		List<Todo> todos = new ArrayList<Todo>();
		Connection con = JDBCUtils.getConnection();
		try {
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			int id =  resultSet.getInt(1);
			String description =  resultSet.getString(2);
			boolean isDone =  resultSet.getBoolean(3);
			String date =  resultSet.getString(4);
			String username =  resultSet.getString(5);
			String title =  resultSet.getString(6);
			Todo todo = new Todo(id,description,isDone,date,username,title);
			todos.add(todo);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return todos;
	}

	public List<Todo> getSelectedTodo(int id) {
		final String sql = "select description,target_date,username,title from todos where id=?";	
		Connection con = JDBCUtils.getConnection();
		List<Todo> todoList = new ArrayList<Todo>();
		String todoListId = String.valueOf(id);
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, todoListId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String description = rs.getString(1);
				String target_date = rs.getString(2);
				String username = rs.getString(3);
				String title = rs.getString(4);
				Todo todo = new Todo(id,description,target_date,username,title);
				todoList.add(todo);
			}
 		}catch(Exception e) {
			e.printStackTrace();
		}
		return todoList;
	}



	public boolean deleteToDo(int id) {
		final String sql = "delete from todos where id=?";
		Connection con = JDBCUtils.getConnection();
		int i = -1;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			i = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (i==1 ? true:false);
	}

/*	public boolean updateTodoStatus(String id[]) {
		int i = -1;
		try {
		int strLength = id.length;
		for(int j=0;j<id.length;i++) {
			String sql1,sql2;
			Connection con = JDBCUtils.getConnection();
			PreparedStatement preparedStatement;
			if(Integer.parseInt(id[j]) < strLength){
				sql1 = "update todos set is_done=true where id = ?";
				preparedStatement = con.prepareStatement(sql1);
			}
			else {
				sql2 = "update todos set is_done=false where id = ?";
				preparedStatement = con.prepareStatement(sql2);
			}
			preparedStatement.setInt(1, Integer.parseInt(id[j]));
			i = preparedStatement.executeUpdate();
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return (i==1 ? true:false);
	}*/
	
	public List<Todo> selectTodo(String username){
		final String sql = "select * from todos where username=?";	
		Connection con = JDBCUtils.getConnection();
		List<Todo> todoList = new ArrayList<Todo>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String description = rs.getString(2);
				String targetDate = rs.getString(4);
				String uname = rs.getString(5);
				String title = rs.getString(6);
				Todo todo = new Todo(description,targetDate,uname,title);
				todoList.add(todo);
			}
 		}catch(Exception e) {
			e.printStackTrace();
		}
		return todoList;
	}
}
