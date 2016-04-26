package model.dao;

import java.sql.Connection; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.pojo.ProductModel;


import conn.GetConnection;



public class InventoryDAO {
	//method to insert quantity of a product in inventory
	public static int insertInventoryIntoDB(ProductModel pm)
	{
		Connection conn=GetConnection.getConnection();
		try
		{
		String sql="insert into INVENTORY_TBL values(?,?)"; 
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1,pm.getId());
		int qty=Integer.parseInt(pm.getQuantity());
		st.setInt(2,qty);
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
	
	//method to get quantity of a product from inventory
	
//method to get quantity of a product from inventory
	
	public static int getQuantityIntoDB(String productModelId)
	{
		String sql="select QUANTITY from INVENTORY_TBL where PRODUCTMODEL_ID=?";
		PreparedStatement pst;
		int qua=0;
		Connection conn=GetConnection.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, productModelId);
			ResultSet rs= pst.executeQuery();
			if(rs.next())
			qua=rs.getInt("QUANTITY");
			
					}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qua;
	}
	
	//method to update quantity of a  product model in inventory
	/*
	public static int updateQuantity(String productModelId,String quantity)//direct call required from controller 
	{
		Connection conn=GetConnection.getConnection();
		String sql="update INVENTORY_TBL set QUANTITY=QUANTITY+? where PRODUCTMODEL_ID=?";
		
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, quantity);
			pst.setString(2, productModelId);
			int rs= pst.executeUpdate();
			if(rs>0)
				return 1;
			else 
				return 0;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return -1;
			}
		
	}*/
	
	//method to delete a particular product details in inventory
	
	public static int deleteProductModelFromInventoryDB(String productModelId)
	{
		Connection conn=GetConnection.getConnection();
		try{
			
			String sql="delete from INVENTORY_TBL where PRODUCTMODEL_ID=?";
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
	public static int updateQuantityIntoDB(String productModelId,String quantity)
	{
		Connection conn=GetConnection.getConnection();
		String sql="update INVENTORY_TBL set QUANTITY=QUANTITY+? where PRODUCTMODEL_ID=?";
		PreparedStatement pst;
		int result=0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(quantity));
			pst.setString(2, productModelId);
			result= pst.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
}

	public static int insertInventoryIntoDB(String id, String quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

}