package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.StockDAO;
import model.pojo.ProductStock;





/**
 * Servlet implementation class deleteProductController
 */
public class UpdateStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStockController() {
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

		String id=request.getParameter("id");
		String Model=request.getParameter("Model");
		String name=request.getParameter("name");
		String Status=request.getParameter("Status");
		
		
		ProductStock rwpg= new ProductStock(id, Model,name,Status,null);
		
	  
	    
	    int result			=	StockDAO.updatePS(id,rwpg);	
	    if(result==1)
		{
			
			request.setAttribute("msg", "Stock is Updated successfully.");
			request.setAttribute("P_ID", 	id);
			request.setAttribute("Model", 	Model);
			request.setAttribute("name", 	name);
			request.setAttribute("Status", 	Status);
			RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
			reqDisp.forward(request, response);
			
		}
		else
		{
			//response.sendRedirect("error.html");
			//out.print("<h2>Its problem</h2>");
			request.setAttribute("msg", "There is a bloody error!");
			RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
			reqDisp.forward(request, response);
			
		}
	}

}
