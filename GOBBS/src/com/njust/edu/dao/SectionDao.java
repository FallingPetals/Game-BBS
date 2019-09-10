package com.njust.edu.dao;

import com.njust.edu.pojo.*;

import java.util.List;

public interface SectionDao {
	
	public void insertSection(Section section);//只有这里没有自增属性，所有属性都要手动输入，即bid不会自动生成
	
	public void updateSectionByBid(Section section);//能修改section_name,section_type,headline
	
	public void updateSectionBySectionName(Section section);//不能修改section_name,只能修改section_type,headline
	
	public void deleteSectionByBid(int bid);
	
	public void deleteSectionBySectionName(String section_name);
	
	public Section querySectionByBid(int bid);//根据版块编号查询
	
	public Section querySectionBySectionName(String section_name);//根据板块名字查询
	
	public List<Section> querySectionAll();

}
