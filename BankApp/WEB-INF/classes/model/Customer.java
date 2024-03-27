package model;



public class Customer {
	
	private int acno;
	private String uname;
	private double balance;
	
	
	
	
	public Customer(int acno, String uname, double balance) {
		super();
		this.acno = acno;
		this.uname = uname;
		this.balance = balance;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
