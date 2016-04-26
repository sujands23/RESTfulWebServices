package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import model.pojo.ProductModel;
import model.pojo.RetailerProduct;



import conn.GetConnection;
public class TagProductDAO1 {
	//method to tag product called by TagProductControlDAO

	public static int tagProductIntoDB(String retailerId,String productId)
	{
		Connection conn=GetConnection.getConnection();
		try
		{
			String sql="insert into RTL_PRODUCTMODEL_TBL values(?,?,SYSDATE)"; 
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, retailerId);
			st.setString(2, productId);
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

	public static ArrayList<ProductModel> selecttagProductIntoDB(String rtlid)
	{  
		ArrayList<RetailerProduct> rplist=new ArrayList<RetailerProduct>();
		ArrayList<ProductModel> rplist1=new ArrayList<ProductModel>();
		String id=null;
		boolean flag=true;
		String rid=null;
		String name=null;
		String check=null;
		String pid=null;
		System.out.println("in dao"+rtlid);
		Connection conn=GetConnection.getConnection();
		try
		{
			String sql="select PRODUCTMODEL_ID from RTL_PRODUCTMODEL_TBL where RETAILER_ID=?"; 
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,rtlid );
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				
				pid=rs.getString(1);
				
				RetailerProduct rp=new RetailerProduct(pid,rtlid);
				rplist.add(rp);
			}
			sql="select PRODUCTMODEL_ID,PRODUCTMODEL_NAME from PRODUCTMODEL_INFO_TBL ";
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next())
			{
				flag=true;
				check=rs.getString(1);
				for(RetailerProduct rppp:rplist)
				{
					if(check.equals(rppp.getProductmodelid()))
					{
						System.out.println(rppp.getProductmodelid());
						System.out.println(check);

						flag=false;
						System.out.println(flag);
					}
				}
				System.out.println( flag);  
				if(flag==true)
				{   
					id=rs.getString(1);
					name=rs.getString(2);
					ProductModel pm=new ProductModel(id,rtlid,name);
					rplist1.add(pm);
				}
			}

			/*	for(ProductModel ppp:rplist1)
		{
			check=ppp.getId();
			for(RetailerProduct rppp:rplist)
			{
				if(check.equals(rppp.getProductmodelid()))
				{
					rplist1.remove(ppp);
				}
			}
		}*/
		}
		catch(SQLException e)
		{
			e.printStackTrace();

		}
		return rplist1;
	}
	//method to change untag status called by TagProductControlDAO

	/*public static int changeUntagStatus( String productId) {
		// TODO Auto-generated method stub
		Connection conn=GetConnection.getConnection();
		try
		{
		String sql="UPDATE PRODUCT_MODEL_INFO SET STATUS='tagged' WHERE PRODUCTMODEL_ID=?"; 
		PreparedStatement st=conn.prepareStatement(sql);			
		st.setString(1, productId);
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

	}*/

	public static int unTagRetailer(String productModelId)
	{

		Connection conn=GetConnection.getConnection();

		try{

			String sql="delete from RTL_PRODUCTMODEL_TBL where PRODUCTMODEL_ID=?";
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



}
