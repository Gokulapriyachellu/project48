package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import models.SigninModel;

public class SigninController {
	static String dbUrl="jdbc:mysql://localhost:3306/new";
    static String dbUname="root";
    static String dbPassword="";
    static String dbDriver="com.mysql.cj.jdbc.Driver";
	SigninModel sn ;	
	public SigninController(SigninModel sn ){
		this. sn =sn ;
	}
	public boolean toGet() {
		 // System.out.println(name+"\n"+pass+"\n"+email+"\n"+phoneno);
		  Connection con = null;
	   		try{
	   			Class.forName(dbDriver);  //class not found exception
	 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
	 			String sql = "select * from data where name='"+sn.getName()+"' and password='"+sn.getPass()+"'";	 			
                Statement sc = con.createStatement();
	 			ResultSet rs=sc.executeQuery(sql);
	 			if(rs.next()) {
	 				con.close();
	 				return true;
	 			}
	 			con.close();
	 			return false;
	 		    
	 		   	
			} catch(Exception e){      
				e.printStackTrace();
			}
	   		return false;
}}
