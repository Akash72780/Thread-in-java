package basic;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		
//		ChildThread cT=new ChildThread();
//		cT.start();
		ChildThread thread1=new ChildThread();
		thread1.setPriority(2);
		thread1.start();
		
		ChildRunnable childRunnable=new ChildRunnable();
		Thread thread2=new Thread(childRunnable);
		thread2.setPriority(1);
		thread2.start();
		
		
		
//		System.out.println(Thread.currentThread().getName());
//		for(int i=0;i<10;i++)
//			System.out.println("Main thread "+String.valueOf(i));
		
		

	}

}
