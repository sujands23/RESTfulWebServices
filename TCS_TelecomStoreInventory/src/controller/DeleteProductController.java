package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductModelDAO;



/**
 * Servlet implementation class deleteProductController
 */
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setAttribute("error",0);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// TODO Auto-generated method stub

		System.out.println("in controller");
		String pid=null;
		String[] id=request.getParameterValues("rid");
		for(int i=0;i<=id.length;i++)
		{
			pid=id[0];
			//System.out.println(pid);
		}
		
	    //ProductModel.setId(id);
	    //int deleteProductModel	=	ProductModelDAO.deleteProductModel(id);	
		System.out.println(pid);
		int rows=ProductModelDAO.deleteProductModel(pid);
		System.out.println( rows);
		if(rows==1) //if one row deleted successfully
		{request.setAttribute("Type", "Product Model-ID");
		request.setAttribute("Product Model-ID",id);
			//request.setAttribute("status",1);
			request.setAttribute("msg", "Product is deleted successfully.");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request,response); //displays content only from the last servlet
			//rd.include(request,response);//displays content only from the previous servlet	
		}
		else if(rows==0) //if zero row(s) get affected(deleted)
		{
			request.setAttribute("Type", "Product Model-ID");
			request.setAttribute("Product Model-ID",id);
			request.setAttribute("status",0);
			request.setAttribute("msg", "Product is deleted successfully.");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request,response);	
		}
		else //if any Exception arises
		{
			request.setAttribute("status",0);
			request.setAttribute("msg", "Product is not deleted");
			RequestDispatcher rd=request.getRequestDispatcher("deleteProduct.jsp");
			rd.forward(request,response);			
		}
		
		/*if(id.equals("confirmDelete")){
			request.setAttribute("msg", "Product is deleted successfully.");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request,response);
			
		}*/
	}
}
