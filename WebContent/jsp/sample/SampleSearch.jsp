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
			<html:text property="userName" size="40" maxlength="64" errorStyle="background-color:pink" />
			<logic:notEmpty name="userName">
				<bean:parameter id="name" name="userName" />
				<html:text property="userName" size="40" maxlength="64"
					value="<%=name%>" errorStyle="background-color:pink" />
			</logic:notEmpty>
			<!-- エラーがあれば表示 -->
			<html:errors property="userName" />
		</p>
		<p>
			Search by login ID.<br />
			<html:text property="loginId" size="40" maxlength="32" errorStyle="background-color:pink" />
			<logic:notEmpty name="loginId">
				<bean:parameter id="ID" name="loginId" />
				<html:text property="loginId" size="40" maxlength="32"
					value="<%=ID%>" errorStyle="background-color:pink" />
			</logic:notEmpty>
			<!-- エラーがあれば表示 -->
			<html:errors property="loginId" />
		</p>
		<p>
			Search by icon.<br />
			<% String icon = request.getParameter("icon");
			   if(icon == null){
				   icon = "--";
			   }
			%>
			<html:select property="icon" value="<%=icon %>">
				<html:option value="">--</html:option>
				<html:option value="icon-user">male</html:option>
				<html:option value="icon-user-female">female</html:option>
				<html:option value="icon-magic-wand">wand</html:option>
				<html:option value="icon-plugin">plugin</html:option>
				<html:option value="icon-rocket">rocket</html:option>
				<html:option value="icon-smile">smile</html:option>
				<html:option value="icon-wine">wine</html:option>
				<html:option value="icon-cash">cash</html:option>
				<html:option value="icon-gym">gym</html:option>
				<html:option value="icon-diamond">diamond</html:option>
				<html:option value="icon-star">star</html:option>
				<html:option value="icon-science">science</html:option>
				<html:option value="icon-film">film</html:option>
				<html:option value="icon-plane">plane</html:option>
				<html:option value="icon-joy">joy</html:option>
			</html:select>
		</p>
		<p>
			Search by Profile.<br />
			<html:text property="profile" size="40" maxlength="128" errorStyle="background-color:pink" />
			<logic:notEmpty name="profile">
				<bean:parameter id="profile" name="profile" />
				<html:text property="profile" size="40" maxlength="128"
					value="<%=profile%>" errorStyle="background-color:pink" />
			</logic:notEmpty>
			<!-- エラーがあれば表示 -->
			<html:errors property="profile" />
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