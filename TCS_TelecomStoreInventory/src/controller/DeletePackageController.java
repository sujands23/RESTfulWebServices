package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.PackageDAO;




/**
 * Servlet implementation class deleteProductController
 */
public class DeletePackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePackageController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// TODO Auto-generated method stub

		String id=request.getParameter("CPID");
		
			
	  
	    //ProductModel.setId(id);
	    //int deleteProductModel	=	ProductModelDAO.deleteProductModel(id);	
	    int result			=	PackageDAO.deletePackage(id);
	    
	    if(result==1)
		{
			//response.sendRedirect("success.html");
			//out.print("<h2>Dept is added</h2>");
			request.setAttribute("msg", "package is deleted successfully.");
			request.setAttribute("CPID", 	id);
			RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
			reqDisp.forward(request, response);
			
		}
		else
		{
			//response.sendRedirect("error.html");
			//out.print("<h2>Its problem</h2>");
			request.setAttribute("msg", "There is a bloody error!");
			RequestDispatcher reqDisp=request.getRequestDispatcher("home.jsp");
			reqDisp.forward(request, response);
			
		}
	}

}
