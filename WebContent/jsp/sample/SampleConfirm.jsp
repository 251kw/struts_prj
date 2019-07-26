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
<link rel="stylesheet" type="text/css" href="./css/example.css" />
<link rel="stylesheet" href="./css/skyblue.css" />
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="./css/helper.css" />
</head>
<body>

	<p>The registration will be processed with the informations below.</p>
	<hr />
	<html:form action="/confirm">
		<p>
			Name :
			<bean:parameter id="name" name="userName" /><%=name%>
			<html:hidden property="userName" value="<%=name%>" />
		</p>
		<p>
			Login ID :
			<bean:parameter id="ID" name="loginId" /><%=ID%>
			<html:hidden property="loginId" value="<%=ID%>" />
		</p>
		<p>
			Password :
			<bean:parameter id="pass" name="password" /><%=pass%>
			<html:hidden property="password" value="<%=pass%>" />
		</p>
		<p>
			Icon :
			<bean:parameter id="icon" name="icon" /><%=icon%>
			<html:hidden property="icon" value="<%=icon%>" />
		</p>
		<p>
			Profile :
			<bean:parameter id="profile" name="profile" /><%=profile%>
			<html:hidden property="profile" value="<%=profile%>" />
		</p>
		<hr />
		<p>
			<html:cancel>
				<bean:message key="button.cancel" />
			</html:cancel>
			<html:submit>
				<bean:message key="button.ok" />
			</html:submit>
		</p>
	</html:form>

</body>
</html:html>