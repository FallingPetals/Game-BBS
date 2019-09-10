package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface ReplyDao {
	
	public void insertReply(Reply reply);//reply在插入后，其hid会被更改成被赋予的hid
	
	public void updateReplyByHid(Reply reply);//楼层数就根据post表中的回复数量来赋值
											  //只能更新like_num,is_delete,have_reply_of_reply,ror_num
	
	public void deleteReplyByHid(int hid);//根据回复编号来删除
	
	public Reply queryReplyByHid(int hid);
	
	public List<Reply> queryReplyByUidTid(Reply reply);//查询某个用户在某个帖子发的所有回复,因为只能传一个值，所以只用把uid和tid写入reply就行，其他随便填就好
	
	public List<Reply> queryReplyByTid(int tid);//查询某个帖子的所有回复
	
	public List<Reply> queryReplyAll();

}
