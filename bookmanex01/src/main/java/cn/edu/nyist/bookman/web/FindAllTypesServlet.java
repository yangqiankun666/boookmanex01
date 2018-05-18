package cn.edu.nyist.bookman.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookman.biz.TypeBiz;
import cn.edu.nyist.bookman.impl.TypeBizImpl;
import cn.edu.nyist.bookman.v0.TypeVo;


@WebServlet("/findAllTypes")
public class FindAllTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FindAllTypesServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeBiz typeBiz=new TypeBizImpl();
		List<TypeVo> ls=typeBiz.findAllTypes();
		//request.setAttribute("ls",ls);
		//request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script>");
		String  js="[";
		for (int i=0;i<ls.size();i++) {
			js+="{id:"+ls.get(i).getId()+",name:'"+ls.get(i).getName()+"'}";
			if (i<ls.size()-1) {
				js+=",";
			}
		}
		js+="]";
		response.getWriter().write("window.parent.fillSel("+js+");");
		response.getWriter().write("</script>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
