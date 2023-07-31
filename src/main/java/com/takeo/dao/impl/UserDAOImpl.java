package com.takeo.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.takeo.configure.JdbcUtility;
import com.takeo.dao.UserDAO;
import com.takeo.model.User;
import com.takeo.query.QueryConstants;

public class UserDAOImpl implements UserDAO {
	
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	public String register(User user) {
		// TODO Auto-generated method stub
		
		String msg="";
		try {
		//to store the data into the data base
			con=JdbcUtility.getConnection();
			
			//prepared Statement
			ps=con.prepareStatement(QueryConstants.User_Insert_Query);
			
			//set the values
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getUserName());
			ps.setString(5, user.getPassWord());
			
			int count = ps.executeUpdate();
			
			
			
			if(count !=0)
				msg="User Registeration is Done :) ";
			else
				msg="User Registration Is Not Done, Try Again Later :( ";
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
		try {
			JdbcUtility.closeConnection(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return msg;
	}

	public List<User> viewRegister() {
		// TODO Auto-generated method stub
		List<User> addUsers=new ArrayList<User>();
		
		
		try {
			
			con= JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.User_SELECT_QUERY);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				int uid=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String uname=rs.getString(5);
				String pass=rs.getString(6);
				
				User user=new User(uid,fname,lname,email,uname,pass);
				
				addUsers.add(user);
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return addUsers;
	}

	public boolean verifyEmailAndPassword(String email, String pass) {
		// TODO Auto-generated method stub
		
		boolean flag=false;
		try {
			
			
			con=JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.USER_VALID_QUERY);
			
			ps.setString(1, email);
			
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			if(rs.next())   //move the cursor from first record to FirstRecord
				flag=true;
			else
				flag=false;
			
			
					
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return false;
	}
	

}
