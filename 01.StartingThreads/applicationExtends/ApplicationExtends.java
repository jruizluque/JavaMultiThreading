package applicationExtends;

/*
 * We can start threads by extending the Thread class and
 * overriding/implementing the run() method.
 * 
 * Then we have to create a new instance of the class we extended,
 * and use the start() method to start the new thread.
 * 
 * Never start a thread with run(), because what we are doing by using run()
 * is just executing the run() method in the thread that called it,
 * we are not running a separate thread.
 * 
 * In this example we start two threads from the 'main' thread.
 */

class Runner extends Thread {

	@Override
	public void run() {
		
		for (int i=0; i<10; i++) {
			System.out.println("Hello " + i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class ApplicationExtends {
	
	public static void main(String[] args) {
		
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
	}

}
