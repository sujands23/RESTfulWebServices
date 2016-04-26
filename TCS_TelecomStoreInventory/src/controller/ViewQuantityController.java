package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.InventoryDAO;




/**
 * Servlet implementation class ViewQuantityController
 */
public class ViewQuantityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewQuantityController() {
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
		//receiving input from the user interface in the form of request object

		String productModelId=request.getParameter("PMID");
		System.out.println("PId is: "+productModelId);
		request.setAttribute("PMID", productModelId);
		//capturing the Product Model to be viewed in an ArrayList of type ProductModel
		int productquantity=InventoryDAO.getQuantityIntoDB(productModelId); 
		//ProductModel product=new ProductModel("",productquantity+"");
		System.out.println(productquantity);
		request.setAttribute("product", productquantity+"");
		request.getRequestDispatcher("updateStock.jsp").forward(request, response);

	}
}
