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
 * Servlet implementation class AddPackageController
 */
public class AddPackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackageController() {
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
		//String packageId=request.getParameter("PackgID");
		String packageId=PackageDAO.generateNewID();
		String offer=request.getParameter("offrs");
		String odrerValue=request.getParameter("Ovalu");
				  			
		RewardPackage rwpkg	=	new RewardPackage( packageId,offer,odrerValue);
	    	  
	    int result			=	PackageDAO.insertPackage(rwpkg);	
	    if(result==1)
		{
	    	request.setAttribute("Type", "id");
	    	RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
			request.setAttribute("id", packageId);
			request.setAttribute("offers", offer); 
			request.setAttribute("Order_value", odrerValue); 
			request.setAttribute("msg", "NEW COMPLIMENTARY PACKAGE is added successfully.");
		
			
			reqDisp.forward(request, response);
			
		}
		else
		{
			request.setAttribute("msg", "There is a bloody error! you have enter the Same Value");
			RequestDispatcher reqDisp=request.getRequestDispatcher("error.jsp");
			reqDisp.forward(request, response);
		}

	}

}
