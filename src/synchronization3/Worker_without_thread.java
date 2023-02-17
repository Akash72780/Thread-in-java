package synchronization3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker_without_thread {
	
	private Random random=new Random();
	
	private List<Integer> list1=new ArrayList<>();
	private List<Integer> list2=new ArrayList<>();
	
	private void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
	}
	
	private void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
	}
	
	private void process() {
		for(int i=0;i<1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		System.out.println("Starting the process");
		long start=System.currentTimeMillis();
		
		process();
		
		long end=System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start));
		
		System.out.println("list 1: "+list1.size()+"; List 2: "+list2.size());
		
	}

}
