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
import cn.edu.nyist.bookman.util.MyBeanUtils;
import cn.edu.nyist.bookman.v0.BookVo;


@WebServlet("/doBookEdit")
@MultipartConfig
public class DoBookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DoBookEditServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");  
		Part part=request.getPart("photo");
		String fileName= part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		//瑙ｅ喅IE涓嬮敊璇棶棰�  
		String newFileName="";
		if(!fileName.equals("")) {
		fileName=fileName.lastIndexOf("\\")==-1?fileName:fileName.substring(fileName.lastIndexOf("\\")+1);
				//瀛樺湪hibernate.cfg.xml杩欑饨備欢鍚�  
				String ext=fileName.substring(fileName.lastIndexOf('.')+1);  
				newFileName=UUID.randomUUID().toString()+"."+ext;  
				part.write(request.getServletContext().getRealPath("upload/"+newFileName));
				
		}
				/*String name=request.getParameter("name");
				String descri=request.getParameter("descri");
				String strPrice=request.getParameter("price");
				double price=Double.parseDouble(strPrice);
				String author=request.getParameter("author");
				String strTid=request.getParameter("tid");
				int tid=Integer.parseInt(strTid);
				String strPubDate=request.getParameter("pubDate");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date pubDate=null;
				try {
					pubDate=sdf.parse(strPubDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				BookVo bookVo=new BookVo();
				/*try {
					BeanUtils.populate(bookVo, request.getParameterMap());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				MyBeanUtils.populate(bookVo, request.getParameterMap(),"yyyy-MM-dd");
				if(!fileName.equals("")) {
				bookVo.setPhoto(newFileName);
				}
				BookBiz bookbiz=new BookBizImpl();
				//int ret=bookbiz.saveBook(name,descri,price,author,tid,newFileName,pubDate);
				int ret=bookbiz.editBook(bookVo);
				response.setContentType("text/html;charset=utf-8");
				if (ret>0) {
				response.sendRedirect("bookList");
				} else {
					request.setAttribute("msg", "添加失败");
					//request.getRequestDispatcher("doBookEdit").forward(request,response);
					request.setAttribute("bookVo", bookVo);
                request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
				}
				
				
	}

}
