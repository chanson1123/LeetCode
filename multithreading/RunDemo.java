package multithreading;

public class RunDemo implements Runnable{

	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunDemo());
		Thread thread2 = new Thread(new RunDemo());
		thread1.start();
		thread2.start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Runnable is printing");
			}
		}).start();
	}
	
	@Override
	public void run() {
		System.out.println("Runnable is printing");
	}
	
}
