package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 * Servlet implementation class PieChart
 */
public class PieChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PieChart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		String pid=request.getParameter("id");
		System.out.println(pid);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@172.16.60.103:1521:orcl","k32_t1g2","k32_t1g2");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String query = "SELECT PRODUCT_STATUS, count(*) FROM PRODUCT_STOCK_TBL where PRODUCTMODEL_ID='"+pid+"' GROUP BY PRODUCT_STATUS  ";
		try{
			JDBCPieDataset dataset = new JDBCPieDataset(connection);
			dataset.executeQuery(query);
			JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset, true, true, false);
			System.out.println(getServletContext().getRealPath("Piechart.jpeg"));
			ChartUtilities.saveChartAsJPEG(new File(getServletContext().getRealPath("Piechart.jpeg")),chart,400, 300); 
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("No chart creation.");
		}
		request.getRequestDispatcher("/ShowChart.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
