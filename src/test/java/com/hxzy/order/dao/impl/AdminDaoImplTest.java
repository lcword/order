package com.hxzy.order.dao.impl;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxzy.order.model.Admin;
import com.hxzy.order.service.intf.AdminService;

public class AdminDaoImplTest {
	private AdminService adminService;
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_core.xml");
		adminService = (AdminService) applicationContext.getBean("adminService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		Admin admin = new Admin("zs","123");
		adminService.add(admin);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryById() {
		fail("Not yet implemented");
	}

	@Test
	public void testExist() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckName() {
		fail("Not yet implemented");
	}

}
