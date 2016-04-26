package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductModelDAO;
import model.pojo.ProductModel;

/**
 * Servlet implementation class AddProduct
 */
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
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

		String id=ProductModelDAO.generateNewID();
		String name=request.getParameter("PMName");
		String description=request.getParameter("PMDesc");
		String features=request.getParameter("PMFeat");
		double price=Double.parseDouble(request.getParameter("PMPrice"));
		int threshold=Integer.parseInt(request.getParameter("PMTh"));
		
		
				
	    ProductModel prodMod	=	new ProductModel( id,name,description,features,price,threshold);
	    String result			=	ProductModelDAO.insertProductModel(prodMod);	
	    
	    if(result!=null)
		{
			request.setAttribute("Type", "Product Model-ID");
			request.setAttribute("Product Model-ID",id);
			request.setAttribute("Product Model Name", name); 
			request.setAttribute("Product Model Description",description); 
			request.setAttribute("Product Model Features", features);
			request.setAttribute("Price(Rs.)",price); 
			request.setAttribute("Product Model Threshold ",threshold);
			
			request.setAttribute("msg", "Product is added successfully.");
			RequestDispatcher reqDisp=request.getRequestDispatcher("success.jsp");
			reqDisp.forward(request, response);
			
		}
		else if(result==null)
		{
			request.setAttribute("msg", "There is an error! YOU have enter the same detail");
			RequestDispatcher reqDisp=request.getRequestDispatcher("error.jsp");
			reqDisp.forward(request, response);
			
		}
	}
}

