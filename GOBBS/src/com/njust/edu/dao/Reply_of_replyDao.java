package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface Reply_of_replyDao {
	
	public void insertRor(Reply_of_reply reply_of_reply);
	
	public void updateRorByLid(Reply_of_reply reply_of_reply);//����¥��¥����޸�
															  //ֻ���޸�like_num,is_delete
	
	public void deleteRorByLid(int lid);
	
	public Reply_of_reply queryRorByLid(int lid);//����¥��¥��Ų�ѯ
	
	public List<Reply_of_reply> queryRorByHid(int hid);//��ѯĳ������������¥��¥�ظ�
	
	public List<Reply_of_reply> queryRorAll();

}
