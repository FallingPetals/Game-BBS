package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface StateDao {
	
	public void insertState(State state);
	
	public void updateStateByUidBid(State state);//ֻ�ܸ���uid��bid�޸�state_type��remove_date
	
	public void deleteStateByUidBid(State state);//Ҫͬʱ����uid��bidɾ��
	
	public List<State> queryStateByUid(int uid);//��ѯĳ���˵�����״̬��Ϣ
	
	public List<State> queryStateByBid(int bid);//��ѯĳ��������б����Ի��������ͷ�����
	
	public List<State> queryStateAll();
	

}
