import java.util.Arrays;

public class BubbleSort {

	public static void main(String args[]) {
		System.out.println("Vimal here");
		doSortForLoop();
	}

	public static void doSort() {

		int[] input = { 33, 11, 8, 6, 90, 100, 53, 21, 1, -44 };

		int start = 0;
		int end = input.length;

		while (start < end) {
			for (int i = start + 1; i < end; i++) {
				if (input[i - 1] > input[i]) {
					int temp = input[i - 1];
					input[i - 1] = input[i];
					input[i] = temp;
				}
			}
			--end;
		}
		System.out.println("Sorted values are " + Arrays.toString(input));

	}

	public static void doSortForLoop() {

		int[] input = { 33, 11, 8, 6, 90, 100, 53, 21, 1, -44 };

		int end = input.length;
		for (int start = 0; start < end;) {
			for (int i = start + 1; i < end; i++) {
				if (input[i - 1] > input[i]) {
					int temp = input[i - 1];
					input[i - 1] = input[i];
					input[i] = temp;
				}
			}
			--end;
		}
		System.out.println("Sorted values are " + Arrays.toString(input));

	}
}
