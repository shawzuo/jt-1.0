package com.jt.manage.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;

@Repository
public class ItemDao {

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private ItemDescMapper itemDescMapper;
	
	
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

	public int saveItem(Item item,String desc) {
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		int num = itemMapper.insert(item);
		
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getCreated());
		itemDescMapper.insert(itemDesc);
		
		return num;
	}

	public void updateItem(Item item, String desc) {
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKeySelective(item);
		
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setUpdated(item.getUpdated());
		itemDesc.setItemDesc(desc);
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
	}

	public int deleteItems(Long[] ids) {
		itemMapper.deleteByIDS(ids);
		return itemDescMapper.deleteByIDS(ids);
	}


	public int updateItemStatus(Long[] ids, int status) {
		return itemMapper.updataItemStatus(ids, status);
	}

	public ItemDesc findItemDesc(Long itemId) {
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(itemId);
		return itemDescMapper.selectByPrimaryKey(itemDesc);
	}
	
	
	
	
	
}
