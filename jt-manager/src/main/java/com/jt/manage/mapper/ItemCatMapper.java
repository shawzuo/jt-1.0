package com.jt.manage.mapper;

import java.util.Map;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.ItemCat;

public interface ItemCatMapper extends SysMapper<ItemCat>{

	String findItemCatNameById(Map<String,Long> map);
	
	
	
	
}
