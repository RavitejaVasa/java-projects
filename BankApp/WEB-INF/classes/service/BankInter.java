package service;



import java.util.ArrayList;

import model.Customer;

public interface BankInter {
	
	public void addcustomer(Customer c);
	public void deletecustomer(int id);
	public Customer getcustomer(int id );
	public ArrayList<Customer> getallcustomer();
	public void withdraw(int x, double amount);
	public void deposit(int x, double amount);
	
	

}
