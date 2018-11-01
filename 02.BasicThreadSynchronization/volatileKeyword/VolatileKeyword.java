package volatileKeyword;

import java.util.Scanner;

/*
 * The 'main' method is running in the 'main' thread.
 * It's also starting 'proc1', a separate thread that runs its own code.
 * When the shutdown() method is called, the 'main' thread is 
 * updating a variable in the 'proc1' thread.
 * 
 * Since the run() method of 'proc1' never updates the variable 'running',
 * it could happen that Java decides to optimize and caches this variable.
 * And no matter what we do from the 'main' thread, 
 * the variable will never be updated
 * and then the 'proc1' thread will never stop.
 * 
 * In order to prevent threads from caching variables, 
 * we set them as volatile.
 */

class Processor extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {

		while (running) {

			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class VolatileKeyword {

	public static void main(String[] args) {

		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press return tos top...");
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
	}

}
