package cn.edu.nyist.bookman.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
///*表额达拦截所有servlet
@WebFilter("/*")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse) response;
		//login1。jsp和longinservlet要放行css和jss要放，验证码也要放
		String url=req.getRequestURI();
		if (url.endsWith("/login")||url.endsWith("/reg")||url.endsWith("/login1.jsp")||url.endsWith("/register.jsp")||url.contains("/bower_components/")||url.endsWith("/vcode.png")) {
			chain.doFilter(request, response);
			return;
		}
		
		//重复代码放置区
	     	//权限拦截
				if (req.getSession().getAttribute("loginSuccess")==null||!req.getSession().getAttribute("loginSuccess").equals("1")) {
					resp.sendRedirect("login1.jsp");
					return;//结束
				}else {
					//登录后流程要继续执行
					chain.doFilter(request, response);
				}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
