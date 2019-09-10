package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface ReplyDao {
	
	public void insertReply(Reply reply);//reply�ڲ������hid�ᱻ���ĳɱ������hid
	
	public void updateReplyByHid(Reply reply);//¥�����͸���post���еĻظ���������ֵ
											  //ֻ�ܸ���like_num,is_delete,have_reply_of_reply,ror_num
	
	public void deleteReplyByHid(int hid);//���ݻظ������ɾ��
	
	public Reply queryReplyByHid(int hid);
	
	public List<Reply> queryReplyByUidTid(Reply reply);//��ѯĳ���û���ĳ�����ӷ������лظ�,��Ϊֻ�ܴ�һ��ֵ������ֻ�ð�uid��tidд��reply���У����������ͺ�
	
	public List<Reply> queryReplyByTid(int tid);//��ѯĳ�����ӵ����лظ�
	
	public List<Reply> queryReplyAll();

}
