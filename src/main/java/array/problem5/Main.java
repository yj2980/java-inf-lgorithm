package array.problem5;

import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		main.count(Integer.parseInt(sc.next()));
	}

	private void count(int n) {
		int count = 0;

		for (int i = 1; i <= n; i++) {
			if (isPrime(i) == 1) {
				count++;
			}
		}

		System.out.println(count);
	}

	private int isPrime(int n) {
		if (n <= 1) {
			return 0;
		}
		if (n % 2 == 0) {
			return n == 2 ? 1 : 0;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return 0;
			}
		}

		return 1;
	}
}
