package cn.edu.nyist.bookman.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.nyist.bookman.biz.BookBiz;
import cn.edu.nyist.bookman.impl.BookBizImpl;


@WebServlet("/bookAdd")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookAddServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		Part part=request.getPart("photo");
		String fileName= part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		//瑙ｅ喅IE涓嬮敊璇棶棰�  
		fileName=fileName.lastIndexOf("\\")==-1?
				fileName:fileName.substring(fileName.lastIndexOf("\\")+1);
				//瀛樺湪hibernate.cfg.xml杩欑饨備欢鍚�  
				String ext=fileName.substring(fileName.lastIndexOf('.')+1);  
				String newFileName=UUID.randomUUID().toString()+"."+ext;  
				part.write(request.getServletContext().getRealPath("upload/"+newFileName));
				
				
				String name=request.getParameter("name");
				String descri=request.getParameter("descri");
				String strPrice=request.getParameter("price");
				double price=Double.parseDouble(strPrice);
				String author=request.getParameter("author");
				String strTid=request.getParameter("tid");
				int tid=Integer.parseInt(strTid);
				
				
				BookBiz bookbiz=new BookBizImpl();
				int ret=bookbiz.saveBook(name,descri,price,author,tid,newFileName);
				response.setContentType("text/html;charset=utf-8");
				if (ret>0) {
				response.getWriter().write("添加成功");	
				} else {
					request.setAttribute("msg", "添加失败");
					request.getRequestDispatcher("bookAdd.jsp").forward(request,response);

				}
				
				
	}

}
