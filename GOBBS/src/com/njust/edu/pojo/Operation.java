package com.njust.edu.pojo;

import java.io.Serializable;

public class Operation implements Serializable {
	private int uid;
	private int cid;
	private String operation_date;
	private String operation_time;
	private String ip;
	private int operation_type;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(int uid, int cid, String operation_date,
			String operation_time, String ip, int operation_type) {
		super();
		this.uid = uid;
		this.cid = cid;
		this.operation_date = operation_date;
		this.operation_time = operation_time;
		this.ip = ip;
		this.operation_type = operation_type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getOperation_date() {
		return operation_date;
	}

	public void setOperation_date(String operation_date) {
		this.operation_date = operation_date;
	}

	public String getOperation_time() {
		return operation_time;
	}

	public void setOperation_time(String operation_time) {
		this.operation_time = operation_time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(int operation_type) {
		this.operation_type = operation_type;
	}

	@Override
	public String toString() {
		return "Operation [uid=" + uid + ", cid=" + cid + ", operation_date="
				+ operation_date + ", operation_time=" + operation_time
				+ ", ip=" + ip + ", operation_type=" + operation_type + "]";
	}
	
	
	

}
