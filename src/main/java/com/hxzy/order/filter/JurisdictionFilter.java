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

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.hxzy.order.model.Function;
import com.hxzy.order.service.intf.AdminService;


@Component
public class JurisdictionFilter implements Filter,ApplicationContextAware{
	private AdminService adminService;
	private String noURI;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = ((HttpServletRequest)request);
		String uri = req.getRequestURI();
		if(noURI != null && !"".equals(noURI)){
			String[] noURIArray = noURI.split(";");
			for (String string : noURIArray) {
				if(uri.endsWith(string)){
					chain.doFilter(request, response);
					return;
				}
			}
		}
		
		//权限管理
		String id = req.getSession().getAttribute("login_user").toString();
		System.out.println("adminService" + adminService);
		if(id != null && !id.isEmpty()){
			String url = req.getRequestURL().toString();
			Set<Function> set = adminService.queryById(id).getRole().getSet();
			for (Function function : set) {
				if(url.endsWith(function.getCode())){
					chain.doFilter(request, response);
					return;
				}
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		noURI = fConfig.getInitParameter("noURI");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		adminService = (AdminService) applicationContext.getBean("adminService");
	}
	
}
