package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface PostDao {
	
	public void insertPost(Post post);//post在插入后，其tid会被更改成被赋予的tid
	
	public void updatePostByTid(Post post);//只能更新like_num,collect_num,reply_num,title,body,is_delete,have_reply 
	
	public void deletePostByTid(int tid);
	
	public Post queryPostByTid(int tid);
	
	public List<Post> queryPostByUid(int uid);//查询某个用户发的所有帖子
	
	public List<Post> queryPostByBid(int bid);//查询某个版块的所有帖子
	
	public List<Post> queryPostAll();//查询所有帖子

}
