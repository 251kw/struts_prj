<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>トップ</title>
<link rel="stylesheet" type="text/css" href="./css/example.css" />
<link rel="stylesheet" href="./css/skyblue.css" />
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="./css/helper.css" />
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>トップ画面</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<table class="table">
				<tr>
					<td><html:link href="/struts_prj/jsp/sample2/SampleInput2.jsp">ユーザー登録</html:link></td>
				</tr>
				<tr>
					<td><html:link
							href="/struts_prj/jsp/sample2/SampleSearch2.jsp">ユーザー検索</html:link></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>