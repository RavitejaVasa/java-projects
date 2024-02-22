package com.thread.example1;
import com.thread.example1.Racer; 
public class Racer1 implements Runnable{

	@Override
	public synchronized void  run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     System.out.println("Racer Check Point"+Thread.currentThread().getName());		
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Racer finished "+Thread.currentThread().getName());		
		
	}
}

