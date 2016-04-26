package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pojo.Login;

/**
 * Servlet implementation class LoginAsValidator
 */
public class LoginAsValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAsValidator() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int choice=Integer.parseInt(request.getParameter("login_actor"));
		String id=request.getParameter("login_id");
		String pass=request.getParameter("login_pass");
		switch(choice)
		{
		
		case 1:
			/**
			 * request for Retailer
			 */
			
			Login po=new Login(id,pass,"RETAILER");
			RequestDispatcher requestForRetailer=request.getRequestDispatcher("RetailerLoginController");
			request.setAttribute("Retailer", po);
			requestForRetailer.forward(request, response);
			break;
		case 2:
			/**
			 * request for INVENTORY MANAGER
			 */
			
			Login po1=new Login(id, pass, "INVENTORY MANAGER");
			RequestDispatcher requestForInventoryManager=request.getRequestDispatcher("InventoryManagerController");
			request.setAttribute("INVENTORYMANAGER",po1);
			requestForInventoryManager.forward(request, response);
			break;
		
		
		}
	}

}