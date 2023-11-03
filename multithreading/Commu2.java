package multithreading;

public class Commu2 {

	private static int state = 3;
	private static Object lock = new Object();
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (lock) {
						while (state == 0) {
							System.out.println("no available parking lots");
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						state--;
						System.out.println("parking successfully");
						lock.notifyAll();
					} 
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					synchronized (lock) {
						while (state == 3) {
							System.out.println("no outbounding vehicles");
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						state++;
						System.out.println("outbounding successfully");
						lock.notifyAll();
					} 
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}
