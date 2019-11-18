package org.famas.main.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Answer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8392151882671990688L;

	private int aId;
	private int subQuestionId;
	private String aName;
	private String aDescription;
	private int question_q_id;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int aId, int subQuestionId, String aName, String aDescription, int question_q_id) {
		super();
		this.aId = aId;
		this.subQuestionId = subQuestionId;
		this.aName = aName;
		this.aDescription = aDescription;
		this.question_q_id = question_q_id;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getSubQuestionId() {
		return subQuestionId;
	}
	public void setSubQuestionId(int subQuestionId) {
		this.subQuestionId = subQuestionId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaDescription() {
		return aDescription;
	}
	public void setaDescription(String aDescription) {
		this.aDescription = aDescription;
	}
	public int getQuestion_q_id() {
		return question_q_id;
	}
	public void setQuestion_q_id(int question_q_id) {
		this.question_q_id = question_q_id;
	}


	
}
