package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductModelDAO;
import model.dao.StockDAO;
import model.pojo.ProductModel;
import model.pojo.ProductStock;

/**
 * Servlet implementation class AddStockController
 */
public class AddStocKController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStocKController() {
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
		String id =request.getParameter("PMID");
		String productName =request.getParameter("PName");
		String ProductStatus=request.getParameter("PStatus");
		System.out.println(id);
		String quan=request.getParameter("Quantity");
		System.out.println(quan);
		ProductModel productModel=ProductModelDAO.viewSingleProductModel(id);
		Integer quantity=Integer.parseInt(quan);
		int rows=0;
		
		for(int i=1;i<=quantity;i++)
		{
			String productCode = StockDAO.generateNewID(id);
			System.out.println("Product code: "+productCode);
		
			ProductStock stock1=new ProductStock(productCode,id,productName,ProductStatus,null);
			System.out.println(productCode);
			rows+=StockDAO.AddStock(stock1);
		}
			
			System.out.println(rows);
			if(rows>=1) //if one row gets added
		{
			request.setAttribute("Type", "Product code:");
			request.setAttribute("status",1);
			request.setAttribute("msg", "Stocks is updated successfully.");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request,response); //displays content only from the last servlet
			//rd.include(request,response);//displays content only from the previous servlet
			
		}
		else //if zero row(s) get added
		{
			request.setAttribute("status",0);
			RequestDispatcher rd=request.getRequestDispatcher("/addproductstock.jsp");
			rd.forward(request,response);
		}
	}
}
