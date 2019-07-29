<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html xhtml="true" lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sample form using ActionForm</title>
<html:base />
<link rel="stylesheet" type="text/css" href="./css/skyblue.css" />
<link rel="stylesheet" type="text/css" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" type="text/css" href="./css/helper.css" />
</head>
<body>

	<p>Fill the form below.</p>
	* is required field.
	<hr />

	<html:form action="/input">
		<p>
			<!-- 名前入力欄 -->
			* What's your name?<br />
			<logic:notEmpty name="userName">
				<bean:parameter id="name" name="userName" />
				<html:text property="userName" size="40" maxlength="64"
					value="<%=name%>" />
			</logic:notEmpty>
			<html:text property="userName" size="40" maxlength="64" />
			<!-- エラーがあれば表示 -->
			<html:errors property="userName" />
		</p>
		<p>
			<!-- ログインID入力欄 -->
			* Input Login ID.<br />
			<logic:notEmpty name="loginId">
				<bean:parameter id="ID" name="loginId" />
				<html:text property="loginId" size="40" maxlength="32"
					value="<%=ID%>" />
			</logic:notEmpty>
			<html:text property="loginId" size="40" maxlength="32" />
			<!-- エラーがあれば表示 -->
			<html:errors property="loginId" />
		</p>
		<p>
			<!-- パスワード入力欄 -->
			* Input password.<br />
			<logic:notEmpty name="password">
				<bean:parameter id="pass" name="password" />
				<html:password redisplay="false" property="password" size="40"
					maxlength="32" value="<%=pass%>" />
			</logic:notEmpty>
			<html:password redisplay="false" property="password" size="40"
				maxlength="32" />
			<!-- エラーがあれば表示 -->
			<html:errors property="password" />
		</p>
		<p>
			<!-- アイコン選択 -->
			Select your icon.<br />
			<html:select property="icon">
				<option value="icon-user">male</option>
				<option value="icon-user-female">female</option>
				<option value="icon-magic-wand">wand</option>
				<option value="icon-plugin">plugin</option>
				<option value="icon-rocket">rocket</option>
				<option value="icon-smile">smile</option>
				<option value="icon-wine">wine</option>
				<option value="icon-cash">cash</option>
				<option value="icon-gym">gym</option>
				<option value="icon-diamond">diamond</option>
				<option value="icon-star">star</option>
				<option value="icon-science">science</option>
				<option value="icon-film">film</option>
				<option value="icon-plane">plane</option>
				<option value="icon-joy">joy</option>
			</html:select>
		</p>
		<p>
			<!-- プロフィール入力欄 -->
			Input your profile.<br />
			<logic:notEmpty name="profile">
				<bean:parameter id="profile" name="profile" />
				<html:textarea property="profile" cols="20" rows="10"
					value="<%=profile%>" />
			</logic:notEmpty>
			<html:textarea property="profile" cols="20" rows="10" />
			<!-- エラーがあれば表示 -->
			<html:errors property="profile" />
		</p>

		<hr />
		<p>
			<html:cancel>
				<bean:message key="button.cancel" />
			</html:cancel>
			<html:submit>
				<bean:message key="button.confirm" />
			</html:submit>
		</p>
	</html:form>

</body>
</html:html>