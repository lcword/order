<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>智能云点餐</title>
<link rel="stylesheet" href="./static/css/pintuer.css">
<link rel="stylesheet" href="./static/css/admin.css">
<script src="./static/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$(".leftnav h2").click(function() {
			$(this).next().slideToggle(200);
			$(this).toggleClass("on");
		})
		$(".leftnav ul li a").click(function() {
			$("#a_leader_txt").text($(this).text());
			$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
		})
	});
	if (self != top) {
		top.location = self.location;  //iframe中窗口对象转换成父窗口对象
	}
</script>
</head>
<body>

	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="./static/images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />智能云点餐
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-red" href="logout"> <span
				class="icon-power-off"> </span> 退出登录
			</a>
		</div>
	</div>

	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-pencil-square-o"></span>操作员管理
		</h2>
		<ul style="display: block">
			<li><a href="query_admin" target="right"><span
					class="icon-caret-right"></span>操作员信息</a></li>
			<li><a href="pre_add_admin" target="right"><span
					class="icon-caret-right"></span>添加操作员</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>角色管理
		</h2>
		<ul style="display: block">
			<li><a href="query_role" target="right"><span
					class="icon-caret-right"></span>角色信息</a></li>
			<li><a href="pre_add_role" target="right"><span
					class="icon-caret-right"></span>添加角色</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>功能管理
		</h2>
		<ul style="display: block">
			<li><a href="query_function" target="right"><span
					class="icon-caret-right"></span>功能信息</a></li>
			<li><a href="pre_add_function" target="right"><span
					class="icon-caret-right"></span>添加功能</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>模块管理
		</h2>
		<ul style="display: block">
			<li><a href="query_module" target="right"><span
					class="icon-caret-right"></span>模块信息</a></li>
			<li><a href="pre_add_module" target="right"><span
					class="icon-caret-right"></span>添加模块</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>会员管理
		</h2>
		<ul>
			<li><a href="query_member" target="right"><span
					class="icon-caret-right"></span>会员信息</a></li>
			<li><a href="query_card" target="right"><span
					class="icon-caret-right"></span>会员卡信息</a></li>
		</ul>
		<h2>
			<span class="icon-user"></span>点餐
		</h2>
		<ul>
			<li><a href="query_kind" target="right"><span
					class="icon-caret-right"></span>种类</a></li>
			<li><a href="query_dish" target="right"><span
					class="icon-caret-right"></span>菜品</a></li>
		</ul>
	</div>

	<div class="rightContent">
		<ul class="bread">
			<!-- {:U('Index/info')} -->
			<li><a href="./info.html" target="right" class="icon-home">
					首页</a></li>
			<li><a href="" id="a_leader_txt">网站信息</a></li>
		</ul>
		<div class="admin">
			<iframe scrolling="auto" rameborder="0" src="./info.html"
				name="right" width="100%" height="100%"></iframe>
		</div>
	</div>

</body>
</html>