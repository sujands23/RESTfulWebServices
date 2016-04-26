package model.dao;


import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.pojo.RetailerInfo;
import conn.GetConnection;



public class RetailerDAO {

	public static int addRetailer(RetailerInfo RI)
	{
		Connection conn=GetConnection.getConnection();
		
		try
		{
		String sql="insert into RTL_INFO_TBL values(?,?,?,?,?)";
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, RI.getRETAILER_ID());
		st.setString(2, RI.getRETAILER_NAME());
		st.setString(3, RI.getLOCATION());
		st.setString(4, RI.getLICENCE_NUMBER());
		st.setString(5, RI.getUSER_ID());
		
		
		
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
public static ArrayList <RetailerInfo> searchAllRetailerId(){
		
		ArrayList<RetailerInfo> idlist= new ArrayList<RetailerInfo>();
		
		Connection conn=GetConnection.getConnection();
		try
		{
			String sql="select * from RTL_INFO_TBL";
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				RetailerInfo rtinfo= new RetailerInfo(rs.getString("RETAILER_ID"),rs.getString("RETAILER_NAME"),rs.getString("LOCATION"),rs.getString("LICENCE_NUMBER"),rs.getString("USER_ID"));
				idlist.add(rtinfo);
			}
			
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
		return idlist;
	}
public static ArrayList<RetailerInfo> ViewAllRetailer()
{
	Connection conn=GetConnection.getConnection();

	ArrayList<RetailerInfo> pmAl=new ArrayList<RetailerInfo>();
	try{

		String sql="select * from RTL_INFO_TBL";
		Statement st=conn.createStatement();			
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{

			String rId=rs.getString("RETAILER_ID");
			String rName = rs.getString("RETAILER_NAME");
			String rLocation = rs.getString("LOCATION");
			String rLicNo=rs.getString("LICENCE_NUMBER");
			String uId=rs.getString("USER_ID");			
			
			RetailerInfo pm=new RetailerInfo(rId, rName, rLocation,rLicNo,uId);
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

   public static String generateNewRetailerID() {
	// TODO Auto-generated method stub
	int newRetailerId=0;
	ArrayList<RetailerInfo> retailerList=ViewAllRetailer();
	for(RetailerInfo retailer:retailerList)
		if(Integer.parseInt(retailer.getRETAILER_ID().substring(3))>newRetailerId)
		
	newRetailerId=Integer.parseInt(retailer.getRETAILER_ID().substring(3));
	newRetailerId+=1;
	String newRetId="";
	if(newRetailerId<10)	
		 newRetId="RET00"+newRetailerId;
	else if(newRetailerId<100)
		 newRetId="RET0"+newRetailerId;
	else if(newRetailerId<1000)
		 newRetId="RET"+newRetailerId;
	System.out.println("retailerId is: "+ newRetId);
	return  newRetId;
}
	
}

