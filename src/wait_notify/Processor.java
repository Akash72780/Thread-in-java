package wait_notify;

import java.util.Scanner;

public class Processor {
	
	public void producer() throws InterruptedException {
		synchronized (this) {	//"this" indicates the current object
			System.out.println("processor is running");
			wait();	//release the lock to other thread until got notify
			System.out.println("processor resumed");
		}
	}
	
	public void consumer() throws InterruptedException {
		Scanner scanner=new Scanner(System.in);
		Thread.sleep(1000);
		
		synchronized (this) {
			System.out.println("press return key to continue");
			scanner.nextLine();
			System.out.println("return key pressed");
			notify();	//notify the other thread to get the lock. But it releases the lock until whole process is done
			Thread.sleep(4000);
		}
	}

}
