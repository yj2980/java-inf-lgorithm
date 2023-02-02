package recursive_function.problem3;

import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[ ]args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.next());
		System.out.println(main.factorial(N));
	}

	private int factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if (n > 1) {
			return n * factorial(n - 1);
		}

		return 0;
	}
}
