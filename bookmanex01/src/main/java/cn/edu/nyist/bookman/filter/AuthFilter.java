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
///*������������servlet
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
		//login1��jsp��longinservletҪ����css��jssҪ�ţ���֤��ҲҪ��
		String url=req.getRequestURI();
		if (url.endsWith("/login")||url.endsWith("/reg")||url.endsWith("/login1.jsp")||url.endsWith("/register.jsp")||url.contains("/bower_components/")||url.endsWith("/vcode.png")) {
			chain.doFilter(request, response);
			return;
		}
		
		//�ظ����������
	     	//Ȩ������
				if (req.getSession().getAttribute("loginSuccess")==null||!req.getSession().getAttribute("loginSuccess").equals("1")) {
					resp.sendRedirect("login1.jsp");
					return;//����
				}else {
					//��¼������Ҫ����ִ��
					chain.doFilter(request, response);
				}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
