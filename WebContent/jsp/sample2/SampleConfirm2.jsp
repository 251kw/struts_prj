<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html xhtml="true" lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<html:form action="/confirm2">
		<bean:write name="SampleActionForm2" property="userName" />
		<html:hidden name="SampleActionForm2" property="userName" />
		<br>
		<html:submit>
			<bean:message key="button.ok" />
		</html:submit>
		<html:submit>
			<bean:message key="button.cancel" />
		</html:submit>
	</html:form>
</body>
</html:html>