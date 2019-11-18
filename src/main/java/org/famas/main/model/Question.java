package org.famas.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class Question implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = -7301385062803077627L;
		
		private int qId;
		private String qName;
		private String qDescription;
		private String qRemarks;
		private String aType;
		private Comments comment;
		private List<SubQuestion> subQuestion =new ArrayList<>(); 
		private List<Answer> answer =new ArrayList<>();
		
		public Question() {
		//s	super();
			// TODO Auto-generated constructor stub
		}

		public Question(int qId, String qName, String qDescription, String qRemarks, String aType, Comments comment,
				List<SubQuestion> subQuestion, List<Answer> answer) {
			super();
			this.qId = qId;
			this.qName = qName;
			this.qDescription = qDescription;
			this.qRemarks = qRemarks;
			this.aType = aType;
			this.comment = comment;
			this.subQuestion = subQuestion;
			this.answer = answer;
		}

		public int getqId() {
			return qId;
		}

		public void setqId(int qId) {
			this.qId = qId;
		}

		public String getqName() {
			return qName;
		}

		public void setqName(String qName) {
			this.qName = qName;
		}

		public String getqDescription() {
			return qDescription;
		}

		public void setqDescription(String qDescription) {
			this.qDescription = qDescription;
		}

		public String getqRemarks() {
			return qRemarks;
		}

		public void setqRemarks(String qRemarks) {
			this.qRemarks = qRemarks;
		}

		public String getaType() {
			return aType;
		}

		public void setaType(String aType) {
			this.aType = aType;
		}

		public Comments getComment() {
			return comment;
		}

		public void setComment(Comments comment) {
			this.comment = comment;
		}

		public List<SubQuestion> getSubQuestion() {
			return subQuestion;
		}

		public void setSubQuestion(List<SubQuestion> subQuestion) {
			this.subQuestion = subQuestion;
		}

		public List<Answer> getAnswer() {
			return answer;
		}

		public void setAnswer(List<Answer> answer) {
			this.answer = answer;
		}

	
		
		
}
