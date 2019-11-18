package org.famas.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class Surveys implements Serializable {
	private static final long serialVersionUID = 182014846975405027L;

	private int sId;

	private int uId;
	
	

	public Surveys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Surveys(int sId, int uId) {
		//super();
		this.sId = sId;
		this.uId = uId;
		
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	

}
