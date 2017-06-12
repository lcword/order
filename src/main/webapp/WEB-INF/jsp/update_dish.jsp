<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新菜品信息</title>
<style type="text/css">
	.error,span {
		color:red;
	}
</style>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#dish_form").validate({
			rules:{
				name:{
					required:true,
				},
				price:{
					required:true,
					range:[0,10000]
				},
				kindId:"required"
			},
			messages:{
				name:"名称不能为空!",
				price:{
					required:"价格不能为空!",
					range:"请输入合理价格!"
				},
				kindId:"菜品类型不能为空!"
			}
			
		});
	});
</script>
</head>
<body>
	<form action="update_dish" method="post" id="dish_form">
		<table>
			<input type="hidden" name="id" value="${dish.id }" />
			<tr>
				<td>名称</td>
				<td><input id="name" name="name" value="${dish.name}" /></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input id="price" name="price" value="${dish.price}" /></td>
			</tr>
			<tr>
				<td>状态</td>
				<td>
					<select name="status">
						<option value="0" name="status">精品菜</option>
						<c:if test="${dish.status == 1}">
							<option value="1" name="status" selected="selected">特色菜</option>
						</c:if>
						<c:if test="${dish.status != 1}">
							<option value="1" name="status">特色菜</option>
						</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<td>图片</td>
				<td>
					<c:if test="${!empty dish.picture}">
						<img src="./picture/${dish.picture}" class="picture" />
					</c:if>
					<input type="file" name="picture" />
				</td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea name="remark" value="${dish.remark}"></textarea></td>
			</tr>
			<tr>
				<td>类型</td>
				<td>
					<select name="kindId">
						<option value="${dish.kind.id}">${dish.kind.name}</option>
						<c:forEach items="${kind_list }" var="kind">
							<option value="${kind.id }">${kind.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="确定" />
		<input type="reset" value="重置" />
	</form>
</body>
</html>