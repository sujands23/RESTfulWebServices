package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.dao.ReadFromCSV;

/**
 * Servlet implementation class ReadFromCsvController
 */
public class ReadFromCsvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFromCsvController() {
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
		try {
			String abc=request.getParameter("multipart/form-data");
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			if (isMultipart) {

			ServletFileUpload servletFileUpload = new ServletFileUpload(
			new DiskFileItemFactory());
			List fileItemsList = servletFileUpload.parseRequest(request);

			Iterator it = fileItemsList.iterator();

			FileItem fileItem = (FileItem) it.next();

			File uploadedFile = new File("C:\\Users\\592675\\Desktop\\upload.csv");

			fileItem.write(uploadedFile);
			ReadFromCSV da=new ReadFromCSV();
			
			int rows=da.createRetailer("C:\\Users\\592675\\Desktop\\upload.csv");
			if(rows==1)
			{
				//System.out.println("inserted");
				//response.sendRedirect("CreateRetailer.jsp?msg=inserted");
				
				request.setAttribute("pojo", abc);
				HttpSession session=request.getSession(false);
				//session.setAttribute("Retailerid", abc.getRetailer_id());
				session.setAttribute("flow","0");
				request.setAttribute("msg", "inserted");
				RequestDispatcher rd=request.getRequestDispatcher("fileUpload.jsp");
				rd.forward(request, response);
			}
			else
				request.setAttribute("msg", "inserted");
				//System.out.println("problem");
			 RequestDispatcher rd=request.getRequestDispatcher("fileUpload.jsp");
			 rd.forward(request, response);
				
			}
			} catch (Exception ex) {
			throw (new ServletException(ex));
			}

			}
	}
