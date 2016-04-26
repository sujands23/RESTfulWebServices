package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.InventoryDAO;
import model.dao.ProductModelDAO;
import model.pojo.ProductModel;

/**
 * Servlet implementation class ThresholdController
 */
public class ThresholdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThresholdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("error",0);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productModelId=request.getParameter("PMID");
		System.out.println("PId is: "+productModelId);
		//capturing the Product Model to be viewed in an ArrayList of type ProductModel
		int curquantity=InventoryDAO.getQuantityIntoDB(productModelId); 
		//ProductModel product=new ProductModel("",productquantity+"");
	

		
		ProductModel pm=ProductModelDAO.viewSingleProductModel(productModelId);
		System.out.println(pm);
		int threshold=pm.getThreshold();
		
		int criticalValue=curquantity-threshold;
		String suggestion=null;
		String color=null;
		if(curquantity==0)
		{
			suggestion="Sorry! You have no product for this model";
			color="OrangeRed";
		}
		else if(criticalValue<0)
		{
			suggestion="Need more Products: Only "+curquantity+"are left";
			color="OrangeRed";
		}
		else if(criticalValue<=10)
		{
			suggestion="On critical situation: Only "+criticalValue+" are left to reach threshold";
			color="Gold";
		}
		else
		{
			suggestion="You have sufficient products for this model";
			color="MediumSeaGreen";
		}
		
		request.setAttribute("suggestion",suggestion);
		request.setAttribute("color",color);
		request.setAttribute("modelId",pm);
		request.setAttribute("quantity",curquantity);
		RequestDispatcher var=request.getRequestDispatcher("thresoldQuantity.jsp");
		var.forward(request,response);
	}


}
