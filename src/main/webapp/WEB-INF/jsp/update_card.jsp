<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新会员卡信息</title>
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
		
		$("#card_form").validate({
			rules:{
				level:{
					required:true,
				}
			},
			messages:{
				level:"请选择一个会员卡等级!",
			}
			
		});
	});
</script>
</head>
<body>
	<form action="update_card" method="post" id="card_form">
		<table>
			<input type="hidden" name="id" value="${card.id }" />
			<tr>
				<td>等级</td>
				<td>
					<select name="level">
						<option value="${card.level }">${card.name }</option>
						<c:if test="${card.level != 6}">
							<option value="6">黄铜</option>
						</c:if>
						<c:if test="${card.level != 5}">
							<option value="5">白银</option>
						</c:if>
						<c:if test="${card.level != 4}">
							<option value="4">黄金</option>
						</c:if>
						<c:if test="${card.level != 3}">
							<option value="3">铂金</option>
						</c:if>
						<c:if test="${card.level != 2}">
							<option value="2">钻石</option>
						</c:if>
						<c:if test="${card.level != 1}">
							<option value="1">至尊</option>
						</c:if>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="确定" />
		<input type="reset" value="重置" />
	</form>
</body>
</html>