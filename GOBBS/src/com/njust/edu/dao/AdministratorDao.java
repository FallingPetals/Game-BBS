package com.njust.edu.dao;

import com.njust.edu.pojo.*;
import java.util.List;

public interface AdministratorDao {
	public void insertAdministrator(Administrator administrator);//����
	
	public void updateAdminstartorLoseDateByUid(Administrator administrator);//administrator�е�uid����Ҫ�޸ĵ�administrator����һ���uid
	
	public void updateAdminstartorLoseDateByAid(Administrator administrator);//administrator�е�aid����Ҫ�޸ĵ�administrator����һ���aid
	
	public void deleteAdminstartorByUid(int uid);
	
	public void deleteAdminstartorByAid(int aid);
	
	public List<Administrator> queryAdministratorAll();//��ѯ����
	
	public Administrator queryAdministratorByUid(int uid);//ͨ��uid��ѯ
	
	public Administrator queryAdministratorByAid(int aid);//ͨ��aid��ѯ
}
