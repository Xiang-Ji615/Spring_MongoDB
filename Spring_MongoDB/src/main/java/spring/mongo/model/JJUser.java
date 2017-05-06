package main.java.spring.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class JJUser {

	String id;
	String username;
	String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
