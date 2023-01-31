package binary_search.baekjoon.problem1300;

import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		N = main.readNumber();
		K = main.readNumber();

		main.solve();
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private void solve() {
		int left = 1;
		int right = K;

		while (left < right) {
			int mid = (left + right) / 2;
			int cnt = 0;

			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}

			if (K <= cnt) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		printResult(left);
	}

	private void printResult(int result) {
		System.out.println(result);
	}
}
