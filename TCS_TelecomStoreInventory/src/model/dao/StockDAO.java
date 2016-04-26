package model.dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.connector.Request;

import model.pojo.ProductModel;
import model.pojo.ProductStock;

import conn.GetConnection;


public class StockDAO {


	public static int AddStock(ProductStock PS)
	{
		Connection conn=GetConnection.getConnection();

		try
		{
			String sql="insert into PRODUCT_STOCK_TBL values(?,?,?,?,?)";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, PS.getProductCode());
			st.setString(2, PS.getProductModelId());
			st.setString(3, PS.getProductName());
			st.setString(4, PS.getProductStatus());
			st.setString(5, PS.getOrderId());
			System.out.println(PS.getProductCode());


			int rows=st.executeUpdate();
			if(rows>0)
				return 1;
			else 
				return 0;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return -1;
		}
	}

	public static int deletePS(String productModelId)
	{

		Connection conn=GetConnection.getConnection();

		try{

			String sql="delete from PRODUCT_STOCK_TBL where PRODUCTMODEL_ID=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, productModelId);
			int rows=st.executeUpdate();
			if(rows>0)
				return 1;
			else 
				return 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}


	public static int updatePS(String productCode,ProductStock PS)
	{

		Connection conn=GetConnection.getConnection();

		String sql="update PRODUCT_STOCK_TBL set PRODUCT_NAME=?,PRODUCT_STATUS=?,ProductModel_Id=? where PRODUCT_Code=?"; 

		try
		{
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, PS.getProductName());
			pst.setString(2, PS.getProductStatus());
			pst.setString(3, PS.getProductModelId());
			pst.setString(4, PS.getProductCode());
			int rows=pst.executeUpdate();
			if(rows>0)
				return 1;
			else 
				return 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList <ProductStock> searchAllstock(){

		ArrayList<ProductStock> list= new ArrayList<ProductStock>();

		Connection conn=GetConnection.getConnection();
		try
		{
			String sql="select * from PRODUCT_STOCK_TBL";
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				ProductStock PS= new ProductStock(rs.getString("Product_Code"),rs.getString("ProductModel_Id"),rs.getString("Product_Name"),rs.getString("Product_Status"),rs.getString("Order_Id"));
				list.add(PS);
			}


		}
		catch(SQLException e)
		{
			e.printStackTrace();

		}
		return list;
	}

	public static String generateNewID(String productModelId) {
		// TODO Auto-generated method stub
		int newId=0;
		ArrayList<ProductStock> productList=searchAllstock();

		for(ProductStock product:productList)
			if (productModelId.equals(product.getProductModelId()))
				if(Integer.parseInt(product.getProductCode().substring(6))>newId)
					newId=Integer.parseInt(product.getProductCode().substring(6));
		newId+=1;
		String newProductid="";
		if(newId<10)	
			newProductid="PRDMOB000"+newId;
		else if(newId<100)
			newProductid="PRDMOB00"+newId;
		else if(newId<1000)
			newProductid="PRDMOB0"+newId;
		else
			newProductid="PRDMOB"+newId;
		System.out.println("Id is: "+newProductid);
		return newProductid;
	}


}
