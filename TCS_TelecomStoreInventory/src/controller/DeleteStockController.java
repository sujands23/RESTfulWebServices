package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.StockDAO;

/**
 * Servlet implementation class DeleteStockController
 */
public class DeleteStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStockController() {
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

		String Model=request.getParameter("Model");		
			
	  
	    //ProductModel.setId(id);
	    //int deleteProductModel	=	ProductModelDAO.deleteProductModel(id);	
	    int result			=	StockDAO.deletePS(Model);	
	    if(result==1)
		{
			//response.sendRedirect("success.html");
			//out.print("<h2>Dept is added</h2>");
			request.setAttribute("msg", "product is deleted successfully.");
			request.setAttribute("Model", 	Model);
			RequestDispatcher reqDisp=request.getRequestDispatcher("DisplayNewretailerCreated.view");
			reqDisp.forward(request, response);
			
		}
		else
		{
			//response.sendRedirect("error.html");
			//out.print("<h2>Its problem</h2>");
			request.setAttribute("msg", "There is a bloody error!");
			RequestDispatcher reqDisp=request.getRequestDispatcher("DisplayErrorMessage.view");
			reqDisp.forward(request, response);
			
		}
	}

}

