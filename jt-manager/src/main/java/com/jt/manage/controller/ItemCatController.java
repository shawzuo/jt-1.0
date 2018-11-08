package com.jt.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.pojo.ItemCat;
import com.jt.manage.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
//	@Autowired
//	private HttpServletResponse response;
	
	@Autowired
	private ItemCatService itemCatService;
	///item/cat/queryItemCatName /
	
	@RequestMapping("/queryItemCatName")
	@ResponseBody
	public void queryItemCatName(long itemCatId, HttpServletResponse response) {
		String name = itemCatService.findItemCatNameById(itemCatId);
		
//		response.setCharacterEncoding("utf-8");
//		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public List<ItemCat> findItemCat(@RequestParam(value="id",defaultValue="0") Long parentId) {
		List<ItemCat> itemCatList = itemCatService.findItemCatByParntId(parentId);
		return itemCatList;
	}
	
	 
	
	
	
	
	
	
	
}
