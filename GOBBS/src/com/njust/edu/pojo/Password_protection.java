package com.njust.edu.pojo;

import java.io.Serializable;

public class Password_protection implements Serializable{
	private int uid;
	private int order_number;
	private String question;
	private String answer;
	
	public Password_protection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Password_protection(int uid, int order_number, String question,
			String answer) {
		super();
		this.uid = uid;
		this.order_number = order_number;
		this.question = question;
		this.answer = answer;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Password_protection [uid=" + uid + ", order_number="
				+ order_number + ", question=" + question + ", answer="
				+ answer + "]";
	}
	
	

}
