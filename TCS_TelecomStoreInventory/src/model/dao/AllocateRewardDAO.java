package model.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conn.GetConnection;

import model.pojo.RetailerReward;





public class AllocateRewardDAO {
	//method to insert retailer reward details into the database 
	public static int insertRetailerReward(RetailerReward rr)
	{
		Connection conn=GetConnection.getConnection();
		try{
			
			String sql1="insert into RETAILER_REWARD values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql1);
			
			
			
			ps.setString(1, rr.getRewardId());
			ps.setString(2, rr.getRetailerId());
			ps.setString(3, rr.getPackageId());
			ps.setDate(4, Date.valueOf(rr.getRewardDate()));
			ps.setString(5, rr.getRewardStatus());
			int rows=ps.executeUpdate();
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

	//method to generate unique reward id for every retailer reward record
	public static String generateNewID() {
		Connection conn=GetConnection.getConnection();
		// TODO Auto-generated method stub
		String sql="Select seq_reward.nextval from dual";
		try {
			String id=null;
			Statement st=conn.prepareStatement(sql);
			ResultSet res=st.executeQuery(sql);
			while(res.next())
				id="RW_"+res.getString(1);
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
    
	//method to display order dates corresponding to a selected retailer id
	public static ArrayList<String> displayOrderDateFromDB(String RetailerId)
	{
		Connection conn=GetConnection.getConnection();
		ArrayList<String> dateList=new ArrayList<String>();
		String sql="select distinct(ORDER_DATE) from ORDER_TBL_T2 where RETAILER_ID=?";
		PreparedStatement pst;
		try
		{
			pst = conn.prepareStatement(sql);
			pst.setString(1, RetailerId);
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				String orderDate=rs.getString(1);
				dateList.add(orderDate);
			}
			return dateList;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	//method to select a package id for a selected retailer id 
	public static RetailerReward insertRetailerRewardToDB1( String orderDate,String retailerId)
	{
		Connection conn=GetConnection.getConnection();
		String sql1="select RETAILER_ID,PACKAGE_ID from (select RETAILER_ID,sum(ORDER_AMOUNT) as sumtotal from ORDER_TBL_T2 where RETAILER_ID=?" +
				" AND ORDER_DATE=? group by order_date,retailer_id) table1 join (select PACKAGE_ID,ELIGIB_CRI from COMP_PACKAGE_T2 order by ELIGIB_CRI desc)table2 on table1.sumtotal>=table2.ELIGIB_CRI";
		PreparedStatement pst;
		System.out.println(sql1);
		try {
			pst = conn.prepareStatement(sql1);
			pst.setString(1, retailerId);
			pst.setDate(2, Date.valueOf(orderDate));
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				RetailerReward RR=new RetailerReward(rs.getString("RETAILER_ID"),rs.getString("PACKAGE_ID"),"Allocated");
				RR.setRewardDate(orderDate);
				return RR;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static int checkRewardGeneration(String orderDate, String retailerId)
	{
		Connection conn=GetConnection.getConnection();
		String sql="select * from RETAILER_REWARD_T2 where REWARD_DATE=? and RETAILER_ID=?"; 
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			st.setDate(1, Date.valueOf(orderDate));
			st.setString(2, retailerId);
			int val=st.executeUpdate();
			if(val>=1)
				return 0;
			else return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

