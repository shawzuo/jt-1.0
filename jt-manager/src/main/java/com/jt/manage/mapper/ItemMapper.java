package com.jt.manage.mapper;

import java.util.List;
import java.util.Map;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.Item;

public interface ItemMapper extends SysMapper<Item> {

	List<Item> findAll();
	
	int findTotalNum();
	
	List<Item> findItemByPage(Map<String,Integer> map);
	
}






