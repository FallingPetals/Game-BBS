package com.njust.edu.pojo;

import java.io.Serializable;

public class Reply implements Serializable{
	private int uid;
	private int tid;
	private int bid;
	private int hid;
	private String reply_date;
	private String reply_time;
	private int like_num;
	private int reply_order;
	private String reply_body;
	private int is_delete;
	private int have_reply_of_reply;
	private int ror_num;
	
	public Reply()
	{
		super();
	}

	public Reply(int uid, int tid, int bid, int hid, String reply_date,
			String reply_time, int like_num, int reply_order,
			String reply_body, int is_delete, int have_reply_of_reply,int ror_num) {
		super();
		this.uid = uid;
		this.tid = tid;
		this.bid = bid;
		this.hid = hid;
		this.reply_date = reply_date;
		this.reply_time = reply_time;
		this.like_num = like_num;
		this.reply_order = reply_order;
		this.reply_body = reply_body;
		this.is_delete = is_delete;
		this.have_reply_of_reply = have_reply_of_reply;
		this.ror_num=ror_num;
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

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getReply_date() {
		return reply_date;
	}

	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}

	public String getReply_time() {
		return reply_time;
	}

	public void setReply_time(String reply_time) {
		this.reply_time = reply_time;
	}

	public int getLike_num() {
		return like_num;
	}

	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}

	public int getReply_order() {
		return reply_order;
	}

	public void setReply_order(int reply_order) {
		this.reply_order = reply_order;
	}

	public String getReply_body() {
		return reply_body;
	}

	public void setReply_body(String reply_body) {
		this.reply_body = reply_body;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public int getHave_reply_of_reply() {
		return have_reply_of_reply;
	}

	public void setHave_reply_of_reply(int have_reply_of_reply) {
		this.have_reply_of_reply = have_reply_of_reply;
	}

	

	public int getRor_num() {
		return ror_num;
	}

	public void setRor_num(int ror_num) {
		this.ror_num = ror_num;
	}

	@Override
	public String toString() {
		return "Reply [uid=" + uid + ", tid=" + tid + ", bid=" + bid + ", hid="
				+ hid + ", reply_date=" + reply_date + ", reply_time="
				+ reply_time + ", like_num=" + like_num + ", reply_order="
				+ reply_order + ", reply_body=" + reply_body + ", is_delete="
				+ is_delete + ", have_reply_of_reply=" + have_reply_of_reply + ", ror_num="
				+ ror_num + "]";
	}

	
	
	
}
