package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Customer;

public class BankService implements BankInter {
String uname ="root";
String pass ="TEJa@123";
String url ="jdbc:mysql://localhost:3306/Bank";
	
	@Override
	public void addcustomer(Customer c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			  String query = "INSERT INTO Bank VALUES (" + c.getAcno() + ", '" + c.getUname() + "', " + c.getBalance() + ");";
		     int rs =  st.executeUpdate(query);
		     if(rs>0) {
		    	 System.out.println("suscessfully registed");
		     }else {
		    	 System.out.println("unable to register");
		     }
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
	
	}

	@Override
	public void deletecustomer(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			String query = "DELETE FROM Bank WHERE acno ="+id+";" ;
			int r = st.executeUpdate(query);
			if(r>0) {
				System.out.println("Delete sucessfully");
			}
			else {
				System.out.println("invalid user Id");
			}
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer getcustomer(int id) {
		Customer c = new Customer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			String query = "Select * FROM Bank where acno= "+id+";";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
		c.setAcno(rs.getInt(1));
		c.setBalance(rs.getDouble(3));
		c.setUname(rs.getString(2));
			}
			return c;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Customer> getallcustomer() {
		
		ArrayList<Customer> ct = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			String query = "Select * FROM Bank;";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Customer c = new Customer();
				c.setAcno(rs.getInt(1));
				c.setBalance(rs.getDouble(3));
				c.setUname(rs.getString(2));
		        ct.add(c);
			}
			return ct;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public void withdraw(int x, double amount) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			Customer c = getcustomer(x);
			double total = c.getBalance() - amount;

			String query = "update bank set balance = "+total+ " where acno = "+x+";" ;
			int r = st.executeUpdate(query);
			if(r>0) {
				System.out.println("withdraw   sucessfully");
			}
			else {
				System.out.println("unable to withdraw");
			}
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deposit(int x, double amount) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			Customer c = getcustomer(x);
			double total = c.getBalance() + amount;

			String query = "update bank set balance = "+total+ " where acno = "+x+";" ;
			int r = st.executeUpdate(query);
			if(r>0) {
				System.out.println("deposit  sucessfully");
			}
			else {
				System.out.println("unable to deposit");
			}
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
