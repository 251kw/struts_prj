<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<div class="text-center">
<logic:present name="userlist" scope="session">

<table class="table-border">
<tr><th>UserID</th><th>LoginID</th><th>Name</th><th>icon</th><th>Profile</th></tr>
<logic:iterate id="user"  name="userlist" >
<tr><td><bean:write name="data" property="userId"/></td>
<td><bean:write name="data" property="loginId"/></td>
<td><bean:write name="data" property="userName"/></td>
<td><bean:write name="data" property="icon"/></td>
<td><bean:write name="data" property="profile"/></td></tr>
</logic:iterate>
</table>

</logic:present>
</div>