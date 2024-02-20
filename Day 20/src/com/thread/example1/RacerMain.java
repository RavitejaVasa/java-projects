package com.thread.example1;

public class RacerMain {

public static void main(String[] args) {
	Runnable  rr1 = new Racer1();
	Thread t1 =new Thread(rr1);
    Thread t2 = new Thread(rr1);
	  Thread t3 = new Thread(rr1);
	  Thread t4 = new Thread(rr1);
	  Thread t5 = new Thread(rr1);
	 
	  
	  
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
   
}

}
