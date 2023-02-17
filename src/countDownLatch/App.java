package countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Worker implements Runnable{
	
	public CountDownLatch latch=null;
	int timeDelay=0;
	int id=0;
	
	public Worker(CountDownLatch latch,int timeDelay,int id) {
		this.latch=latch;
		this.timeDelay=timeDelay;
		this.id=id;
	}

	@Override
	public void run() {
		
		System.out.println("starting thread "+id);
		
		try {
			Thread.sleep(timeDelay);
			latch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Complete thread "+id);
		
	}
	
	
}

public class App {

	public static void main(String[] args) {
		
		CountDownLatch latch=new CountDownLatch(3);// main program waiting for 3 threads to be finished
		
		for(int i=0;i<3;i++) {
			new Thread(new Worker(latch, i*1000, i)).start();
		}
		
		try {
			latch.await(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("complete main");

	}

}
