package re_entrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {
	
	private Lock lock=new ReentrantLock();
	
	private Condition condition=lock.newCondition();
	
	private List<Integer> list=new ArrayList<>();
	
	private void increment(int value) {
		for(int i=0;i<5;i++)
			list.add(value);
	}
	
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("firstThread is waiting!!!");
		condition.await();
		System.out.println("firstThread is woken!!!");
		try {
			increment(0);
		}finally {
			lock.unlock();
		}
		
	}
	
	public void secondThread() {
		lock.lock();
		
		System.out.println("press enter key to unlock the lock!!");
		new Scanner(System.in).nextLine();
		System.out.println("Time to wake up FirstThread");
		condition.signal();
		
		try {
			increment(1);
		}finally {
			lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("counter value is "+list.size());
		System.out.println(list);
	}

}
