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
		
		$("#function_form").validate({
			rules:{
				code:{
					required:true,
				},
				remark:"required"
			},
			messages:{
				code:"用户名不能为空!",
				remark:"密码不能为空!"
			}
			
		});
	});
</script>
</head>
<body>
	<form action="update_function" method="post" id="function_form">
		<table>
			<input type="hidden" name="id" value="${function.id }" />
			<tr>
				<td>代码块</td>
				<td><input id="code" name="code" value="${function.code}" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><input id="remark" name="remark" value="${function.remark}" /></td>
			</tr>
			<tr>
				<td>模块</td>
				<td>
					<select>
						<option value="${function.module.id}">${function.module.name}</option>
						<%-- <c:forEach items="module_list" var="module">
							<option value="${module.id }">${module.name}</option>
						</c:forEach> --%>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="确定" />
		<input type="reset" value="重置" />
	</form>
</body>
</html>