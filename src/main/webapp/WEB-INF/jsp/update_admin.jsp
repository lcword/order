<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新操作员信息</title>
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
		
		$("#admin_form").validate({
			rules:{
				username:{
					required:true,
				},
				password:"required",
				roleId:"required"
			},
			messages:{
				username:"用户名不能为空!",
				password:"密码不能为空!",
				roleId:"请设定角色!"
			}
			
		});
		$("#username").blur(function(){
			 $.ajax({
				url:"check_username",
				data:"username=" + $(this).val(),
				dataType:"json",
				success:function(result){
					if(result.message == "yes"){
						$("span").empty();
						$("#username").after("<span>用户名已存在!</span>");
					}else{
						$("span").empty();
					}
				}
			}); 
		});
	});
</script>
</head>
<body>
	<form action="update_admin" method="post" id="admin_form">
		<table>
			<input type="hidden" name="id" value="${admin.id }" />
			<tr>
				<td>姓名</td>
				<td><input id="name" name="name" value="${admin.name}" /></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input id="username" name="username" value="${admin.username}" /></td>
			</tr>
			<tr> 
				<td>密码</td>
				<td><input type="password" name="password" value="${admin.password}" /></td>
			</tr>
			<tr>
				<td>角色</td>
				<td>
					<select name="roleId">
						<option value="${admin.role.id}">${admin.role.name}</option>
						<c:forEach items="${role_list }" var="role">
							<option value="${role.id }">${role.name}</option>
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