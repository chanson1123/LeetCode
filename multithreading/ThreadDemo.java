package multithreading;

public class ThreadDemo extends Thread{

	public static void main(String[] args) {
		ThreadDemo thread1 = new ThreadDemo();
		ThreadDemo thread2 = new ThreadDemo();
		thread1.start();
		thread2.start();
		
		new Thread() {
			public void run() {
				System.out.println(getName() + " is printing");
			}
		}.start();
	}
	
	@Override
	public void run() {
		System.out.println(getName() + " is printing");
	}
	
}
