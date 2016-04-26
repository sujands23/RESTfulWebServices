package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.ProductModelDAO;
import model.dao.RetailerDAO;
import model.pojo.RetailerInfo;

/**
 * Servlet implementation class AddRetailerController
 */
public class AddRetailerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRetailerController() {
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
		String retailerId=RetailerDAO.generateNewRetailerID();
		//String retailerId=request.getParameter("id");
		String RETAILER_NAME=request.getParameter("name");
		String LOCATION=request.getParameter("loc");
		String LICENCE_NUMBER=request.getParameter("licNo");
		  			
	    RetailerInfo retailer	=	new RetailerInfo(retailerId, RETAILER_NAME,LOCATION,LICENCE_NUMBER,null);
	    int result			=	RetailerDAO.addRetailer(retailer);	
	    if(result==1)
		{
	    	request.setAttribute("Type", "retailerId");
			request.setAttribute("msg", "Retailer is added successfully.");
			request.setAttribute("retailerId", 	retailerId);
			request.setAttribute("RETAILER_NAME", 	RETAILER_NAME); 
			request.setAttribute("LOCATION", 	LOCATION); 
			request.setAttribute("LICENCE_NUMBER", LICENCE_NUMBER); 
			
			RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
			reqDisp.forward(request, response);
			
		}
		else
		{

			request.setAttribute("msg", "There is a  error! YOU have entered the same RETAILER details");
			RequestDispatcher reqDisp=request.getRequestDispatcher("error.jsp");
			reqDisp.forward(request, response);
			
		}
	}

}
