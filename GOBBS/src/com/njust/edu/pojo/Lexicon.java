package com.njust.edu.pojo;

import java.io.Serializable;

public class Lexicon implements Serializable{
	private int id;
	private String content;
	
	public Lexicon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lexicon(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Lexicon [id=" + id + ", content=" + content + "]";
	}
	
	

}
