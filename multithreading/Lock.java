package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {

	public static void main(String[] args) {
		Task task = new Lock.Task();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
	}
	
	static class Task implements Runnable{
		public Task() {};
		int ticket = 100;
		//此处三个thread共用一个lock，所以可以不加static
		private static final ReentrantLock lock = new ReentrantLock();
		public void run() {
			while(true) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.lock();
				if(ticket > 0) {
					System.out.println(ticket + " is printing at " + Thread.currentThread().getName());
					ticket--;
				}else {
					break;
				}
				lock.unlock();
			}
		}
	}
	
}
