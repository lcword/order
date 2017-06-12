package com.hxzy.order.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hxzy.order.model.Dish;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.DishService;
import com.hxzy.order.service.intf.KindService;

@Controller
public class DishController {
	@Autowired
	private DishService dishService;
	@Autowired
	private KindService kindService;
	
	@RequestMapping("pre_add_dish")
	public String pre_add(Map<String,Object> map) {
		map.put("kind_list",kindService.query(new Page(1,1)));
		return "update_dish";
	}

	@RequestMapping("pre_update_dish")
	public String pre_update(Dish dish,Map<String,Object> map) {
		map.put("kind_list",kindService.query(new Page(1,1)));
		map.put("dish", dishService.queryById(dish.getId()));
		return "update_dish";
	}

	@PostMapping("update_dish")
	public String update(Dish dish,String kindId,@RequestParam("picture_name") MultipartFile picture,HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/static/picture");
		System.out.println(path);
		if(picture != null && picture.getSize() > 0){
			String name = String.valueOf(new Date().getTime()) + ".png";
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
			File saveFile = new File(file, name);
			try {
				picture.transferTo(saveFile);
				dish.setPicture(name);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dishService.update(dish,kindId,path);
		return "redirect:query_dish";
	}

	@RequestMapping("delete_dish")
	public String delete(String id) {
		dishService.delete(id);
		return "redirect:query_dish";
	}

}
