package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductModelDAO;
import model.pojo.RetailerProduct;

/**
 * Servlet implementation class ViewBeforeDeleteController
 */
public class ViewBeforeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBeforeDeleteController() {
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
		String pid=request.getParameter("id");
		System.out.println(pid);
		ArrayList<RetailerProduct> rp=new ArrayList<RetailerProduct>();
	    ProductModelDAO pd=new ProductModelDAO();
		rp=pd.deleteProductModel2(pid);
		request.setAttribute("temp", rp);
		RequestDispatcher view=getServletContext().getRequestDispatcher("/confirmDeletion.jsp");
		view.forward(request, response);
	}
}


