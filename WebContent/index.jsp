<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html:html xhtml="true" lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sample form using ActionForm</title>
<html:base />
<link rel="stylesheet" type="text/css" href="../../css/example.css" />
</head>
<body>
	<p>
		Enter information into the fields below.
	</p>
	<p>* = required field</p>
	<hr noshade="noshade" />
	<html:errors />
	<html:form action="/welcome">
		<p>
			* What's your first name?:<br />
			<html:text property="name" size="40" maxlength="50" />
		</p>
		<html:hidden property="hidden"
			value="Sssh! It's a secret. Nobody knows I'm here." />
		<hr noshade="noshade" />
		<p>
			<html:submit>
				<bean:message key="button.submit" />
			</html:submit>
			<html:cancel />
		</p>
	</html:form>
</body>
</html:html>