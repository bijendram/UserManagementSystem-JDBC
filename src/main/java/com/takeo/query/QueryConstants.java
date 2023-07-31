package com.takeo.query;

public interface QueryConstants {
	
	public String User_Insert_Query="insert into login(first_name,last_name,email,username,password)values(?,?,?,?,?)";
	
	public String User_SELECT_QUERY="select *From login";
	
	public String USER_VALID_QUERY="select *from login where email=? and password=?";

}
