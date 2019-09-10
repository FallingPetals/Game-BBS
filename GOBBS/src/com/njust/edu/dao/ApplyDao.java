package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface ApplyDao {
	
	public void insertApply(Apply apply);//���ص�sid�ᴢ����apply��
	//�޷��޸ģ�ֻ�ܳ��أ���ɾ��
	
	public void deleteApplyBySid(int sid);
	
	public Apply queryApplyBySid(int sid);//����sid��ѯ�ض�ĳ������
	
	public List<Apply> queryApplyByBid(int bid);//��ѯĳ��������������
	
	public List<Apply> queryApplyAll();

}
