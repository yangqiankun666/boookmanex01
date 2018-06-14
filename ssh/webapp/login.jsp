<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form>
		<s:textfield name="admin.name" label="用户名"></s:textfield>
		<s:textfield name="admin.pwd" label="密码"></s:textfield>
		<s:submit value="登录"></s:submit>
	</s:form>
</body>
</html>