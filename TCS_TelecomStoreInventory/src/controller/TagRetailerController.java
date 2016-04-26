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


/**
 * Servlet implementation class TagProductController1
 */
public class TagRetailerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagRetailerController() {
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
		String[] checkbox=(request.getParameterValues("tagproduct"));
		String[] rr_Id=null;
		int    result=0;
		String r_Id=null;
		rr_Id=(request.getParameterValues("rid"));
		 for(int i=0;i<rr_Id.length;i++)
		   {
			 r_Id=rr_Id[i];
		   }
		   
		System.out.println(r_Id);
		String p_Id=null;
	    @SuppressWarnings("unused")
		TagProductDAO1 tgpd= new TagProductDAO1();
	    ArrayList<ProductModel> rp = new ArrayList<ProductModel>();
	    rp=tgpd.selecttagProductIntoDB(r_Id);
	    for(ProductModel ss:rp)
		{
	     for(int i=0;i<checkbox.length;i++)
		   {
			
		      if (checkbox[i].equals(ss.getId()))
	    	  
		        { 
		    	  p_Id=ss.getId();
	              result=tgpd.tagProductIntoDB(r_Id,p_Id);	
		        }
				
		   }
		}
	    	
	    if(result==1)
		{
	    	
			request.setAttribute("msg", "HURRAY!!!! Product is TAGGED successfully to the retailer.");
			request.setAttribute("RID",r_Id );
			request.setAttribute("PMID",p_Id); 
			RequestDispatcher reqdp= request.getRequestDispatcher("success.jsp");
			reqdp.forward(request,response);
	
		}
		else
		{
			request.setAttribute("msg", "There is a error!");
			RequestDispatcher reqdp= request.getRequestDispatcher("success.jsp");
			reqdp.forward(request,response);
			
		}
	}
}

