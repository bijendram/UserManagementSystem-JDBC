package com.takeo.client;

import java.util.List;
import java.util.Scanner;

import com.takeo.dao.impl.UserDAOImpl;
import com.takeo.model.User;

public class UserClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAOImpl daoImpl=new UserDAOImpl();
		
		
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		
		System.out.println("===========================================");
		System.out.println("              1)Register     ");
		System.out.println("              2)Login     ");
		System.out.println("              3)viewUsers    ");
		System.out.println("              4)Exit     ");
		
		
		System.out.println("===========================================");
		
		System.out.println("Enter The Choise");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			//Read the data from console
			System.out.println("Enter First name");
			String fname=sc.next();
			System.out.println("Enter The Last Name");
			String lname=sc.next();
			System.out.println("Enter The Email");
			String email=sc.next();
			System.out.println("Enter The User Name");
			String uname=sc.next();
			System.out.println("Enter The PassWord");
			String pass=sc.next();
			
			User user=new User(fname,lname,email,uname,pass);
			
			String msg=daoImpl.register(user);
			
			if(msg !=null)
				System.out.println(msg);
			else
				System.out.println(msg);
			
			break;
			
		case 2:
			System.out.println("Enter The Email");
			String email1=sc.next();
			System.out.println("Enter The PassWord");
			String pass1=sc.next();
			boolean verifyEmailAndPassword=daoImpl.verifyEmailAndPassword(email1, pass1);
			
			if(verifyEmailAndPassword)
			{
				List<User>viewRegister=daoImpl.viewRegister();
				
				for(User u: viewRegister)
				{
					System.out.println(u.getUid()+"\t"+u.getFirstName()+"\t"+u.getLastName()+"\t"+u.getEmail()+"\t"+u.getUserName()+"\t"+u.getPassWord());
					
				}  //end of for loop
			}   //end of if loop
			else
				System.out.println("Invalid Email and Password");
			break;
			
		case 3:
			List<User>viewUser=daoImpl.viewRegister();
			
			for(User u: viewUser)
			{
				System.out.println(u.getUid()+"\t"+u.getFirstName()+"\t"+u.getLastName()+"\t"+u.getEmail()+"\t"+u.getUserName()+"\t"+u.getPassWord());
				
			}
			break;
			
		case 4:
			System.out.println("Thank you for visiting!!!");
			System.exit(0);
			break;
			
			default:
				System.out.println("Choose between 1 to 4");
			
		
		} //end of switch loop
		}

	}

}
