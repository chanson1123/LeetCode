package multithreading;

public class LazySingletonTest {

	static LazySingleton s1 = null;
	static LazySingleton s2 = null;
	
	public static void main(String[] args) {
		//匿名类，匿名对象可以直接调用方法
		Thread thread1 = new Thread() {
			public void run() {
				s1 = LazySingleton.getInstance();
			}
		};
		
		Thread thread2 = new Thread() {
			public void run() {
				s2 = LazySingleton.getInstance();
			}
		};
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
	
}

class LazySingleton{
	private LazySingleton() {};
	private static LazySingleton s = null;
	public static synchronized LazySingleton getInstance() {
		if(s == null) {
			s = new LazySingleton();
		}
		return s;
	}
}

class EagerSingleton{
	private EagerSingleton() {};
	//final 也可以保证线程安全
	private static final EagerSingleton s = new EagerSingleton();
	public static EagerSingleton getInstance() {
		return s;
	}
}


