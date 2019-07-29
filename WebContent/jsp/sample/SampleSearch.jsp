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

	<p>Search user</p>
	<hr />

	<html:form action="/search">
		<p>
			Search by Name.<br />
			<html:text property="userName" size="40" maxlength="64" />
		</p>
		<p>
			Search by login ID.<br />
			<html:text property="loginId" size="40" maxlength="32" />
		</p>
		<p>
			Search by icon.<br />
			<html:select property="icon">
				<option value="icon-user">male</option>
				<option value="icon-user-female">female</option>
				<option value="icon-magic-wand">wand</option>
				<option value="icon-plugin">plugin</option>
				<option value="icon-rocket">rocket</option>
				<option value="icon-smile">smile</option>
				<option value="icon-wine">wine</option>
				<option value="icon-cash">cash</option>
				<option value="icon-gym">gym</option>
				<option value="icon-diamond">diamond</option>
				<option value="icon-star">star</option>
				<option value="icon-science">science</option>
				<option value="icon-film">film</option>
				<option value="icon-plane">plane</option>
				<option value="icon-joy">joy</option>
			</html:select>
		</p>
		<p>
			Search by Profile.<br />
			<html:text property="profile" size="40" maxlength="128" />
		</p>
		<p>
			<html:cancel>
				<bean:message key="button.cancel" />
			</html:cancel>
			<html:submit>
				<bean:message key="button.search" />
			</html:submit>
		</p>
	</html:form>
	<hr />

	<html:messages id="msg" message="true">
		<bean:write name="msg" ignore="true" />
	</html:messages>

	<logic:present name="userlist" scope="request">
		<table border="1">
			<tr>
				<th>UserID</th>
				<th>LoginID</th>
				<th>Name</th>
				<th>icon</th>
				<th>Profile</th>
			</tr>
			<logic:iterate id="user" name="userlist" scope="request">
				<tr>
					<td><bean:write name="user" property="userId" /></td>
					<td><bean:write name="user" property="loginId" /></td>
					<td><bean:write name="user" property="userName" /></td>
					<td><span><bean:write name="user" property="icon" /></span></td>
					<td><bean:write name="user" property="profile" /></td>
				</tr>
			</logic:iterate>
		</table>
	</logic:present>

</body>
</html:html>