package semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Connection {
	
	private static Connection instance=new Connection();
	
	private Semaphore semaphore=new Semaphore(10);
	
	private static int connections=0;
	
	private Connection() {
		//go here the connection parameter
	}
	
	public static Connection getConnection() {
		return instance;
	}
	
	public void connect() throws InterruptedException {
		semaphore.acquire();	// here semaphore block the connection
		try {
			doConnect();		//doing the connection works
		}finally {
			semaphore.release();	// until it releases from here
		}
	}
	
	public void doConnect() {
		
		synchronized (this) {
			connections++;
			System.out.println("total connections is: "+connections);
		}
		
		try {
			Thread.sleep(1000);	// all working done here
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
