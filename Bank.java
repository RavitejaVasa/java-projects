package com.src.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private static Map<String, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public static boolean register(String username, double initialBalance) {
        if (!accounts.containsKey(username)) {
            accounts.put(username, new BankAccount(initialBalance, username, 0));
            System.out.println("Registration successful.");
            return true;
        } else {
            System.out.println("Username already exists.");
            return false;
        }
    }

    public static boolean login(String username) {
        return accounts.containsKey(username);
    }

    public static void deposit(String username, double amount) {
        if (accounts.containsKey(username)) {
            accounts.get(username).deposit(amount);
        } else {
            System.out.println("User not found.");
        }
    }

    public static void withdraw(String username, double amount) {
        if (accounts.containsKey(username)) {
            try {
                accounts.get(username).withdraw(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public static double checkBalance(String username) {
        if (accounts.containsKey(username)) {
            return accounts.get(username).getBalence();
        } else {
            System.out.println("User not found.");
            return -1;
        }
    }

}
