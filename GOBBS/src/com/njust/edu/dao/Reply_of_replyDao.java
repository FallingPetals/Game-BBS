package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface Reply_of_replyDao {
	
	public void insertRor(Reply_of_reply reply_of_reply);
	
	public void updateRorByLid(Reply_of_reply reply_of_reply);//根据楼中楼编号修改
															  //只能修改like_num,is_delete
	
	public void deleteRorByLid(int lid);
	
	public Reply_of_reply queryRorByLid(int lid);//根据楼中楼编号查询
	
	public List<Reply_of_reply> queryRorByHid(int hid);//查询某个回帖的所有楼中楼回复
	
	public List<Reply_of_reply> queryRorAll();

}
