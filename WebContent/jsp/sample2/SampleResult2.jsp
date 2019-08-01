<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>完了画面</title>
<link rel="stylesheet" type="text/css" href="./css/example.css" />
<link rel="stylesheet" href="./css/skyblue.css" />
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="./css/helper.css" />
</head>
<body>
<div class="text-center">以下の内容で登録が完了しました。</div>
		ログインID:
		<bean:parameter name="loginId" id="loginId" /><%=loginId%><br>

		パスワード:
		<bean:parameter name="password" id="password" /><%=password%><br>

		ユーザーネーム:
		<bean:parameter name="userName" id="userName" /><%=userName%><br>

		アイコン:
		<bean:parameter name="icon" id="icon" /><%=icon%><br>

		 プロフィール:
		<bean:parameter name="profile" id="profile" /><%=profile%><br>

	<br>
	<br>
	<div class="text-center">
		<html:link href="/struts_prj/jsp/sample2/SampleTop2.jsp">トップへ</html:link>
	</div>
</body>
</html>