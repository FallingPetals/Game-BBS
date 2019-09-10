package com.njust.edu.pojo;

import java.io.Serializable;

public class Section implements Serializable{
	private int bid;
	private String section_name;
	private int section_type;
	private String headline;
	
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Section(int bid, String section_name, int section_type,
			String headline) {
		super();
		this.bid = bid;
		this.section_name = section_name;
		this.section_type = section_type;
		this.headline = headline;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public int getSection_type() {
		return section_type;
	}

	public void setSection_type(int section_type) {
		this.section_type = section_type;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Override
	public String toString() {
		return "Section [bid=" + bid + ", section_name=" + section_name
				+ ", section_type=" + section_type + ", headline=" + headline
				+ "]";
	}
	
	

}
