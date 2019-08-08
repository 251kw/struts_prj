<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html xhtml="true" lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
<link rel="stylesheet" type="text/css" href="./css/example.css" />
<link rel="stylesheet" href="./css/skyblue.css" />
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="./css/helper.css" />
</head>
<body>
	<div class="text-center">検索条件を入力してください。</div>
	<html:form action="/Search2">
		<table class="table">
			<tr>
				<th>ログインID</th>
				<td><html:text property="loginId" size="16" />
				<td>
			</tr>
			<tr>
				<th>ユーザーネーム</th>
				<td><html:text property="userName" size="16" /></td>
			</tr>
			<tr>
				<th>アイコン</th>
				<td><html:select property="icon" value="">
						<html:option value="">アイコンを選択</html:option>ｓｓ
						<html:option value="pe-7s-user">male</html:option>
						<html:option value="pe-7s-user-female">female</html:option>
					</html:select></td>
			</tr>
			<tr>
				<th>プロフィール</th>
				<td><html:text property="profile" size="16" /></td>
			</tr>
		</table>
		<html:submit property="btn">
			<bean:message key="button.submit" />
		</html:submit>
		<html:submit property="btn">
			<bean:message key="button.cancel" />
		</html:submit>
	</html:form>
</body>
</html:html>