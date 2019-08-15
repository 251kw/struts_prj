<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html xhtml="true" lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確認画面</title>
<link rel="stylesheet" type="text/css" href="./css/example.css" />
<link rel="stylesheet" href="./css/skyblue.css" />
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="./css/helper.css" />
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>確認画面</h1>
		</div>
	</div>
	<div class="text-center">以下の内容で登録します。</div>
	<html:form action="/confirm2">
		ログインID：
		<bean:write name="SampleActionForm2" property="loginId" />
		<br>
		パスワード：
		<bean:write name="SampleActionForm2" property="password" />
		<br>
		ユーザーネーム：
		<bean:write name="SampleActionForm2" property="userName" />
		<br>
		アイコン：
		<bean:write name="SampleActionForm2" property="icon" />
		<br>
		プロフィール：
		<bean:write name="SampleActionForm2" property="profile" />
		<br>
		血液型 ：
		<bean:write name="SampleActionForm2" property="blood" />
		<br>

		趣味　：
		<logic:iterate id="Hobby" name="SampleActionForm2" property="hobby">
		<bean:write name="Hobby"/>,
		</logic:iterate>

		<!-- 結果画面に値を渡す --><!-- 入力画面で保持する値を渡す -->
		<html:hidden name="SampleActionForm2" property="loginId" />
		<html:hidden name="SampleActionForm2" property="password" />
		<html:hidden name="SampleActionForm2" property="userName" />
		<html:hidden name="SampleActionForm2" property="icon" />
		<html:hidden name="SampleActionForm2" property="profile" />
		<html:hidden name="SampleActionForm2" property="blood" />
		<html:hidden name="SampleActionForm2" property="hobby"/>



		<div class="text-center">
			<html:submit property="btn">
				<bean:message key="button.ok" />
			</html:submit>
			<html:submit property="btn">
				<bean:message key="button.cancel" />
			</html:submit>
		</div>
	</html:form>
</body>
</html:html>