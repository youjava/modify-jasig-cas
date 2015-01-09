
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page session="true"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<link href="<s:url value='/assets/css/common.css'/>" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<s:url value='/assets/css/theme/night.css'/>" media="" />

<link href="<s:url value='/assets//css/response.css'/>" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<s:url value='/assets/fontello/css/animation.css'/>" media="" />
<link rel="stylesheet" type="text/css"
	href="<s:url value='/assets/fontello/css/fontello.css'/>" media="" />

<link rel="icon" type="image/x-icon"
	href="<c:url value='/assets/img/logo/icon-16x16.ico'/>" media="screen" />
</head>


<body>

	<!--begin page content-->
	<div class="top">
		<img src="<c:url value='/images/logo-mini.png'/>" alt="" />
	</div>
	<div class="content">
		<!--<a href="#" class="black font18 fr mr80 btn-tab">申请账号<img src="/assets/img/icons/arrow-right.png" alt=""/></a>-->
		<a href="mailto:Media_Account@miaozhen.com?subject=申请账号"
			class="black font18 fr mr50 btn-tab">申请账号<span> </span></a>
		<div class="login-content mt78">
			<div class="color-line">
				<span></span><span></span><span></span>
			</div>
			<div class="input-content center">
				<h2 class="font26 center pt50 black">欢迎登录</h2>
				<%-- <form class="input-bar mt40" action="<s:url value='/login'/>"
					method="post"> --%>
					
				<form:form method="post" id="fm1" cssClass="input-bar mt40 asd" commandName="${commandName}" htmlEscape="true">
					
					
					
					<div class="txt icon-txt">
						<span class="txt-username"><i class="icon-user"></i></span> <input
							type="text" id="username" name="username" placeholder="请输入用户名" />
					</div>
					<div class="txt icon-txt">
						<span class="txt-password"><i class="icon-password"></i></span> <input
							type="password" id="password" name="password" placeholder="请输入密码" />
					</div>

					<a href="mailto:Media_Account@miaozhen.com?subject=忘记密码"
						class="black font14 mt20 fr">忘记密码？</a>

					<div class="row btn-row" style="display: none">
						<input type="hidden" name="lt" value="${loginTicket}" /> <input
							type="hidden" name="execution" value="${flowExecutionKey}" /> <input
							type="hidden" name="_eventId" value="submit" /> <input id="warn"
							name="warn" value="true" tabindex="3"
							accesskey="<spring:message code="screen.welcome.label.warn.accesskey" />"
							type="checkbox" /> <input name="product" value="Default"
							id="product" />
						<form:errors path="*" id="msg" cssClass="errors" element="div" />
					</div>

				</form:form>
				<!--<input type="button" class="btn-big btn-impor ml70 mt20" value="登录"/>-->
				<a href="javascript:void(0)" id="login"
					class="btn-large btn-impor ml80">登录</a>
			</div>

		</div>
	</div>
	<!--end page content-->

	<!--pop-->
	<div class="apply-success-pop" style="display: none">
		<div class="asp-content">
			<i class="icon-ok"></i>登录成功
		</div>
	</div>
	<div class="failure-pop" style="display: none">
		<div class="asp-content">登录失败，用户名或密码错误</div>
	</div>
	<!-- end pop -->

	<script
		src="<c:url value='/assets/plugins/jquery-1.8.2/jquery-1.8.2.min.js'/>"></script>
	<script
		src="<c:url value='/assets/plugins/jquery-ui-1.10.4/ui/minified/jquery-ui.min.js'/>"></script>
	<script
		src="<c:url value='/assets/plugins/bootstrap-3.2.0/js/bootstrap.min.js'/>"></script>
	
	<script
		src="<c:url value='/assets/js/cas-login.js'/>"></script>
	
	<script>
		$(function(){
			LoginModule.init()
		})
	</script>
</body>


</html>