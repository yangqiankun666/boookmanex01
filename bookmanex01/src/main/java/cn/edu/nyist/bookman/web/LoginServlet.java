package cn.edu.nyist.bookman.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nyist.bookman.biz.AdminBiz;
import cn.edu.nyist.bookman.impl.AdminBizimpl;
import cn.edu.nyist.bookman.util.DsUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		//��ȡ��֤��
		String vcode=request.getParameter("vcode");
		HttpSession session = request.getSession(); 
		//session.setAttribute("validateCode", randomCode.toString()); 
		String serverVcode=(String) session.getAttribute("validateCode");
		if(!serverVcode.equalsIgnoreCase(vcode)) {
			request.setAttribute("msg", "��֤�����");
	    	request.setAttribute("name", name);
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
	    	return ;
		}
		AdminBiz adminBiz=new AdminBizimpl();
		boolean ret=adminBiz.findAdminByNameAndPwd(name,pwd);
		
		
		    if(ret) {
		    	response.sendRedirect("main.jsp");
		    }
		    else {
		    	request.setAttribute("msg", "�û��������������");
		    	request.setAttribute("name", name);
		    	request.getRequestDispatcher("login.jsp").forward(request, response);
		    }
	}

}
