package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.pojo.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.dao.*;
/**
 * Servlet implementation class UpdateProductController1
 */
public class UpdateProductController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController1() {
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
		
		 String productmodid=request.getParameter("id");
		 ProductModel pm=null;
		pm=ProductModelDAO.viewSingleProductModel(productmodid);
		request.setAttribute("temp2", pm);
		RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/updateProduct11.jsp");
		rd.forward(request, response);	
	}

}
