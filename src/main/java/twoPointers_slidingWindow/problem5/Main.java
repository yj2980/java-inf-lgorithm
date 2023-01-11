package twoPointers_slidingWindow.problem5;

import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.next());
		int answer = main.solution(n);

		System.out.println(answer);
	}

	public int solution(int n) {
		int sum = 0;
		int count = 0;
		int k = 1;

		 for (int i = 0; i <= n / 2 + 1; i++) {
			sum += i;

			if (sum == n) {
				count++;
			}

			 while (sum >= n) {
				 sum -= k++;
				 if (sum == n) {
					 count++;
				 }
			 }
		 }

		 return count;
	}
}
