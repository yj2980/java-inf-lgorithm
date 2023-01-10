package twoPointers_slidingWindow.problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> record = new ArrayList<>();
		int day = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());

		for (int i = 0; i < day; i++) {
			record.add(Integer.parseInt(sc.next()));
		}

		main.CalculationSalesRecord(n, record);
	}

	private void CalculationSalesRecord(int n, List<Integer> record) {
		int max = 0;
		int sum = 0;
		int round = 0;
		boolean flag = false;

		for (int i = 0; i < record.size(); i++) {
			sum += record.get(i);

			if (flag) {
				sum -= record.get(i - round);
				max = Math.max(max, sum);
			}
			if (!flag) {
				round++;
				if (round == n) {
					max = sum;
					flag = true;
				}
			}
		}

		System.out.println(max);
	}
}
