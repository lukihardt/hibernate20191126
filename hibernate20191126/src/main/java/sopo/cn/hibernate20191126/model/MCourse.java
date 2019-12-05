package sopo.cn.hibernate20191126.model;

import java.util.HashSet;
import java.util.Set;

public class MCourse {
	private int id;
	private String name;
	private Set<Tcher2> set = new HashSet<>();
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
	public Set<Tcher2> getSet() {
		return set;
	}
	public void setSet(Set<Tcher2> set) {
		this.set = set;
	}
	
	
}
