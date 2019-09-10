package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface ApplyDao {
	
	public void insertApply(Apply apply);//返回的sid会储存在apply中
	//无法修改，只能撤回（即删除
	
	public void deleteApplyBySid(int sid);
	
	public Apply queryApplyBySid(int sid);//根据sid查询特定某个申请
	
	public List<Apply> queryApplyByBid(int bid);//查询某版区的所有申请
	
	public List<Apply> queryApplyAll();

}
