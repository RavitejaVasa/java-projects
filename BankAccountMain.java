package com.src.bank;

import java.util.Scanner;

public class BankAccountMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Bank B = new Bank();
		
		 while (true) {
	            System.out.println("\nWelcome to the Bank Application");
	            System.out.println("1. Register\n2."
	            					+ " Login\n3."
	            					+ " Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                	
	                    System.out.print("Enter username: ");
	                    String newUsername = sc.next();
	                    System.out.print("Enter initial balance: ");
	                    double initialBalance = sc.nextDouble();
	                    Bank.register(newUsername, initialBalance);
	                    break;
	                case 2:
	                	
	                    System.out.print("Enter username: ");
	                    String username = sc.next();
	                    if (Bank.login(username)) {
	                        while (true) {
	                            System.out.println("\nWelcome, " + username);
	                            System.out.println("1. Deposit\n2."
	                            		           + " Withdraw\n3."
	                            		           + " Check Balance\n4."
	                            		           + " Logout");
	                            
	                            System.out.print("Enter your choice: ");
	                            int userChoice = sc.nextInt();

	                            switch (userChoice) {
	                                case 1:
	                                	
	                                    System.out.print("Enter deposit amount: ");
	                                    double depositAmount = sc.nextDouble();
	                                    Bank.deposit(username, depositAmount);
	                                    break;
	                                    
	                                case 2:
	                                	
	                                    System.out.print("Enter withdrawal amount: ");
	                                    double withdrawalAmount = sc.nextDouble();
	                                    Bank.withdraw(username, withdrawalAmount);
	                                    break;
	                                case 3:
	                                	
	                                    System.out.println("Your balance: " + Bank.checkBalance(username));
	                                    break;
	                                case 4:
	                                	
	                                    System.out.println("Logged out.");
	                                    break;
	                                default:
	                                    System.out.println("Invalid choice.");
	                            }

	                            if (userChoice == 4) {
	                                break;
	                            }
	                        }
	                    } else {
	                        System.out.println("Invalid username. Please register first.");
	                    }
	                    break;
	                    
	                case 3:
	                	
	                    System.out.println("Exiting...");
	                    System.out.println("Thanks for using this Application");
	                    System.exit(0);
	                    break;
	                    
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        }
	      }
		}	
	


