package com.jt.manage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;

@Repository
public class ItemDao {

	@Autowired
	private ItemMapper itemMapper;
	
	public List<Item> findAll() {
		return itemMapper.findAll();
	}
	
	public int findTotalNum() {
		return itemMapper.findTotalNum();
	}
	
	public List<Item> findItemByPage(int pageNo, int pageSize) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		pageSize = pageSize < 0 || pageSize >50 ? 20 : pageSize;
		int begin = pageNo < 1 ? 1 : (pageNo-1)*pageSize;
		map.put("begin", begin);
		map.put("pageSize", pageSize);
		return itemMapper.findItemByPage(map);
	}
	
	
	
}
