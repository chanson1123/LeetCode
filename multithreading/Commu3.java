package multithreading;

public class Commu3 {

	//3个内部类如果用this，会导致有三把锁
	private static Object lock = new Object();
	private static int num = 0;
	private static Character flag = 'A';
	
	//3个线程做3件事，有3个同步代码块，notify唤醒同样持有相同lock的同步代码块
	public static void main(String[] args) {
		Thread a = new Thread(new Runnable() {
			public void run() {
				synchronized(lock) {
					while(num <= 9) {
						//线程wait用while-loop，不然b唤醒a直接开始调用
						while(flag != 'A') {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(num == 10) {
							break;
						}
						System.out.println('A' + " printed at " + Thread.currentThread().getName() + " " + num);
						flag = 'B';
						lock.notifyAll();
					}
				}
			}
		});
		
		Thread b = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					while (num <= 9) {
						while (flag != 'B') {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(num == 10) {
							break;
						}
						System.out.println('B' + " printed at " + Thread.currentThread().getName());
						flag = 'C';
						lock.notifyAll();
					}

				}
			}
		});

		Thread c = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					while (num < 10) {
						while (flag != 'C') {
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println('C' + " printed at " + Thread.currentThread().getName());
						flag = 'A';
						num++;
						lock.notifyAll();
					}
				}
			}
		});
		
		
		a.start();
		b.start();
		c.start();
	}
	
	class A extends Thread {
		public void run() {
			while(true) {
				synchronized(lock) {
					if(num % 3 == 0) {
						System.out.println('A');
						num++;
						lock.notifyAll();
					}
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	class B extends Thread {
		public void run() {
			while(true) {
				synchronized(lock) {
					if(num % 3 == 1) {
						System.out.println('B');
						num++;
						lock.notifyAll();
					}
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	class C extends Thread {
		public void run() {
			while(true) {
				synchronized(lock) {
					if(num % 3 == 2) {
						System.out.println('C');
						num++;
						lock.notifyAll();
					}
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
