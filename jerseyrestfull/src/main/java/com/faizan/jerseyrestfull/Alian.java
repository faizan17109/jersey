package com.faizan.jerseyrestfull;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Alian {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private int point;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Alian [id=" + id + ", name=" + name + ", point=" + point + "]";
	}
	
}
