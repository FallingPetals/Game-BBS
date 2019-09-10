package com.njust.edu.pojo;

import java.io.Serializable;

public class State implements Serializable{
	private int uid;
	private int bid;
	private int state_type;
	private String remove_date;
	
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(int uid, int bid, int state_type, String remove_date) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.state_type = state_type;
		this.remove_date = remove_date;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getState_type() {
		return state_type;
	}

	public void setState_type(int state_type) {
		this.state_type = state_type;
	}

	public String getRemove_date() {
		return remove_date;
	}

	public void setRemove_date(String remove_date) {
		this.remove_date = remove_date;
	}

	@Override
	public String toString() {
		return "State [uid=" + uid + ", bid=" + bid + ", state_type="
				+ state_type + ", remove_date=" + remove_date + "]";
	}
	
	

}
