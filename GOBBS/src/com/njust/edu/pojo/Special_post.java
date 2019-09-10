package com.njust.edu.pojo;

import java.io.Serializable;

public class Special_post implements Serializable{
	private int bid;
	private int tid;
	private int post_type;
	
	public Special_post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Special_post(int bid, int tid, int post_type) {
		super();
		this.bid = bid;
		this.tid = tid;
		this.post_type = post_type;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getPost_type() {
		return post_type;
	}

	public void setPost_type(int post_type) {
		this.post_type = post_type;
	}

	@Override
	public String toString() {
		return "Special_post [bid=" + bid + ", tid=" + tid + ", post_type="
				+ post_type + "]";
	}
	
	

}
