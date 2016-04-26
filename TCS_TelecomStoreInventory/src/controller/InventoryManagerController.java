package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoginDAO;
import model.pojo.Login;

/**
 * Servlet implementation class InventoryManagerController
 */
public class InventoryManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryManagerController() {
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
		// TODO Auto-generated method stub
		Login po=(Login)request.getAttribute("INVENTORYMANAGER");
		LoginDAO d=new LoginDAO();
		boolean k=d.loginValidator(po);
		if(k)
		{
			HttpSession session=request.getSession();
			session.setAttribute("Id", po.getUser_id());


			response.sendRedirect("home.jsp?msg1=logined");
		}
		else
			response.sendRedirect("login.jsp?msg=invalid userid or password");
		
	}

}
