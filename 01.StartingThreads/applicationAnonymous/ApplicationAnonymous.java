package applicationAnonymous;

/*
 * We can start threads by implementing the Runnable class 
 * inside the constructor of Thread and overriding/implementing the run() method.
 * This is called an Anonymous Inner Class.
 * 
 * We have to use the start() method to start the new thread.
 * 
 * Never start a thread with run(), because what we are doing by using run()
 * is just executing the run() method in the thread that called it,
 * we are not running a separate thread.
 * 
 * In this example we start a thread from the 'main' thread.
 */

public class ApplicationAnonymous {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			
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
		});

		t1.start();
	}

}
