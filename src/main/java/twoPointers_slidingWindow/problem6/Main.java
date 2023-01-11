package twoPointers_slidingWindow.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		List<Integer> number = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			number.add(Integer.parseInt(sc.next()));
		}

		System.out.println(main.solution(k, number));
	}

	private int solution(int k, List<Integer> number) {
		int count = 0;
		boolean flag = false;
		int life = k;
		int max = 0;
		int lt = 0;

		for (int i = 0; i < number.size(); i++) {
			if (number.get(i) == 1) {
				count++;
				flag = true;
			}
			if (number.get(i) == 0) {
				if (flag && k != 0) {
					k--;
					count++;
				}
				else if (k == 0) {
					flag = false;
					k = life;
					max = Math.max(count, max);
					count = 0;

					i = lt++;
				}
			}
		}

		return max;
	}
}
