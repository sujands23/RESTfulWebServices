package model.dao;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import conn.GetConnection;
import model.pojo.ProductModel;
import model.pojo.ProductStock;
import model.pojo.RetailerProduct;



public class ProductModelDAO {
	public static int insertProductModelIntoDB(ProductModel P)
	
	{
		Connection conn=GetConnection.getConnection();
		
		try{
			
			String sql="insert into PRODUCTMODEL_INFO_TBL values(?,?,?,?,?,?)";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, P.getId());
			st.setString(2, P.getName());
			st.setString(3, P.getDescription());
			st.setString(4, P.getFeatures());
			st.setDouble(5, P.getPrice());
			st.setInt(6, P.getThreshold());
			
			int rows=st.executeUpdate();
			if(rows>0)
				return 1;
			else return 0;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		
	}
	
	public static String insertProductModel(ProductModel P)
	{
		Connection conn=GetConnection.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String pmid=ProductModelDAO.generateNewID();
		P.setId(pmid);
		int val2=ProductModelDAO.insertProductModelIntoDB(P);
		String qty="0";
		ProductModel pm=new ProductModel(pmid, qty);
		int val1=InventoryDAO.insertInventoryIntoDB(pm);
		
		
		if(val1==1 && val2==1){
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return P.getId();
		}
		else {
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public static ArrayList<ProductModel> viewAllProductModel()
	{
		Connection conn=GetConnection.getConnection();
		
		ArrayList<ProductModel> pmAl=new ArrayList<ProductModel>();
		try{
			
					//String sql="select * from PRODUCTMODEL_INFO_TBL";
					PreparedStatement pst=conn.prepareStatement("select * from PRODUCTMODEL_INFO_TBL");
					//Statement st=conn.preparedStatement();			
					ResultSet rs=pst.executeQuery();
					while(rs.next())
						{
						
						  String id=rs.getString("PRODUCTMODEL_ID");
						  String name = rs.getString("PRODUCTMODEL_NAME");
						  String description = rs.getString("PRODUCTMODEL_DESCRIPTION");
						  String features= rs.getString("PRODUCTMODEL_FEATURES");
						  double price=rs.getInt("PRODUCTMODEL_PRICE");
						  int threshold=rs.getInt("PRODUCTMODEL_THRESHOLD");
					
						  ProductModel pm=new ProductModel(id, name, description, features, price, threshold);
						  pmAl.add(pm);
						}
					//System.out.println("LEngth of ARRAYLISt"+pmAl.size());
			
			}
			catch (SQLException e)
					{
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
			}
			return pmAl;
	}
	public static ProductModel viewSingleProductModel(String P)
	{
		Connection conn=GetConnection.getConnection();
		
		try{
			ProductModel pm=null;
			String sql="select * from PRODUCTMODEL_INFO_TBL where PRODUCTMODEL_ID=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, P);
			ResultSet rs=st.executeQuery();
			while(rs.next())
				{
				
				  String id=rs.getString("PRODUCTMODEL_ID");
				  String name = rs.getString("PRODUCTMODEL_NAME");
				  String description = rs.getString("PRODUCTMODEL_DESCRIPTION");
				  String features= rs.getString("PRODUCTMODEL_FEATURES");
				  double price=rs.getInt("PRODUCTMODEL_PRICE");
				  int threshold=rs.getInt("PRODUCTMODEL_THRESHOLD");
				
				  pm=new ProductModel(id, name, description, features, price, threshold);
		
				}
			
			return pm;
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
	}
	
	public static ArrayList<RetailerProduct> deleteProductModel2(String P)
	{   
		System.out.println("in dao"+P);
		Connection conn=GetConnection.getConnection();
		String id,mid;
		ArrayList<RetailerProduct> rplist=new ArrayList<RetailerProduct>();
		try{
			
			String sql="select RETAILER_ID,PRODUCTMODEL_ID from RTL_PRODUCTMODEL_TBL where PRODUCTMODEL_ID=?"; 
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,P);
			ResultSet rs=st.executeQuery();
			
			while(rs.next())
			{
				
				id=rs.getString(1);
				mid=rs.getString(2);
				RetailerProduct rp=new RetailerProduct(id,mid);
				rplist.add(rp);
			}
			
		}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
			if(rplist.size()==0)
			{  
				RetailerProduct rp=new RetailerProduct(P);
				rplist.add(rp);
				return rplist;
			}
			else
			{
				return rplist;
			}
	}
	
	
	public static int deleteProductModel1(String P)
	{
		Connection conn=GetConnection.getConnection();
		
		try{
			
			String sql="delete from PRODUCTMODEL_INFO_TBL where PRODUCTMODEL_ID=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, P);
			int rows=st.executeUpdate();
			System.out.println(rows);
			if(rows>0)
				return 1;
			else return 0;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return -1;
			}
		
	}
	
	public static int deleteProductModel(String id)
	{
		try{
			Connection conn=GetConnection.getConnection();
		conn.setAutoCommit(false);
		System.out.println(id);
		
		int val1=InventoryDAO.deleteProductModelFromInventoryDB(id);
		int val2=StockDAO.deletePS(id);
		int val3=TagProductDAO1.unTagRetailer(id);
		int val=ProductModelDAO.deleteProductModel1(id);
		if(val1==1 && val2==1 && val3==1 && val==1) {
			conn.commit();
			conn.close();
			return 1;
		}
		else {
			conn.rollback();
			conn.close();
			return 0;
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static int updateProductModel(String id,ProductModel p1)
	{
		Connection conn=GetConnection.getConnection();
		
		String sql="update PRODUCTMODEL_INFO_TBL set PRODUCTMODEL_NAME=?,PRODUCTMODEL_DESCRIPTION=?,PRODUCTMODEL_FEATURES=?,PRODUCTMODEL_PRICE=?,PRODUCTMODEL_THRESHOLD=? WHERE PRODUCTMODEL_ID=?";	
		int successUpdate=0;
		try{
		PreparedStatement st=conn.prepareStatement(sql);
		
		st.setString(1, p1.getName());
		st.setString(2, p1.getDescription());
		st.setString(3, p1.getFeatures());
		st.setDouble(4, p1.getPrice());
		st.setInt(5, p1.getThreshold());
		st.setString(6, p1.getId());
		
		successUpdate=st.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		if(successUpdate==1)
			return 1;
		else 
			return 0;
			
	}
			
	public static String generateNewID() {
		// TODO Auto-generated method stub
		int newId=0;
		ArrayList<ProductModel> productList=viewAllProductModel();
		for(ProductModel product:productList)
			if(Integer.parseInt(product.getId().substring(3))>newId)
				newId=Integer.parseInt(product.getId().substring(3));
		newId+=1;
		String newProductid="";
		if(newId<10)	
			newProductid="PRD00"+newId;
		else if(newId<100)
			newProductid="PRD0"+newId;
		else if(newId<1000)
			newProductid="PRD"+newId;
		System.out.println("Id is: "+newProductid);
		return newProductid;
	}
	public static ArrayList<ProductModel> viewAllUntaggedProductModel(
			Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<ProductModel> pmAl=new ArrayList<ProductModel>();
		try{
			
			String sql="select * from PRODUCTMODEL_INFO_TBL WHERE STATUS='untagged'";
			Statement st=conn.createStatement();			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
				{
				
				  String id=rs.getString("PRODUCTMODEL_ID");
				  String name = rs.getString("PRODUCTMODEL_NAME");
				  String description = rs.getString("PRODUCTMODEL_DESCRIPTION");
				  String features= rs.getString("PRODUCTMODEL_FEATURES");
				  double price=rs.getInt("PRODUCTMODEL_PRICE");
				  int threshold=rs.getInt("PRODUCTMODEL_THRESHOLD");
				
				  ProductModel pm=new ProductModel(id, name, description, features,  price, threshold);
				  pmAl.add(pm);
				}
			
			return pmAl;
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		
		
		
	}
	public static Integer getQuantityIntoDB(String productModelId) {
		// TODO Auto-generated method stub
		Connection conn=GetConnection.getConnection();
		int val=InventoryDAO.getQuantityIntoDB(productModelId);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}

	public static ProductModel searchProductModel(String modelId) {
		Connection con = null;
		con = GetConnection.getConnection();
		PreparedStatement pst;
		ProductModel pm=null;
		try {

			pst = con.prepareStatement("select * from productmodel_info_tbl where productmodel_id=?");
			pst.setString(1, modelId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {			
				 pm = new ProductModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pm;
	}

	
}
