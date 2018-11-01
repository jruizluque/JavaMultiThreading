package applicationRunnable;

/*
 * We can start threads by implementing the Runnable class, 
 * overriding/implementing the run() method and then
 * creating a new instance of Thread with a new instance of 
 * the class that implemented Runnable as a parameter of the constructor.
 * 
 * We have to use the start() method to start the new thread.
 * 
 * Never start a thread with run(), because what we are doing by using run()
 * is just executing the run() method in the thread that called it,
 * we are not running a separate thread.
 * 
 * In this example we start two threads from the 'main' thread.
 */

class Runner implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);
		}

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ApplicationRunnable {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner());
		t1.start();
		
		Thread t2 = new Thread(new Runner());
		t2.start();
	}

}
