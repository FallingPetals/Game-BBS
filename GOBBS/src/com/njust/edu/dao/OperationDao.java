package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface OperationDao {
	
	public void insertOperation(Operation operation);
	
	public Operation queryOperationByCid(int cid);
	
	public List<Operation> queryOperationByIp(String ip);
	
	public List<Operation> queryOperationByDate(String operation_date);
	
	public List<Operation> queryOperationAll();

}
