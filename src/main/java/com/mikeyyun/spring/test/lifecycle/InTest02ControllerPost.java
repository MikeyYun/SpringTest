package com.mikeyyun.spring.test.lifecycle;

public class InTest02ControllerPost {
	
	// Title, User, Content
	
	private String title;
	private String user;
	private String content;
	
	public InTest02ControllerPost(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}
	
}
