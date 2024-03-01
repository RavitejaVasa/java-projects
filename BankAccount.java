package com.src.bank;

public class BankAccount {
	
	private double balance;
	private String name;
	private int acno;
	
	
	public BankAccount() {
		super();

	}
	public BankAccount(double balence, String name, int acno) {
		super();
		this.balance = balence;
		this.name = name;
		this.acno = acno;
	}
	public double getBalence() {
		return balance;
	}
	public String getName() {
		return name;
	}
	public int getAcno() {
		return acno;
	}
	public void setBalence(double balence) {
		this.balance = balence;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}

	 public void deposit(double amount) {
	        balance += amount;
	        System.out.println("Deposit successful. Current balance: " + balance);
	 }
	 
	 public void withdraw(double amount) throws IllegalArgumentException {
	        if (balance >= amount) {
	            balance -= amount;
	            System.out.println("Withdrawal successful. Current balance: " + balance);
	        } else {
	            throw new IllegalArgumentException("Insufficient funds.");
	        }
	    }
}
