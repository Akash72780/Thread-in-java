package re_entrantLock;

public class App {

	public static void main(String[] args) {
		Processor processor=new Processor();
		
		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					processor.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				processor.secondThread();
				
			}
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		processor.finished();

	}

}
