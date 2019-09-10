package com.njust.edu.dao;

import com.njust.edu.pojo.*;
import java.util.List;

public interface AdministratorDao {
	public void insertAdministrator(Administrator administrator);//插入
	
	public void updateAdminstartorLoseDateByUid(Administrator administrator);//administrator中的uid是需要修改的administrator的那一组的uid
	
	public void updateAdminstartorLoseDateByAid(Administrator administrator);//administrator中的aid是需要修改的administrator的那一组的aid
	
	public void deleteAdminstartorByUid(int uid);
	
	public void deleteAdminstartorByAid(int aid);
	
	public List<Administrator> queryAdministratorAll();//查询所有
	
	public Administrator queryAdministratorByUid(int uid);//通过uid查询
	
	public Administrator queryAdministratorByAid(int aid);//通过aid查询
}
