package model;

import java.util.Date;

public class Todo {
	private int id;
	private String  description;
	private boolean isDone;
	private String targetDate;
	private String username;
	private String title;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Todo(int id, String description, boolean isDone, String date, String username, String title) {
		super();
		this.id = id;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = date;
		this.username = username;
		this.title = title;
	}
	public Todo() {
		super();
	}
	public Todo(int id, String description, String target_date, String username, String title) {
		this.id = id;
		this.description = description;
		this.targetDate = target_date;
		this.username = username;
		this.title = title;
	}
	
	public Todo(String description, String targetDate, String username, String title) {
		this.description = description;
		this.targetDate = targetDate;
		this.username = username;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", isDone=" + isDone + ", targetDate=" + targetDate
				+ ", username=" + username + ", Title=" + title + "]";
	}
	
	
}
