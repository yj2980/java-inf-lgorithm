package data_structure.problem5;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int answer = main.solution(s);

		System.out.println(answer);
	}

	private int solution(String s) {
		Stack<String> stick = new Stack<>();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				// laser
				if (s.charAt(i + 1) == ')') {
					count += stick.size();
					i++;
					continue;
				}
				stick.push(String.valueOf(s.charAt(i)));
			}
			if (s.charAt(i) == ')') {
				count++;
				stick.pop();
			}
		}

		return count;
	}
}
