package org.famas.main.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class SubQuestion {
	
	private int id;
	private String qDescription;
	private int qId;
	private List<Answer> answer = new ArrayList<>();
	public SubQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubQuestion(int id, String qDescription, int qId, List<Answer> answer) {
		super();
		this.id = id;
		this.qDescription = qDescription;
		this.qId = qId;
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getqDescription() {
		return qDescription;
	}
	public void setqDescription(String qDescription) {
		this.qDescription = qDescription;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public List<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	} 
	
	
}
