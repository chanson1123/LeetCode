package multithreading;

public class SynBlock {

	public static void main(String[] args) {
		Task task = new SynBlock().new Task();
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		Thread thread3 = new Thread(task);
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	class Task implements Runnable{
		int ticket = 100;
		public Task(){};
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (this) {
					if (ticket > 0) {
						System.out.println(ticket + " is printing at " + Thread.currentThread().getName());
						ticket--;
					} else {
						break;
					}
				}
			}
		}
	}
	
}
