<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 告诉浏览器表缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<h1>修改密码</h1>
<form action="editPwd" method="post">  
原来的密码:<input type="password" name="pwd1"><br>
新密码:<input type="password" name="pwd"><br>  
确认密码:<input type="password" name="pwd"><br>  
<button type="submit" class="btn btn-default">  
						确认修改
					
</button>  
</form>
</body>
</html>