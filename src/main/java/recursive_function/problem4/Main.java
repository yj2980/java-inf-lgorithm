package recursive_function.problem4;

import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[ ] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.next());
		System.out.println(main.fibonacci(N));
	}

	private int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
