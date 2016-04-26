package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.pojo.RetailerReward;

import conn.GetConnection;

public class IssuePackageDAO 
{
	
	public static ArrayList<String> viewAllRetailerID()
	{
		ArrayList<String> RetailerIDList = new ArrayList<String>();
		
		Connection conn=GetConnection.getConnection();
		try
		{
			
		String sql = "Select RETAILER_NAME from RTL_INFO_TBL";
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		if(rs!=null)
		{
			while(rs.next())
			{
				String retId = rs.getString(1);
				RetailerIDList.add(retId);	
			}
			return RetailerIDList;
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
	
	public static ArrayList<String> viewAllPackageID()
	{
		ArrayList<String> PackageIDList = new ArrayList<String>();
		
		Connection conn=GetConnection.getConnection();
		try
		{
			
		String sql = "Select OFFERS from COMP_PACKAGE_TBL";
		PreparedStatement st=conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		if(rs!=null)
		{
			while(rs.next())
			{
				String CPId = rs.getString(1);
				PackageIDList.add(CPId);	
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


	public static int issuePackage(RetailerReward newPackage)
	{
		Connection conn = GetConnection.getConnection();
		try
		{
			String stmt = "Insert into RETAILER_REWARDS_TBL values(?,?,?,SYSDATE,?)";
			PreparedStatement pst=conn.prepareStatement(stmt);
			pst.setString(1,newPackage.getRewardId());
			pst.setString(2,newPackage.getRetailerId());
			pst.setString(3,newPackage.getPackageId());
			pst.setString(4,newPackage.getRewardStatus());
			if(pst.execute())
			{
				return 1;
			}
			else return 0;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
		public static int generateRewardID()
		{
			Connection conn=GetConnection.getConnection();
			ArrayList<Integer> rewardID = new ArrayList<Integer>();
			int newRewardID=0,count=0;
			ResultSet rs = null;
			try
			{
				String stmt = "Select REWARD_ID from RETAILER_REWARDS_TBL";
				PreparedStatement pst=conn.prepareStatement(stmt);
				rs = pst.executeQuery();
				if(rs == null)
				{
					newRewardID = 1;
					return newRewardID;
				}
				else
				{
					while(rs.next())
					{
						Integer i;
						
						i= Integer.parseInt(rs.getString(1).substring(2));
						rewardID.add(i);
						if(i>newRewardID)
						newRewardID = i;
						count++;
					}
					return (newRewardID+1);
				}
			}
				catch(SQLException e)
				{
					e.printStackTrace();
					return -1;
				}
			
			}					
}
	



