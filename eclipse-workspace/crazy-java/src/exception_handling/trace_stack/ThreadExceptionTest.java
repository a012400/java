package exception_handling.trace_stack;

public class ThreadExceptionTest implements Runnable {

	@Override
	public void run() {
		firstMethod();
	}

	private void firstMethod() {
		secondMethod();
	}

	private void secondMethod() {
		int a = 5;
		int b = 0;
		int c = a / b;
	}
	
	public static void main(String[] args) {
		new Thread(new ThreadExceptionTest()).start();
	}

}
