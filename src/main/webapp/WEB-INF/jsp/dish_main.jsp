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
			var dishIds = "";
			for (var i = 0; i < names.length; i++) {
				if (names[i].checked == true) {
					dishIds += names[i].value + ",";
				}
			}
			if (dishIds != "") {
				dishIds = dishIds.substring(0, dishIds.length - 1);
				window.location.href = "delete_dish?id="
						+ dishIds;
			}
		}
	}
	/* 删除 */
	function deleteKind(id){
		var a = confirm("确认要删除？");
		var ids = id;
		if (a) {
			window.location.href = "delete_dish?id="+ ids;
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
		window.location.href = "query_dish?type=turn&&curPageStr="+page;
	}
	/*查询全部*/
	function queryAll(){
		window.location.href = "query_dish";
	}
	$(function(){
		$("tr:even").css("background","#EEE5DE");
		$("tr:odd").css("background","#8B8682");
		$("tr:first").css("background","green");
	})
</script>
</head>
<body>
	<a href="pre_add_dish" >[添加菜品]</a>
	<table cellpadding="0" cellspacing="0" border="1">
		<tr>
			<th>全选<input type="checkbox" id="allcheckbox"
				onclick="allCheckbox()" /></th>
			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
			<th>状态</th>
			<th>图片</th>
			<th>描述</th>
			<th>类型</th>
			<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${dish_list }" var="dish">
			<tr>
				<td><input type="checkbox" name="checkbox"
					onclick="selectSingle();" value="${dish.id }" /></td>
				<td>${dish.id }</td>
				<td>${dish.name }</td>
				<td>${dish.price }</td>
				<td>
					<c:if test="${dish.status == 1}">特色菜</c:if>
					<c:if test="${dish.status != 1}">精品菜</c:if>
				</td>
				<td><img src="./picture/${dish.picture}" alt="待添加图片" class="picture" /></td>
				<td>${dish.remark }</td>
				<td>${dish.kind.name }</td>
				<td><a href="delete_dish?id=${dish.id }" onclick="deleteKind(${dish.id });">删除</a></td>
				<td><a href="pre_update_dish?id=${dish.id }">修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10" style="background-color: green"><a href="#" onclick="deleteAll();">批量删除</a></td>
		</tr>
	</table>
	<br />
	<div id="page_div">
		<lable>总共${dish_page.allCount }条</lable>
		<c:if test="${dish_page.curPage > 1 }">
			<a href="query_dish?type=turn&&curPageStr=1">首页</a>
			<a href="query_dish?type=prePage&&curPageStr=${dish_page.curPage }">上一页</a>
		</c:if>
		<c:if test="${dish_page.curPage < dish_page.maxPage }">
			<a href="query_dish?type=nextPage&&curPageStr=${dish_page.curPage }">下一页</a>
			<a href="query_dish?type=turn&&curPageStr=${dish_page.maxPage}">末页</a>
		</c:if>
		当前第<lable id="cur_page">${dish_page.curPage }</lable>页
		跳转第<input style="width:15px;" value=""  onchange="turnPage(this);"/>页
		<lable>总共${dish_page.maxPage }页</lable>
	</div>
</body>
</html>