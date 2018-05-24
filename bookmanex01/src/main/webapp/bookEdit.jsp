<%@page import="cn.edu.nyist.bookman.v0.BookVo"%>
<%@page import="cn.edu.nyist.bookman.v0.TypeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍修改</title>
<!-- 告诉浏览器表缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
	
	<style type="text/css">
	
	
	</style>
</head>
<body>

<div class="container-fluid well">
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal" role="form" method="post" action="doBookEdit" id="loginFrm" enctype="multipart/form-data">
			
			<%if(request.getAttribute("msg")!=null) {%>
				<div class="alert alert-warning" role="alert"> <%=request.getAttribute("msg") %></div>
					<%
				}
			BookVo booVo=(BookVo)request.getAttribute("bookVo");	%>
			<input type="hidden" value="<%=booVo.getId()%>" name="id">
				<div class="form-group">
				
					<label for="inputName" class="col-sm-2 control-label">
						书名:
					</label>
					<div class="col-sm-10">
						<input  class="form-control" id="inputName" type="text" name="name" value="<%=booVo==null||booVo.getName()==null?"":booVo.getName()%>" />
					</div>
				</div>
				
				
				<div class="form-group">
				<label for="textAreaDescri" class="col-sm-2 control-label">
						描述:
					</label>
					<div class="col-sm-10">
					<textarea name="descri" class="form-control" id="textAreaDescri">
				<%=booVo==null||booVo.getDescri()==null?"":booVo.getDescri()%>
					</textarea>
					
					</div>
				</div>
				
				
				
				
				<div class="form-group">
				
					<label for="inputPhoto" class="col-sm-2 control-label">
						图片:
					</label>
					<div class="col-sm-4">
						<input  class="form-control" id="inputPhoto" type="file" name="photo" value="<%=booVo==null||booVo.getPhoto()==null?"":booVo.getPhoto()%>"/>
					</div>
					<div class="col-sm-6">
					<%
					if(booVo!=null&&booVo.getPhoto()!=null)
					{
					%>
					<img src="upload/<%=booVo.getPhoto()%>">
					<%}%>
					</div>
				</div>
				
				
				<div class="form-group">
				
					<label for="inputPrice" class="col-sm-2 control-label">
						价格:
					</label>
					<div class="col-sm-10">
						<input  class="form-control" id="inputPrice" type="text" name="price" value='<%=booVo==null?"":booVo.getPrice()%>' />
					</div>
				</div>
				
				
				
					<div class="form-group">
				
					<label for="inputPubDate" class="col-sm-2 control-label">
						出版时间:
					</label>
					<div class="col-sm-10">
						<input  class="form-control" id="inputPubDate" type="text" name="pubDate" value='<%=booVo==null||booVo.getPubDate()==null?"":booVo.getPubDate()%>' />
					</div>
				</div>
				
				<div class="form-group">
				
					<label for="inputAuthor" class="col-sm-2 control-label">
						作者:
					</label>
					<div class="col-sm-10">
						<input  class="form-control" id="inputAuthor" type="text" name="author" value='<%=booVo==null||booVo.getAuthor()==null?"":booVo.getAuthor()%>' />
					</div>
				</div>
				
				
				<div class="form-group">
				
					<label for="inputAuthor" class="col-sm-2 control-label">
						类型:
					</label>
					<div class="col-sm-10">
					<select name="tid" class="form-control" id="selectTid">
				
					
					
					
					</select>
				
						
					</div>
				</div>
				
				
				<div class="form-group">  

<label for="inputVcode" class="col-sm-2 control-label">  
验证码  
</label>  
<div class="col-sm-6">  
<input type="text" class="form-control" id="inputVcode"
name="vcode" maxlength="4"/>


</div>  
<div class="col-sm-4">  
<img alt="" src="vcode.png" id="vcodeImg" title="单击更换">  
</div>  
</div>  
<div class="form-group">  
<div class="col-sm-offset-2 col-sm-10">  

<button type="submit" class="btn btn-default">  
						修改:
</button>  
</div>  
</div>  
</form>  
</div>  
</div>  
</div>  
	

	<script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js">
	</script>
	<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js">
	</script>
	<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js">
	</script>
	<script type="text/javascript" src="bower_components/jquery-validation-bootstrap-tooltip/jquery-validate.bootstrap-tooltip.js">
	</script>
	<script type="text/javascript"> 
$(function(){  
$("#vcodeImg").click(function(evt){  
//不加不会换  
this.src="vcode.png?t="+Math.random();  
});  


$('#inputPubDate').datepicker({
    format: 'yyyy-mm-dd',
    	language: 'zh-CN',
    	autoclose:true
});



});  

</script>  

<script type="text/javascript">
function fillSel(types) {
	var tid=<%=booVo.getTid()%>;
	var sel=document.getElementById("selectTid");
	for (var i = 0; i < types.length; i++) {
		var op=new Option(types[i].name,types[i].id);
		sel.appendChild(op);
		if (tid==types[i].id) {
			op.selected=true;
		}
	}
}

</script>

<iframe src="findAllTypes" style="display: none"></iframe>
</body>
</html>