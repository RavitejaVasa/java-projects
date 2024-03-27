package main;


import java.util.ArrayList;

import model.Customer;
import service.BankService;

public class Main {

	public static void main(String[] args) {
		BankService bs = new BankService();
//		Customer c = new Customer(123,"mahesh",3000000);
//		System.out.println(c.toString());
//		bs.addcustomer(c);
//	

	Customer x =bs.getcustomer(2);
	System.out.println(x.getAcno()+"User name :"+x.getUname()+"balance :"+x.getBalance());
	 ArrayList<Customer> ct = new ArrayList<>();
	 ct = bs.getallcustomer();
	 for(Customer f: ct) {
		 System.out.println(f.getUname()+""+f.getAcno()+""+f.getBalance());
	 }
	bs.deletecustomer(123);
	bs.deposit(124, 500);
	bs.withdraw(124, 1000);
	
	
	}

	}

