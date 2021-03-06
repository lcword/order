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
		
		$("#module_form").validate({
			rules:{
				name:{
					required:true,
				},
				remark:"required"
			},
			messages:{
				name:"名称不能为空!",
				remark:"描述不能为空!"
			}
			
		});
	});
</script>
</head>
<body>
	<form action="update_module" method="post" id="module_form">
		<table>
			<input type="hidden" name="id" value="${module.id }" />
			<tr>
				<td>名称</td>
				<td><input id="name" name="name" value="${module.name}" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><input id="remark" name="remark" value="${module.remark}" /></td>
			</tr>
		</table>
		<input type="submit" value="确定" />
		<input type="reset" value="重置" />
	</form>
</body>
</html>