package com.njust.edu.pojo;

import java.io.Serializable;

public class Apply implements Serializable{
	private int uid;
	private int bid;
	private int sid;
	private String apply_date;
	private String apply_time;
	private String reason;
	private String working_experience;
	
	public Apply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Apply(int uid, int bid, int sid, String apply_date,
			String apply_time, String reason, String working_experience) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.sid = sid;
		this.apply_date = apply_date;
		this.apply_time = apply_time;
		this.reason = reason;
		this.working_experience = working_experience;
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

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getApply_date() {
		return apply_date;
	}

	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}

	public String getApply_time() {
		return apply_time;
	}

	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getWorking_experience() {
		return working_experience;
	}

	public void setWorking_experience(String working_experience) {
		this.working_experience = working_experience;
	}

	@Override
	public String toString() {
		return "Apply [uid=" + uid + ", bid=" + bid + ", sid=" + sid
				+ ", apply_date=" + apply_date + ", apply_time=" + apply_time
				+ ", reason=" + reason + ", working_experience="
				+ working_experience + "]";
	}
	
	
	

}
