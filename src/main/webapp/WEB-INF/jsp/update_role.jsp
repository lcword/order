<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新角色信息</title>
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
		
		$("#role_form").validate({
			rules:{
				name:{
					required:true,
				},
				functionId:"required"
			},
			messages:{
				name:"角色名称不能为空!",
				functionId:"请选择至少一个功能"
			}
			
		});
	});
</script>
</head>
<body>
	<form action="update_role" method="post" id="role_form">
		<table>
			<input type="hidden" name="id" value="${role.id }" />
			<tr>
				<td>名称</td>
				<td><input id="name" name="name" value="${role.name}" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><input id="remark" name="remark" value="${role.remark}" /></td>
			</tr>
			<tr>
				<td>功能</td>
				<td>
					<c:forEach items="${function_list}" var="function">
						<c:set var="flag" value="1"></c:set>
						<c:forEach items="${role.set}" var="r_function">
							<c:if test="${function.id == r_function.id}">
								<input type="checkbox" value="${function.id}" checked="checked" name="functionId">${function.code}</input>
								<c:set var="flag" value="0"></c:set>
							</c:if>
						</c:forEach>
						<c:if test="${flag == 1}">
							<input type="checkbox" value="${function.id}" name="functionId">${function.code}</input>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		</table>
		<input type="submit" value="确定" />
		<input type="reset" value="重置" />
	</form>
</body>
</html>