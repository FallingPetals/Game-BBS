package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface StateDao {
	
	public void insertState(State state);
	
	public void updateStateByUidBid(State state);//只能根据uid和bid修改state_type和remove_date
	
	public void deleteStateByUidBid(State state);//要同时根据uid和bid删除
	
	public List<State> queryStateByUid(int uid);//查询某个人的所有状态信息
	
	public List<State> queryStateByBid(int bid);//查询某个版块所有被禁言或者其他惩罚的人
	
	public List<State> queryStateAll();
	

}
