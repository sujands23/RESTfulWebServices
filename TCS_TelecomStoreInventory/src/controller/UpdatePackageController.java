package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.PackageDAO;
import model.pojo.RewardPackage;




/**
 * Servlet implementation class deleteProductController
 */
public class UpdatePackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePackageController() {
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
		String offers=request.getParameter("offer");
		String order_value=request.getParameter("order");
		
		RewardPackage rwpg= new RewardPackage(id, offers,order_value);
		
	  
	    
	    int result			=	PackageDAO.updatePackage(id,rwpg);	
	    if(result==1)
		{
			
			request.setAttribute("msg", "package is Updated successfully.");
			request.setAttribute("P_ID", 	id);
			request.setAttribute("offer", 	offers);
			request.setAttribute("order_value", 	order_value);
			
			RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
			reqDisp.forward(request, response);
			
		}
		else
		{
			//response.sendRedirect("error.html");
			//out.print("<h2>Its problem</h2>");
			request.setAttribute("msg", "There is a bloody error!");
			RequestDispatcher reqDisp=request.getRequestDispatcher("error.jsp");
			reqDisp.forward(request, response);
			
		}
	}

}
