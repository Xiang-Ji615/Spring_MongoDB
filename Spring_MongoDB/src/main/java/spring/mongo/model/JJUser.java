package main.java.spring.mongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



public class JJUser {

	@Id
	String id;
	String username;
	String password;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	Date createDate;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public JJUser(String username, String password, Date createDate) {
		super();
		this.username = username;
		this.password = password;
		this.createDate = createDate;
	}

	public JJUser() {
		super();
	}

	@Override
	public String toString() {
		return "JJUser [id=" + id + ", username=" + username + ", password=" + password + ", createDate=" + createDate
				+ "]";
	}

}
