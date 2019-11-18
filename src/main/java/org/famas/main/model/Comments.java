package org.famas.main.model;

public class Comments {
	private int id;
	private String comment;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
