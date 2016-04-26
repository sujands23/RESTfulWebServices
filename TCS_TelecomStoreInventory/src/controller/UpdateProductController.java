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
 * Servlet implementation class updateProductController
 */
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() {
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
		String ProductModelId=request.getParameter("id");
		String ProductName=request.getParameter("name");
		String ProductDescription=request.getParameter("description");
		String ProductFeatures=request.getParameter("feature");
		double ProductPrice=Double.parseDouble(request.getParameter("price"));
		int ProductThreshold=Integer.parseInt(request.getParameter("threshold"));
		System.out.println(ProductModelId);
		ProductModel P=new ProductModel(ProductModelId,ProductName,ProductDescription,ProductFeatures,ProductPrice,ProductThreshold) ;
		
		int result=	ProductModelDAO.updateProductModel(ProductModelId, P);	
	    if(result==1)
		{
	    	request.setAttribute("Type", "Product Model-ID");
			//response.sendRedirect("success.html");
			//out.print("<h2>Dept is added</h2>");
			request.setAttribute("msg", "product is updated successfully.");
			request.setAttribute("Product Model-ID", 	ProductModelId);
			
			request.setAttribute("name", 	ProductName);
			request.setAttribute("description", 	ProductDescription);
			request.setAttribute("feature", 	ProductFeatures);
			request.setAttribute("price", 	ProductPrice);
			request.setAttribute("thresold", 	ProductThreshold);
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
