package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DownloadController
 */
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadController() {
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
		
		System.out.println("inside download controller");
		HttpSession session = request.getSession(false); 
		if (session != null) {	
		String filename="C:\\Users\\680084\\Desktop\\download\\dowload.csv";
		response.setContentType("text/comma-separated-values");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\""); 
		download(response); 
		}	
		}
	private void download(HttpServletResponse response) {
		BufferedWriter ow = null; 
		try { 
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\592675\\Desktop\\download\\download.csv")); 
			String line = br.readLine(); 
			ow = new BufferedWriter(response.getWriter()); 
			while (line != null) { 
				ow.write(line);
				ow.newLine(); 
				line = br.readLine(); 
				} ow.flush();
				} catch (Exception exception) { exception.printStackTrace();
				} finally { 
					if (ow != null)
					{
						try {
							ow.close();
							} catch (IOException ioe) {
								ioe.printStackTrace();
								} } } }
		
		
		}
