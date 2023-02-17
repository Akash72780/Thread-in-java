package synchronization2;

// WAP to increment the counter accessed by two threads
public class App {

	private int counter = 0;
	
	private synchronized void increment() { // using synchronized in a block ensure that no other thread can access until current thread is done.
		counter++;
	}

	private void doIncrement() {
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++)
					increment();
			}
		});
	
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10000; i++)
					increment();
			}
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join(); // holds the current thread(main) till child thread is not finish
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(counter);
	}

	public static void main(String[] args) {
		
		App obj=new App();
		obj.doIncrement();

	}

}
