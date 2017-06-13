<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值信息</title>
<style type="text/css">
	.error,span {
		color:red;
	}
	lable {
		color:red;
		font-size:20px
	}
</style>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>会员</td>
			<td><lable>${member.name}</lable></td>
		</tr>
		<tr>
			<td>等级</td>
			<td><lable>${member.card.name}</lable></td>
		</tr>
		<tr>
			<td>充值金额</td>
			<td><lable>${money}</lable></td>
		</tr>
		<tr>
			<td>当前余额</td>
			<td><lable>${member.balance}</lable></td>
		</tr>
		<tr>
			<td>获赠积分</td>
			<td><lable>${integral}</lable></td>
		</tr>
		<tr>
			<td>当前积分</td>
			<td><lable>${member.integral}</lable></td>
		</tr>
		<tr>
			<td>操作时间</td>
			<td><lable>${time}</lable></td>
		</tr>
		<tr>
			<td>操作员</td>
			<td><lable>${admin}</lable></td>
		</tr>
	</table>
</body>
</html>