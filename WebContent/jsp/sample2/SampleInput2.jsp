<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html xhtml="true" lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入力画面</title>
<link rel="stylesheet" type="text/css" href="./css/example.css" />
<link rel="stylesheet" href="./css/skyblue.css" />
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="./css/helper.css" />
</head>

<body>
<div class="text-center">登録内容を入力してください。</div>
	<html:form action="/input2">
		<html:errors />

		<table>
			<tr>
				<th>ログインID</th>
				<bean:parameter id="loginId" name="loginId" value="" />
				<td><html:text property="loginId" value="<%=loginId%>"
						size="16" /></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><html:password property="password" size="16" /></td>
			</tr>
			<tr>
				<th>ユーザーネーム</th>
				<bean:parameter id="userName" name="userName" value="" />
				<td><html:text property="userName" value="<%=userName%>"
						size="16" /></td>
			</tr>
			<tr>
				<th>アイコン</th>
				<bean:parameter name="icon" id="icon" value="" /><%=icon %>
				<td><html:select property="icon">
						<html:option value="pe-7s-user">male</html:option>
						<html:option value="pe-7s-user-female" >female</html:option>
					</html:select></td>
			</tr>
			<tr>
				<th>プロフィール</th>
				<bean:parameter id="profile" name="profile" value="" />
				<td><html:text property="profile" value="<%=profile%>"
						size="16" /></td>
			</tr>
		</table>
		<br>
		<br>
		<div class="text-center">
		<html:submit property="btn">
			<bean:message key="button.submit" />
		</html:submit>
		<html:cancel value="Cancel" />
		</div>
	</html:form>
</body>
</html:html>