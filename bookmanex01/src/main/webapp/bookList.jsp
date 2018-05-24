<%@page import="cn.edu.nyist.bookman.v0.TypeVo"%>
<%@page import="cn.edu.nyist.bookman.v0.BookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>图书列表界面</title>
<!-- 告诉浏览器表缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
			<%if(request.getAttribute("msg")!=null) {%>
				<div class="alert alert-warning" role="alert"> <%=request.getAttribute("msg") %></div>
					<%} %>
			
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">

						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">南阳理工图书管理系统</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">书籍管理<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="toBookEdit">查看</a></li>
									<li><a href="bookAdd.jsp">添加</a></li>



								</ul></li>
						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">登录</a></li>
							<li><a href="#">修改密码</a></li>

						</ul>
					</div>

				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover table-condensed table-bordered">

					<thead>
						<tr>
							<td colspan="9">
								<form class="form-inline" action="bookList" id="searchFrm">
									<div class="form-group">
										<label for="inputName">书名</label> <input type="text"
											class="form-control" id="inputName" name="name"
											value='<%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%>'>
									</div>
									<div class="form-group">
										<label for="selTid">类型</label> <select name="tid" id="selTid"
											class="form-control">
											<option value="-1">--请选择--</option>
											<%
												List<TypeVo> ls2 = (List<TypeVo>) request.getAttribute("types");
												int tid = (Integer) request.getAttribute("tid");
												for (TypeVo typeVo : ls2) {
													if (tid == typeVo.getId()) {
											%>
											<option value="<%=typeVo.getId()%>" selected="selected"><%=typeVo.getName()%></option>
											<%
												} else {
											%>
											<option value="<%=typeVo.getId()%>"><%=typeVo.getName()%></option>
											<%
												}
												}
											%>
										</select>
									</div>
									<button type="submit" class="btn btn-default">搜索</button>
								</form>

							</td>
						</tr>
						<tr>
							<th>id</th>
							<th>name</th>
							<th>descri</th>
							<th>tid</th>
							<th>photo</th>
							<th>price</th>
							<th>author</th>
							<th>pubDate</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<BookVo> ls = (List<BookVo>) request.getAttribute("ls");
							for (BookVo bookVo : ls) {
						%>
						<tr>
							<td><%=bookVo.getId()%></td>
							<td><%=bookVo.getName()%></td>
							<td><%=bookVo.getDescri()%></td>
							<td><%=bookVo.getTid()%></td>
							<td><img alt="" src="upload/<%=bookVo.getPhoto()%>"></td>
							<td><%=bookVo.getPrice()%></td>
							<td><%=bookVo.getAuthor()%></td>
							<td><%=bookVo.getPubDate()%></td>
							<td><a href="bookDel?id=<%=bookVo.getId()%>"
								class="glyphicon glyphicon-remove" title="删除"
								onclick="confrimDel(event)"></a>&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="toBookEdit?id=<%=bookVo.getId()%>"
								class="glyphicon glyphicon-pencil" title="修改"></a></td>

						</tr>

						<%
							}
						%>

						<tr>
							<td colspan="9" style="padding-top: opx; padding-botton: opx;"
								class="text-center">
								<ul class="pagination" style="margin: 0px;">
									<%
										int pageNo = (Integer) request.getAttribute("pageNo");
										if (pageNo == 1) {
									%>
									<li class="disabled"><a href="#">&lt;&lt;</a></li>
									<%
										} else {
									%>
									<li><a href="bookList?pageNo=<%=pageNo - 1%>">&lt;&lt;</a></li>
									<%
										}
									%>


									<%
										int totalPage = (Integer) request.getAttribute("totalPage");
										if (totalPage <= 5) {
											for (int i = 1; i <= totalPage; i++) {
									%>


									<li><a href="bookList?pageNo=<%=i%>"><%=i%></a></li>

									<%
										}
									%>


									<%
										} else if (pageNo <= 3) {
									%>
									<li><a href="bookList?pageNo=1">1</a></li>
									<li><a href="bookList?pageNo=2">2</a></li>
									<li><a href="bookList?pageNo=3">3</a></li>
									<li><a href="bookList?pageNo=4">4</a></li>
									<li><a href="bookList?pageNo=<%=totalPage%>">..<%=totalPage%></a></li>

									<%
										} else if (pageNo >= totalPage - 2) {
									%>
									<li><a href="bookList?pageNo=1">1..</a></li>
									<li><a href="bookList?pageNo=<%=totalPage - 3%>"><%=totalPage - 3%></a></li>
									<li><a href="bookList?pageNo=<%=totalPage - 2%>"><%=totalPage - 2%></a></li>
									<li><a href="bookList?pageNo=<%=totalPage - 1%>"><%=totalPage - 1%></a></li>
									<li><a href="bookList?pageNo=<%=totalPage%>"><%=totalPage%></a></li>

									<%
										} else {
									%>
									<li><a href="bookList?pageNo=1">1..</a></li>
									<li><a href="bookList?pageNo=<%=pageNo - 1%>"><%=pageNo - 1%></a></li>
									<li><a href="bookList?pageNo=<%=pageNo%>"><%=pageNo%></a></li>
									<li><a href="bookList?pageNo=<%=pageNo + 1%>"><%=pageNo + 1%></a></li>
									<li><a href="bookList?pageNo=<%=totalPage%>">..<%=totalPage%></a></li>

									<%
										}
									%>
									<%
										if (pageNo == totalPage) {
									%>
									<li class="disabled"><a href="#">&gt;&gt;</a></li>
									<%
										} else {
									%>

									<li><a href="bookList?pageNo=<%=pageNo + 1%>">&gt;&gt;</a></li>
									<%
										}
									%>


								</ul>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h2></h2>
				<p>&copy;南阳理工杨乾坤版权所有</p>

			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


	<script type="text/javascript">
		$(function () {
	$("a[href='bookList?pageNo=<%=pageNo%>']").parent("li").addClass(
					"active");

			$(".pagination a[href^='bookList?pageNo=']").click(function() {

				console.dir($("#searchFrm").serialize());
				this.href += "&" + $("#searchFrm").serialize();

				
			});
		});

		function confrimDel(event) {
			if (!confirm("确认删除吗？")) {
				event.preventDefault();
			}

		}
	</script>
</body>
</html>