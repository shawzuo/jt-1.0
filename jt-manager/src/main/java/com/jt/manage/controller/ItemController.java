package com.jt.manage.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemServie;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Item> findAll() {
		
		return itemServie.findAll();
	}
	
	//http://localhost:8091/item/query?page=1&rows=20
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult findItemByPage (@PathParam("page") int page, @PathParam("rows") int rows) {
 		EasyUIResult result = new EasyUIResult();
		
		result.setTotal(itemServie.findTotalNum());
		result.setRows(itemServie.findItemByPage(page, rows));
		
		return result;
	}
	
	
}
