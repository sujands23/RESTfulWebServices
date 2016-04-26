package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.PackageDAO;
import model.dao.ProductModelDAO;
import model.pojo.ProductModel;
import model.pojo.RewardPackage;

/**
 * Servlet implementation class ViewPackageController1
 */
public class ViewPackageController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPackageController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("error",0);
		RequestDispatcher rd=request.getRequestDispatcher("homeRetailer.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//receiving input from the user interface in the form of request object

		String Order_value=request.getParameter("PMID");
		System.out.println("OId is: "+Order_value);
		//capturing the Product Model to be viewed in an ArrayList of type ProductModel
		RewardPackage productModelList=PackageDAO.viewSingleProductModel(Order_value); 
		request.setAttribute("PList", productModelList);
		request.getRequestDispatcher("viewPackageRetailer.jsp").forward(request, response);

	}
}
