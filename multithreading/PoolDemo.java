package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PoolDemo {

	public static void main(String[] args) {
		Executor threadPool = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++) {
			threadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + " is printing");
				}
			});
		}
	}
	
}
