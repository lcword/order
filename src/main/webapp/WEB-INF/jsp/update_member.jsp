<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新会员信息</title>
<style type="text/css">
	.error,span {
		color:red;
	}
	.picture {
		width:50px;
		height:50px;
	}
</style>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#member_form").validate({
			rules:{
				name:{
					required:true,
				},
				phone:"required",
				cardId:"required"
			},
			messages:{
				name:"名称不能为空!",
				phone:"电话不能为空!",
				cardId:"会员卡不能为空!"
			}
			
		});
	});
</script>
</head>
<body>
	<form action="update_member" method="post" id="member_form">
		<table>
			<input type="hidden" name="id" value="${member.id }" />
			<tr>
				<td>姓名</td>
				<td><input id="name" name="name" value="${member.name}" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input name="phone" value="${member.phone}" /></td>
			</tr>
			<tr>
				<td>会员卡</td>
				<td>
					<select name="cardId">
						<option value="${member.card.id}">${member.card.name}</option>
						<c:forEach items="${card_list }" var="card">
							<option value="${card.id }">${card.name }</option>
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