package multithreading;

public class Commu4 {

	private static Object lock = new Object();
	private static int num = 1;
	private static int count = 0;
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				synchronized(lock) {
					while(count < 15) {
						for(int i = 0; i < 5; i++) {
							System.out.println(num++ + " printed at " + Thread.currentThread().getName());
						}
						count++;
						lock.notifyAll();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				synchronized(lock) {
					while(count < 15) {
						for(int i = 0; i < 5; i++) {
							System.out.println(num++ + " printed at " + Thread.currentThread().getName());
						}
						count++;
						lock.notifyAll();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		Thread thread3 = new Thread(new Runnable() {
			public void run() {
				synchronized(lock) {
					while(count < 15) {
						for(int i = 0; i < 5; i++) {
							System.out.println(num++ + " printed at " + Thread.currentThread().getName());
						}
						count++;
						lock.notifyAll();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
	
	
}
