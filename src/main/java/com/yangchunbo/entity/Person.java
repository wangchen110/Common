package com.yangchunbo.entity;

import java.util.Date;

public class Person {

	private String username;
	private Integer age;
	private String about;
	private Date date;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Person(String username, Integer age, String about, Date date) {
		super();
		this.username = username;
		this.age = age;
		this.about = about;
		this.date = date;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [username=" + username + ", age=" + age + ", about=" + about + ", date=" + date + "]";
	}
	
	
}
