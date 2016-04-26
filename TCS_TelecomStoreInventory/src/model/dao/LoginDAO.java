package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.GetConnection;

import model.pojo.Login;

public class LoginDAO {
	public boolean loginValidator(Login p)
{
	 boolean is=false;
	 Connection con=GetConnection.getConnection();
	 try 
	 {
		 String sql="SELECT PASSWORD,ROLE_TAGGED FROM LOGIN_TBL WHERE USER_ID=?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, p.getUser_id());
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			if(rs.getString(1).equals(p.getPassword())&&(rs.getString(2).equals(p.getRole_tagged())))
			is=true;
		}
				
	} 
	 catch (SQLException e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return is;
}
}
