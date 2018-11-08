package com.jt.manage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;

@Repository
public class ItemCatDao {

	@Autowired
	private ItemCatMapper itemCatMapper;
	
	public String findItemCatNameById(Long itemCatId) {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("itemCatId", itemCatId);
		return itemCatMapper.findItemCatNameById(map);
		
	}

	public List<ItemCat> findItemCatByParntId(Long parentId) {
		ItemCat itemCat = new ItemCat();
		itemCat.setParentId(parentId);
		itemCat.setStatus(1);
		return itemCatMapper.select(itemCat);
	}
	
	
	
}
