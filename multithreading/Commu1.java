package multithreading;

public class Commu1 {
	
	public static void main(String[] args) {
		Task task = new Commu1().new Task();
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		thread1.start();
		thread2.start();

	}
	
	//两个线程做一件事
	class Task implements Runnable{
		int num = 1;
		@Override
		public void run() {
			
			while(true) {
				synchronized(this) {
					notify();
					if(num <= 100) {
						System.out.println(num++ + " by " + Thread.currentThread().getName());
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						break;
					}
				}
			}
		}
	}

}
