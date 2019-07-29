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

	<p>Select Menu</p>
	<hr />

	<p>
		<html:link href="/struts_prj/jsp/sample/SampleInput.jsp">
			<th>Register user.</th>
		</html:link>
	</p>
	<p>
		<html:link href="/struts_prj/jsp/sample/SampleSearch.jsp">
			<th>Search user.</th>
		</html:link>
	</p>

</body>
</html:html>