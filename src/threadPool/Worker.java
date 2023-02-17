package threadPool;

public class Worker implements Runnable {
	
	private int id;
	
	public Worker(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		
		System.out.println("Worker started: "+id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Worker completed: "+id);
		
	}
	


}
