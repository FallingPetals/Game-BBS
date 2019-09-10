package com.njust.edu.pojo;

import java.io.Serializable;

public class Post implements Serializable{
	private int uid;
	private int tid;
	private int bid;
	private String post_date;
	private String post_time;
	private int like_num;
	private int collect_num;
	private int reply_num;
	private String title;
	private String body;
	private int is_delete;
	private int have_reply;
	
	public Post()
	{
		super();
	}
	
	public Post(int uid,int tid,int bid,String post_date,String post_time,int like_num,int collect_num,int reply_num,String title,String body,int is_delete)
	{
		this.uid=uid;
		this.tid=tid;
		this.bid=bid;
		this.post_date=post_date;
		this.post_time=post_time;
		this.like_num=like_num;
		this.collect_num=collect_num;
		this.reply_num=reply_num;
		this.title=title;
		this.body=body;
		this.is_delete=is_delete;
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

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public String getPost_time() {
		return post_time;
	}

	public void setPost_time(String post_time) {
		this.post_time = post_time;
	}

	public int getLike_num() {
		return like_num;
	}

	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}

	public int getCollect_num() {
		return collect_num;
	}

	public void setCollect_num(int collect_num) {
		this.collect_num = collect_num;
	}

	public int getReply_num() {
		return reply_num;
	}

	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	

	public int getHave_reply() {
		return have_reply;
	}

	public void setHave_reply(int have_reply) {
		this.have_reply = have_reply;
	}

	@Override
	public String toString() {
		return "Post [uid=" + uid + ", tid=" + tid + ", bid=" + bid
				+ ", post_date=" + post_date + ", post_time=" + post_time
				+ ", like_num=" + like_num + ", collect_num=" + collect_num
				+ ", reply_num=" + reply_num + ", title=" + title + ", body="
				+ body + ", is_delete=" + is_delete + ", have_reply="
				+ have_reply + "]";
	}

}
