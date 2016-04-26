package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.dao.TagProductDAO1;
import model.pojo.ProductModel;
import model.pojo.RetailerProduct;


/**
 * Servlet implementation class TagProductController1
 */
public class TagRetailerController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagRetailerController1() {
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
		ArrayList<ProductModel> rp = new ArrayList<ProductModel>();
		String r_Id=request.getParameter("RID");
        TagProductDAO1 tgpd= new TagProductDAO1();
	    rp=tgpd.selecttagProductIntoDB(r_Id);
	     request.setAttribute("temp", rp);
		RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/tagProducts.jsp");
		rd.forward(request, response);	
	   
	}
}

