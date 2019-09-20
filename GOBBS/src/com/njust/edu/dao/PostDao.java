package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface PostDao {
	
	public void insertPost(Post post);//post�ڲ������tid�ᱻ��ĳɱ������tid
	
	public void updatePostByTid(Post post);//ֻ�ܸ���like_num,collect_num,reply_num,title,body,is_delete,have_reply 
	
	public void deletePostByTid(int tid);
	
	public Post queryPostByTid(int tid);
	
	public List<Post> queryPostByUid(int uid);//��ѯĳ���û�������������
	
	public List<Post> queryPostByBid(int bid);//��ѯĳ��������������
	
	public List<Post> queryPostAll();//��ѯ��������
	
	public List<Post> searchPost(String str);//根据关键字搜索

}
