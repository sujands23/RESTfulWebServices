package controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InventoryDAO;
import model.pojo.ProductModel;

/**
 * Servlet implementation class UpdateQuantityController
 */
public class UpdateQuantityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateQuantityController() {
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
		System.out.println("inside controller");
		String productModelId=request.getParameter("PMID");
		System.out.println("PId is: "+productModelId);
		//capturing the Product Model to be viewed in an ArrayList of type ProductModel
		String quantity=request.getParameter("quantity");
		request.setAttribute("quantity", quantity);
		System.out.println("Quantity is: "+quantity);
		int result=InventoryDAO.updateQuantityIntoDB(productModelId, quantity);
		if(result==1){

			request.setAttribute("PMID",productModelId);
			request.setAttribute("msg", "Quantity is added successfully.<h5>Please go to ADD STOCK And Add Quantity</h5>"+quantity);
			

		}
		else{
			request.setAttribute("msg", "There is a bloody error!");
			

		}
		RequestDispatcher reqDisp=request.getRequestDispatcher("updateStock.jsp");
		reqDisp.forward(request, response);
	}
}
