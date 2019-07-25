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

	<p>Fill the form below.</p>
	* is required field.
	<hr />

	<html:errors header="false" footer="false" property="userName" />
	<html:form action="/input">
		<p>
			* What's your name?<br />
			<logic:notEmpty property="userName">
			<bean:parameter id="name" name="userName" />
			<html:text property="userName" size="40" maxlength="50" value="<%=name %>" />
			</logic:notEmpty>
			<html:text property="userName" size="40" maxlength="50" />
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