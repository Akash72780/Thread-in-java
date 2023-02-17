package deadlock;

public class Account {
	
	private int amount=10000;
	
	private void deposit(int amount) {
		this.amount+=amount;
	}
	private void withdraw(int amount) {
		this.amount-=amount;
	}
	
	public int getBalance() {
		return this.amount;
	}
	
	public static void tansfer(Account acc1,Account acc2, int money) {
		acc1.deposit(money);
		acc2.withdraw(money);
	}

}
