package demo3;

public class App {

	public static void main(String[] args) {
		
		Thread thread1=new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println("with lamba expression "+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread1.start();

	}

}
