package com.hxzy.order.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Admin;
import com.hxzy.order.service.intf.AdminService;

@Controller
public class LoginController {
	@Autowired
	private AdminService adminService;

	@RequestMapping("/login")
	public String login(Admin admin,HttpServletRequest request,HttpServletResponse response) {
		if (adminService.exist(admin) != null) {
			request.getSession().setAttribute("login_user", admin.getUsername());
			Cookie usernameCookie = new Cookie("login_username", admin.getUsername());
			Cookie passwordCookie = new Cookie("login_password", admin.getPassword());
			usernameCookie.setMaxAge(60 * 60);
			passwordCookie.setMaxAge(60 * 60);
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
			return "redirect:index";
		} else {
			Cookie[] cookies = request.getCookies();
			String login_username = "";
			String login_password = "";
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if ("login_username".equals(cookie.getName())) {
						login_username = cookie.getValue();
					}
					if ("login_password".equals(cookie.getName())) {
						login_password = cookie.getValue();
					}
				}
			}

			admin = new Admin(login_username, login_password);
			if (adminService.exist(admin) != null) {
				request.getSession().setAttribute("login_user", login_username);
				return "redirect:index";
			}
		}
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletResponse response) {
		Cookie usernameCookie = new Cookie("login_username", null);
		Cookie passwordCookie = new Cookie("login_password", null);
		usernameCookie.setMaxAge(0);
		passwordCookie.setMaxAge(0);
		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);
		return "redirect:login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
