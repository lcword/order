//package com.hxzy.order.dao.impl;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.hxzy.order.dao.intf.FunctionDao;
//import com.hxzy.order.model.Function;
//import com.hxzy.order.page.Page;
//import com.hxzy.order.service.intf.FunctionService;
//
//public class FunctionDaoImplTest {
//
//	private FunctionService functionService;
//	@Before
//	public void setUp() throws Exception {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_core.xml");
//		functionService = (FunctionService) applicationContext.getBean("functionServcie");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testQuery() {
//		List<Function> functions = functionService.query(new Page<>(1, 1));
//		for(Function f:functions){
//			System.out.println(f);
//		}
//		
//	}
//
//	@Test
//	public void testQueryById() {
//		
//	}
//
//}
