package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.ModuleDao;
import com.hxzy.order.model.Module;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.ModuleService;

@Service("moduleServcie")
public class ModuleServiceImpl implements ModuleService{
	@Autowired
	private ModuleDao moduleDao;
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		moduleDao.delete(ids);
	}

	@Override
	public void update(Module module) {
		if(module.getId() == null || module.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = moduleDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			module.setId("M" + date + String.valueOf(count));
			moduleDao.add(module);
		}else{
			/*修改*/
			moduleDao.update(module);
		}
	}

	@Override
	public List<Module> query(Page page) {
		return moduleDao.query(page);
	}

	@Override
	public Module queryById(String id) {
		return moduleDao.queryById(id);
	}

}
