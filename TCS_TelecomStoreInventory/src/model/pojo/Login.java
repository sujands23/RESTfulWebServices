package model.pojo;

import java.util.ArrayList;

public class Login 
{
		String User_id,Password,Role_tagged;
		String User_name, Address, Email;
		int Contact_no;
				public Login(String userId,String userName, String address,int 

contactNo,String email,String password, String roleTagged)
				{
			super();
			User_id = userId;
			Password = password;
			Role_tagged = roleTagged;
			User_name = userName;
			Address = address;
			Email = email;
			Contact_no = contactNo;
		}

				public String getUser_name() {
			return User_name;
		}

		public void setUser_name(String userName) {
			User_name = userName;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public int getContact_no() {
			return Contact_no;
		}

		public void setContact_no(int contactNo) {
			Contact_no = contactNo;
		}

				public String getUser_id() 
				{
					return User_id;
				}
				
				public Login(String userId, String password, String roleTagged) 
				{
					super();
					User_id = userId;
					Password = password;
					Role_tagged = roleTagged;
				}
				
				public void setUser_id(String userId) 
				{
					User_id = userId;
				}
				
				public String getPassword() 
				{
					return Password;
				}
				
				public void setPassword(String password) 
				{
					Password = password;
				}
				
				public String getRole_tagged() 
				{
					return Role_tagged;
				}
				
				public void setRole_tagged(String roleTagged) 
				{
					Role_tagged = roleTagged;
				}
}