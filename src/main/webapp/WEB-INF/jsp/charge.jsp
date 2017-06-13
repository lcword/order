<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员充值</title>
<style type="text/css">
	.error,span {
		color:red;
	}
	lable {
		color:red;
		font-size:22px
	}
</style>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
	$(function(){
		$("#money_form").validate({
			rules:{
				money:{
					required:true,
					digits:true
				}
			},
			messages:{
				money:{
					required:"充值金额不能为空！",
					digits:"请输入正确的金额！"
				}
			}
			
		});
	});
</script>
</head>
<body>
	<form action="charge" method="post" id="money_form">
		<table>
			<input type="hidden" name="id" value="${id }" />
			<tr>
				<td>充值金额</td>
				<td><input id="money" name="money" value="" /></td>
			</tr>
		</table>
		<input type="submit" value="确定" />
		<input type="reset" value="重置" />
	</form><br/><br/>
	充值每满<lable>100</lable>元，赠送<lable>1</lable>积分<br/><br/><br/>
	
	充值满<lable>500</lable>元，成为<lable>青铜会员</lable>，享<lable>9</lable>折优惠<br/>
	充值满<lable>1500</lable>元，成为<lable>白银会员</lable>，享<lable>8</lable>折优惠<br/>
	充值满<lable>5000</lable>元，成为<lable>黄金会员</lable>，享<lable>7</lable>折优惠<br/>
	充值满<lable>10000</lable>元，成为<lable>铂金会员</lable>，享<lable>6</lable>折优惠<br/>
	充值满<lable>100000</lable>元，成为<lable>钻石会员</lable>，享<lable>5</lable>折优惠<br/>
	充值满<lable>1000000</lable>元，成为<lable>至尊会员</lable>，享<lable>4</lable>折优惠<br/>
</body>
</html>