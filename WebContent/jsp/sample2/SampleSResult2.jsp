<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="sample2.UserBean2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html xhtml="true" lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果画面</title>
<link rel="stylesheet" type="text/css" href="./css/example.css" />
<link rel="stylesheet" href="./css/skyblue.css" />
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="./css/helper.css" />
</head>
<body>
<div class="text-center">検索結果は以下の通りです。</div>
	<logic:present name="Suser" scope="request">
		<table class="table">
		<tr>
		<th>ログインID</th>
		<th>パスワード</th>
		<th>ユーザーネーム</th>
		<th>アイコン</th>
		<th>プロフィール</th>
		</tr>
			<logic:iterate id="user" name="Suser" scope="request">
				<tr>
					<td><bean:write name="user" property="loginId" /></td>
					<td><bean:write name="user" property="password" /></td>
					<td><bean:write name="user" property="userName" /></td>
					<td><bean:write name="user" property="icon" /></td>
					<td><bean:write name="user" property="profile" /></td>
				</tr>
			</logic:iterate>
		</table>
	</logic:present>
</body>
</html:html>