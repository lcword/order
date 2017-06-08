<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智能云点餐</title>
<style type="text/css">
	html,body {
	width:100%;
	height:100%;
	}
	table {
		margin: 0 auto;
		width:60%;
	}
	td,th {
		text-align: center;
	}
	a {
		text-decoration: none;
	}
	.picture {
		width:50px;
		height:50px;
	}
	#page_div,#select_div {
		text-align: center;
	}
	.age {
		width:2%;
	}
</style>
<script src="https://code.jquery.com/jquery-3.1.1.js" type="text/javascript"></script>
<script type="text/javascript">
	/* 批量删除 */
	function deleteAll() {
		var a = confirm("确认要删除？");
		if (a) {
			var names = $("input[name='checkbox']");
			var moduleIds = "";
			for (var i = 0; i < names.length; i++) {
				if (names[i].checked == true) {
					moduleIds += names[i].value + ",";
				}
			}
			if (moduleIds != "") {
				moduleIds = moduleIds.substring(0, moduleIds.length - 1);
				window.location.href = "delete_module?id="
						+ moduleIds;
			}
		}
	}
	/* 删除 */
	function deleteAdmin(id){
		var a = confirm("确认要删除？");
		var ids = id;
		if (a) {
			window.location.href = "delete_module?id="+ ids;
		}
	}
	/* 全选 */
	function allCheckbox() {
		var names = $("input[name='checkbox']");
		var allcheckbox = document.getElementById("allcheckbox");
		for (var i = 0; i < names.length; i++) {
			if (allcheckbox.checked == true) {
				names[i].checked = true;
			} else {
				names[i].checked = false;
			}
		}
	}
	/* 根据单个复选框的选择情况确定全选复选框是否被选中 */
	function selectSingle() {
		var k = 0;
		var oInput = document.getElementsByName("checkbox");
		for (var i = 0; i < oInput.length; i++) {
			if (oInput[i].checked == false) {
				k = 1;
				break;
			}
		}
		if (k == 0) {
			document.getElementById("allcheckbox").checked = true;
		} else {
			document.getElementById("allcheckbox").checked = false;
		}
	}
	/*跳转*/
	function turnPage(obj){
		var page = $(obj).val();
		window.location.href = "query_module?type=turn&&curPageStr="+page;
	}
	/*查询全部*/
	function queryAll(){
		window.location.href = "query_module";
	}
	$(function(){
		$("tr:even").css("background","#EEE5DE");
		$("tr:odd").css("background","#8B8682");
		$("tr:first").css("background","green");
	})
</script>
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="1">
		<tr>
			<th>全选<input type="checkbox" id="allcheckbox"
				onclick="allCheckbox()" /></th>
			<th>编号</th>
			<th>名称</th>
			<th>描述</th>
			<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${module_list }" var="module">
			<tr>
				<td><input type="checkbox" name="checkbox"
					onclick="selectSingle();" value="${module.id }" /></td>
				<td>${module.id }</td>
				<td>${module.name }</td>
				<td>${module.remark }</td>
				<td><a href="delete_module?id=${module.id }" onclick="deleteAdmin(${module.id });">删除</a></td>
				<td><a href="pre_update_module?id=${module.id }">修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10" style="background-color: green"><a href="#" onclick="deleteAll();">批量删除</a></td>
		</tr>
	</table>
	<br />
	<div id="page_div">
		<lable>总共${module_page.allCount }条</lable>
		<c:if test="${module_page.curPage > 1 }">
			<a href="query_module?type=turn&&curPageStr=1">首页</a>
			<a href="query_module?type=prePage&&curPageStr=${module_page.curPage }">上一页</a>
		</c:if>
		<c:if test="${module_page.curPage < module_page.maxPage }">
			<a href="query_module?type=nextPage&&curPageStr=${module_page.curPage }">下一页</a>
			<a href="query_module?type=turn&&curPageStr=${module_page.maxPage}">末页</a>
		</c:if>
		当前第<lable id="cur_page">${module_page.curPage }</lable>页
		跳转第<input style="width:15px;" value=""  onchange="turnPage(this);"/>页
		<lable>总共${module_page.maxPage }页</lable>
	</div>
</body>
</html>