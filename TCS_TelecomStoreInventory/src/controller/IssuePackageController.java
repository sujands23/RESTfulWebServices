package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.IssuePackageDAO;
import model.pojo.RetailerReward;

/**
 * Servlet implementation class IssuePackageController
 */
public class IssuePackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuePackageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String RETID = request.getParameter("RETID");
		String CPID = request.getParameter("CPID");
		
		String RewardStatus = "Issued";
		String RewardID = "RW";
		RewardID += IssuePackageDAO.generateRewardID();
		RetailerReward temp = new RetailerReward(RewardID,RETID,CPID,RewardStatus);
		IssuePackageDAO.issuePackage(temp);
		request.setAttribute("msg", "Package is issued successfully.");
		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
		rd.forward(request,response); //displays content only from the last servlet
		
		
	}

}
