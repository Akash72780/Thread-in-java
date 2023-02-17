package deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Processor {

	private Account account1 = new Account();
	private Account account2 = new Account();

	private Lock lock = new ReentrantLock();

	public void firstThread() {
		Random random = new Random();

		for (int i = 0; i < 100; i++) {
			lock.lock();
			try {
				Account.tansfer(account1, account2, random.nextInt(100));

			} finally {
				lock.unlock();
			}
		}

	}

	public void secondThread() {
		Random random = new Random();

		for (int i = 0; i < 100; i++) {
			lock.lock();
			try {

				Account.tansfer(account2, account1, random.nextInt(100));

			} finally {
				lock.unlock();
			}
		}
	}

	public void finish() {
		System.out.println("in account 1: " + account1.getBalance());
		System.out.println("in account 2: " + account2.getBalance());
		System.out.println("total balance: " + (account1.getBalance() + account2.getBalance()));
	}

}
