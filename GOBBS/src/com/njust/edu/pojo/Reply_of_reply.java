package com.njust.edu.pojo;

import java.io.Serializable;

public class Reply_of_reply implements Serializable{
	private int uid;
	private int hid;
	private int lid;
	private String ror_date;
	private String ror_time;
	private int like_num;
	private int ror_order;
	private String ror_body;
	private int is_delete;
	public Reply_of_reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reply_of_reply(int uid, int hid, int lid, String ror_date,
			String ror_time, int like_num, int ror_order, String ror_body,
			int is_delete) {
		super();
		this.uid = uid;
		this.hid = hid;
		this.lid = lid;
		this.ror_date = ror_date;
		this.ror_time = ror_time;
		this.like_num = like_num;
		this.ror_order = ror_order;
		this.ror_body = ror_body;
		this.is_delete = is_delete;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getRor_date() {
		return ror_date;
	}

	public void setRor_date(String ror_date) {
		this.ror_date = ror_date;
	}

	public String getRor_time() {
		return ror_time;
	}

	public void setRor_time(String ror_time) {
		this.ror_time = ror_time;
	}

	public int getLike_num() {
		return like_num;
	}

	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}

	public int getRor_order() {
		return ror_order;
	}

	public void setRor_order(int ror_order) {
		this.ror_order = ror_order;
	}

	public String getRor_body() {
		return ror_body;
	}

	public void setRor_body(String ror_body) {
		this.ror_body = ror_body;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	@Override
	public String toString() {
		return "Reply_of_reply [uid=" + uid + ", hid=" + hid + ", lid=" + lid
				+ ", ror_date=" + ror_date + ", ror_time=" + ror_time
				+ ", like_num=" + like_num + ", ror_order=" + ror_order
				+ ", ror_body=" + ror_body + ", is_delete=" + is_delete + "]";
	}
	
	

}
