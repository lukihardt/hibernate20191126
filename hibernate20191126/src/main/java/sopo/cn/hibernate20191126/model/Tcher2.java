package sopo.cn.hibernate20191126.model;

import java.util.Set;

public class Tcher2 {
	private int id;
	private String name;
	private Set<MCourse> courses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<MCourse> getCourses() {
		return courses;
	}
	public void setCourses(Set<MCourse> courses) {
		this.courses = courses;
	}
}
