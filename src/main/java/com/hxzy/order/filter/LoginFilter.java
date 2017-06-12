package com.hxzy.order.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hxzy.order.model.Admin;
import com.hxzy.order.model.Function;
import com.hxzy.order.model.Role;
import com.hxzy.order.service.intf.AdminService;
import com.hxzy.order.util.GetEntity;

public class LoginFilter implements Filter {
	private AdminService adminService = GetEntity.getEntity("adminService");
	private String[] nouriArray;

	public void init(FilterConfig config) {
		String nouriStr = config.getInitParameter("noURI");
		nouriArray = nouriStr.split(";");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter >>>");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Object user = req.getSession().getAttribute("login_user");
		String uri = req.getRequestURI();
		System.out.println("uri: "+uri);
		System.out.println("不过滤： "+Arrays.toString(nouriArray));
		boolean flag = true;
		for (String nouri : nouriArray) {
			System.out.println(uri+"="+nouri+": " + uri.endsWith(nouri));
			if(uri.endsWith(nouri)){
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("需要认证  >>>");
			if (user == null) {
				System.out.println("user 为空");
				resp.sendRedirect("login");
				return;
			}
//			if (!getPermission(req, user, uri)) {
//				System.out.println("权限不足");
//				resp.sendRedirect("login");
//				return;
//			}
		}
		System.out.println("filter >>> 放行");
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

	private boolean getPermission(HttpServletRequest request, Object user, String uri) {
		String loginerId = user.toString();
		Admin admin = adminService.queryById(loginerId);
		Role role = admin.getRole();
		Set<Function> set = role.getSet();
		Iterator<Function> itor = set.iterator();
		while (itor.hasNext()) {
			Function function = itor.next();
			System.out.println("代码： "+function.getCode());
			if (uri.endsWith(function.getCode())) {
				return true;
			} 
		}
		return false;
	}

}
