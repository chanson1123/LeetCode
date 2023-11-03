package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallDemo implements Callable<String>{

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallDemo d = new CallDemo();
		FutureTask<String> task = new FutureTask<>(d);
		Thread thread1 = new Thread(task);
		thread1.start();
		String result = task.get();
		System.out.println(result);
	}
	
	public String call() throws Exception{
		return "Callable is printing";
	}
	
}
