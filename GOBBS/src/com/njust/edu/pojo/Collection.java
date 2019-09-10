package com.njust.edu.pojo;

import java.io.Serializable;

public class Collection implements Serializable{
	private int uid;
	private int tid;
	
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection(int uid, int tid) {
		super();
		this.uid = uid;
		this.tid = tid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "Collection [uid=" + uid + ", tid=" + tid + "]";
	}
	
	

}
