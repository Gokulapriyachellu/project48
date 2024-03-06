package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import models.SignupModel;

public class SignupController {
	static String dbUrl="jdbc:mysql://localhost:3306/new";
    static String dbUname="root";
    static String dbPassword="";
    static String dbDriver="com.mysql.cj.jdbc.Driver";
	SignupModel sm;
	public SignupController(SignupModel sm){
		this.sm=sm;
	}
	public void toStore() {
		 // System.out.println(name+"\n"+pass+"\n"+email+"\n"+phoneno);
		  Connection con = null;
	   		try{
	   			Class.forName(dbDriver);  //class not found exception
	 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
	 			String sql = "insert into data (name,password,email,phoneno)"
	 					+ "values('"+sm.getName()+"','"+sm.getPass()+"','"+sm.getEmail()+"','"+sm.getPhoneno()+"')";
	 			Statement s = con.createStatement();
	 			s.execute(sql);
	 		    
	 		   	con.close();
			} catch(Exception e){      
				e.printStackTrace();
			}
	

}
}
