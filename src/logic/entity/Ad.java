package logic.entity;

import java.time.LocalDate;

public class Ad {
	private User user;
	private String title;
	private String body;
	private String type;
	private LocalDate data;
	
	public Ad() {
		this.user = null;
		this.title = "";
		this.body = "";
		this.type = "";
		this.data = null;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public String getType() {
		return this.type;
	}
	
	public LocalDate getData() {
		return this.data;
	}
}