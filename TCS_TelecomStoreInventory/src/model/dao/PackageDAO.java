package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.pojo.RewardPackage;
import conn.GetConnection;



public class PackageDAO {
	 
	public static int insertPackage (RewardPackage rwpg)
		{
				Connection conn=GetConnection.getConnection();
					try
						{
							String sql="insert into COMP_PACKAGE_TBL values(?,?,?)";
							PreparedStatement pk=conn.prepareStatement(sql);
							pk.setString(1, rwpg.getId());
							pk.setString(2, rwpg.getOffers());
							pk.setString(3, rwpg.getOrder_value());
							int rows=pk.executeUpdate();
								if(rows>0)
									return 1;
								else 
									return 0;
						}
					catch (SQLException e)
					{
			// TODO Auto-generated catch block
			e.printStackTrace();
				return -1;
					}
		}
							//method to delete a package details called by PackageControlDAO
							
public static int deletePackage(String id)
							{
								Connection conn=GetConnection.getConnection();
								String sql="delete from COMP_PACKAGE_TBL where PACKAGE_ID=?";
								PreparedStatement pst;
								try
								{
								pst = conn.prepareStatement(sql);
								pst.setString(1, id);
								int rs= pst.executeUpdate();
								if(rs>0)
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

//method to view all the complimentary packages
public static ArrayList<RewardPackage> ViewAllPackages()
{
	Connection conn=GetConnection.getConnection();

	ArrayList<RewardPackage> rwpckg=new ArrayList<RewardPackage>();
	try{

		String sql="select * from COMP_PACKAGE_TBL";
		Statement st=conn.createStatement();			
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			String packageid=rs.getString("PACKAGE_ID");
			String offr = rs.getString("OFFERS");
			String ordValue = rs.getString("ORDER_VALUE");
		
			
			RewardPackage pm=new RewardPackage(packageid,offr,ordValue);
			
			rwpckg.add(pm);
		}

		return rwpckg;
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}


public static ArrayList<String> viewAllRetailerID()
{
	ArrayList<String> PackageIDList = new ArrayList<String>();
	
	Connection conn=GetConnection.getConnection();
	try
	{
		
	String sql = "Select Package_ID from COMP_PACKAGE_TBL";
	PreparedStatement st=conn.prepareStatement(sql);
	ResultSet rs = st.executeQuery();
	
	if(rs!=null)
	{
		while(rs.next())
		{
			
			String retId = rs.getString(1);
			PackageIDList.add(retId);	
		}
		return PackageIDList;
	}
	else
	{
		return null;
	}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		return null;
	}
}

//method to generate a new package id

public static String generateNewID() {
	// TODO Auto-generated method stub
	int newpackgId=0;
	ArrayList<RewardPackage> packageList=ViewAllPackages();
	for(RewardPackage packag:packageList)
		if(Integer.parseInt(packag.getId().substring(4))>newpackgId)
			newpackgId=Integer.parseInt(packag.getId().substring(4));
	newpackgId+=1;
	String newPackageid="";
	if(newpackgId<10)	
		newPackageid="CMPD00"+newpackgId;
	else if(newpackgId<100)
		newPackageid="CMPD0"+newpackgId;
	else if(newpackgId<1000)
		newPackageid="CMPD"+newpackgId;
	System.out.println("Id is: "+newPackageid);
	return newPackageid;
}

//@SuppressWarnings("null")
public static int updatePackage(String id,RewardPackage rwpg)
{
	Connection conn=GetConnection.getConnection();
	String sql="update COMP_PACKAGE_TBL set OFFERS=?,Order_value=? where PACKAGE_ID=?";
	
	try
	{
		
	PreparedStatement pk=conn.prepareStatement(sql);
	pk.setString(3, rwpg.getId());	
	pk.setString(1, rwpg.getOffers());
	pk.setString(2, rwpg.getOrder_value());
	int successUpdate=pk.executeUpdate();
	
	
	
	
	if(successUpdate==1)
		return 1;
	else 
		return 0;
}
	catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return 0;
	}
}
//search package
public static ArrayList<RewardPackage> searchAllPackage() {
	// TODO Auto-generated method stub
								ArrayList<RewardPackage> list=new ArrayList<RewardPackage>();
								String sql="select * from COMP_PACKAGE_TBL";
								
								Connection conn=GetConnection.getConnection();
								try {
									PreparedStatement pst = conn.prepareStatement(sql);
									ResultSet rs= pst.executeQuery();
									while(rs.next())
									{
										RewardPackage PK=new RewardPackage(rs.getString("PACKAGE_ID"),rs.getString("OFFERS"),rs.getString("Order_value") );
										list.add(PK);
									}
		
								}
								catch (SQLException e) 
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	
									return list;
}	

public static RewardPackage viewSingleProductModel(String P)
{
	Connection conn=GetConnection.getConnection();
	
	try{
		RewardPackage pm=null;
		String sql="select * from COMP_PACKAGE_TBL where Order_value=?";
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, P);
		ResultSet rs=st.executeQuery();
		while(rs.next())
			{
			
			  String id=rs.getString("PACKAGE_ID");
			  String offers = rs.getString("OFFERS");
			  String orderValue=rs.getString("Order_value");
			 
			  pm=new RewardPackage(id, offers, orderValue);
	
			}
		
		return pm;
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		}
}
}

							