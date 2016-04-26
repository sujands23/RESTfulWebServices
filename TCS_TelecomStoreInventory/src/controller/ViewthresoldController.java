package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InventoryDAO;

/**
 * Servlet implementation class ViewthresoldController
 */
public class ViewthresoldController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewthresoldController() {
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
		String productModelId=request.getParameter("PMID");
		System.out.println("PId is: "+productModelId);
		request.setAttribute("PMID", productModelId);
		//capturing the Product Model to be viewed in an ArrayList of type ProductModel
		int productquantity=InventoryDAO.getQuantityIntoDB(productModelId); 
		//ProductModel product=new ProductModel("",productquantity+"");
		System.out.println(productquantity);
		request.setAttribute("product", productquantity+"");
		request.getRequestDispatcher("thresoldQuantity.jsp").forward(request, response);
	}

}
