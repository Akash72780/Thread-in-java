package basic;

public class ChildThread extends Thread {
	
	public void run() {
		Thread.currentThread().setName("Thread 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++)
			System.out.println("Child thread "+String.valueOf(i));
		
		System.out.println(Thread.currentThread().getName());
		
	}

}
 class ChildRunnable implements Runnable{

	@Override
	public void run() {
		Thread.currentThread().setName("Thread 2");
		for(int i=0;i<10;i++)
			System.out.println("Child thread "+String.valueOf(i));	
		
		System.out.println(Thread.currentThread().getName());
	}
	 
 }
