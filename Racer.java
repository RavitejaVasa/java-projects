package com.thread.example1;

public class Racer extends Thread{
	
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     System.out.println("Racer Check Point thread extended  "+Thread.currentThread().getName());		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Racer finished thread extended  "+Thread.currentThread().getName());		
			
		
	  

	}
}


