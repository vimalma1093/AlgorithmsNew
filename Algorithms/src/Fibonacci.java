
public class Fibonacci {

	public static void main(String... args) {
		// FInd 10th sequence in Fib series
		System.out.println(" 10 th Sequence is " + fib(50));

	}

	public static int fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);

	}

}
