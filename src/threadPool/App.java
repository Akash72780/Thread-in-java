package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	
	public static void main(String[] arg) {
		
		long start=System.currentTimeMillis();
		
		ExecutorService service=Executors.newFixedThreadPool(3);// number of threads in running condition
		
		for(int i=0;i<5;i++)
			service.submit(new Worker(i));
		
		service.shutdown();
		
		System.out.println("All task submitted.");
		
		try {
			service.awaitTermination(1, TimeUnit.DAYS);// waits for the tasks to complete
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		System.out.println("All tasks completed in "+(end-start));
		
	}

}
