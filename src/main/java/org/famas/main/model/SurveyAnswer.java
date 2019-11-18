package org.famas.main.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class SurveyAnswer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7121133691566352672L;
	// private static final long serialVersionUID = 1L;
	
	private int id;
	private int aId;
	private int qId;
	private String remarks;
	private int subQuestionId;
	private int commentId;
	private Surveys survey;
	public SurveyAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SurveyAnswer(int id, int aId, int qId, String remarks, int subQuestionId, int commentId, Surveys survey) {
		super();
		this.id = id;
		this.aId = aId;
		this.qId = qId;
		this.remarks = remarks;
		this.subQuestionId = subQuestionId;
		this.commentId = commentId;
		this.survey = survey;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getSubQuestionId() {
		return subQuestionId;
	}
	public void setSubQuestionId(int subQuestionId) {
		this.subQuestionId = subQuestionId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public Surveys getSurvey() {
		return survey;
	}
	public void setSurvey(Surveys survey) {
		this.survey = survey;
	}
	
	
}
