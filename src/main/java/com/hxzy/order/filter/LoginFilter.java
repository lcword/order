package com.hxzy.order.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.order.model.Function;
import com.hxzy.order.service.intf.AdminService;
import com.hxzy.order.util.GetEntity;
/*懒加载可以解决问题，但是会引发lazyInitalizationException*/
public class LoginFilter implements Filter {
	private String noURI;
	private AdminService adminService = GetEntity.getEntity("adminService");

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Object user = req.getSession().getAttribute("login_user");
		String url = req.getRequestURI();
		System.out.println("url: " + url);
		if (noURI != null && !"".equals(noURI)) {
			String[] noURIArray = noURI.split(";");
			for (String string : noURIArray) {
				if (url.endsWith(string)) {
					chain.doFilter(request, response);
					return;
				}
			}
		}
		if (user != null && jurisdiction(req, chain, user, url)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("login");
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		noURI = fConfig.getInitParameter("noURI");
	}

	private boolean jurisdiction(HttpServletRequest req, FilterChain chain, Object loginer,String url) {
		System.out.println(2222);
		// 权限管理
		if(loginer != null){
			System.out.println(3333);
			String id = loginer.toString();
			System.out.println("login_user_id: " + id);
			if (id != null && !id.isEmpty()) {
				System.out.println(4444);
				System.out.println("adminService: " + adminService);
				System.out.println("adminService.queryById(id): " + adminService.queryById(id));
				System.out.println("adminService.queryById(id).getRole(): " + adminService.queryById(id).getRole());
				Set<Function> set = adminService.queryById(id).getRole().getSet();
				for (Function function : set) {
					System.out.println(function.getCode());
					if (url.endsWith(function.getCode())) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
