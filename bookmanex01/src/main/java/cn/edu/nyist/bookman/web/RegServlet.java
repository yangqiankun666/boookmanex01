package cn.edu.nyist.bookman.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.AdminBiz;
import cn.edu.nyist.bookman.impl.AdminBizimpl;


@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegServlet() {
        super();
        
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决参数中⽂乱码问题 
		request.setCharacterEncoding("utf-8");  
		//获取参数  
		String name=request.getParameter("name");  
		String pwd=request.getParameter("pwd");  
		System.out.println(name);
		System.out.println(pwd);
		AdminBiz adminBiz=new AdminBizimpl();
		
		Boolean ret=adminBiz.insertnameandpwd(name,pwd);
		if (ret) {
			request.setAttribute("msg", "注册成功");
			response.sendRedirect("login1.jsp");
		} else {
        request.setAttribute("msg","注册失败" );
       request.getRequestDispatcher("login1.jsp");
		}
		
	}

}
