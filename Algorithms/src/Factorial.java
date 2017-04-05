
public class Factorial {

	public static void main(String args[]) {
		System.out.println(" Factorial value is " + fact(5));
	}

	public static int fact(int number) {
		System.out.println("Calling for " + number);
		if (number == 0 || number == 1) {
			return 1;
		}
		System.out.println("Calling ");
		return number * fact(number - 1);
	}

}
