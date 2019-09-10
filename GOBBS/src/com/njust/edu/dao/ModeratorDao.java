package com.njust.edu.dao;

import com.njust.edu.pojo.*;
import java.util.List;

public interface ModeratorDao {
	public void insertModerator(Moderator moderator);//插入
	
	public void updateModeratorLoseDateByUid(Moderator moderator);//moderator中的uid是需要修改的moderator的那一组的uid
	
	
	public void deleteModeratorByUid(int uid);
	
	public List<Moderator> queryModeratorAll();//查询所有
	
	public Moderator queryModeratorByUid(int uid);//通过uid查询
	
	public Moderator queryModeratorByBid(int bid);//通过bid查询

}
