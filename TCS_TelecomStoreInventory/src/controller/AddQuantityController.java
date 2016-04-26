package controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InventoryDAO;
import model.dao.ProductModelDAO;
import model.pojo.ProductModel;
/**
 * Servlet implementation class AddQuantityController
 */
public class AddQuantityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuantityController() {
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
		String id=request.getParameter("PMID");
		String quantity=request.getParameter("PMQUANTITY");
		ProductModel prodMod	=	new ProductModel( id,quantity);
	
		int result			=	InventoryDAO.insertInventoryIntoDB(id, quantity);
		 if(result==1)
			{
				
				request.setAttribute("Product Model-ID",id);
				request.setAttribute("Quantity", quantity); 
				request.setAttribute("msg", "Quantity is added successfully.");
				RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
				reqDisp.forward(request, response);
				
			}
			else
			{
				request.setAttribute("msg", "There is a bloody error!");
				RequestDispatcher reqDisp=request.getRequestDispatcher("error.jsp");
				reqDisp.forward(request, response);
				
			}
}
}