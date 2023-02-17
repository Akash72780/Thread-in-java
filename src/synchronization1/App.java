package synchronization1;

import java.util.Scanner;

class Processer extends Thread{
	
	private volatile boolean running=true;
	
	public void run() {
		
		while(running) {
			System.out.println("hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown() {
		running=false;
	}
}

public class App {
	
	public static void main(String[] args) {
		
		Processer processer=new Processer();
		processer.start();
		
		System.out.println("press enter to stop....");
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		processer.shutdown();
	}

}
