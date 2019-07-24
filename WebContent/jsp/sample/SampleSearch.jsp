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

	<p>Search user</p>
	<hr noshade="noshade" />

	<html:form action="/search">
		<p>
			* Input user name.<br />
			<html:text property="userName" size="40" maxlength="50" />
		</p>
	</html:form>

	<hr />

	<p>
		<html:submit>
			<bean:message key="button.search" />
		</html:submit>
	</p>

	<hr />

	<bean:include id="resultpage" page="/jsp/sample/SampleSearchResult.jsp" />
	<%=resultpage %>

</body>
</html:html>