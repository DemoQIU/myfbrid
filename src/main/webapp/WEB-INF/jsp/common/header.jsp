<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/basejs.jsp" %>
</head>
<body id="">
	<div class="container">
	   <div class="row">
	      <div class="col-md-12">
	      	<div class="col-md-4">
	      		<shiro:authenticated>
	      			<div>
	      				<a href="javascript:void(0)">飞鸟阁下</a>
	      			</div>
	      			<span class="whitespace"></span>
	      		</shiro:authenticated>
	      		<shiro:guest>
		      		<div>
		      			<a href="/login" >亲，请登录</a>
		      		</div>
		      		<span class="whitespace"></span>
		      		<div>
		      			<a href="javascript:void(0)">免费注册</a>
		      		</div>
	      		</shiro:guest>
	      		<!-- hidden div -->
	      		<div class="hidden-class">
	      			
	      		</div>
	      	</div>
	      	<div class="col-md-8"></div>
	      </div>
	   </div>
	</div>
</body>
</html>