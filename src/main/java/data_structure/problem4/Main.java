package data_structure.problem4;

import java.util.Scanner;
import java.util.Stack;


/*
1. 숫자를 만나면 stack,push();
2. 연산자가 나오면 stack.pop()을 통해 2개를 빼낸 후 연산한다.
3. 연산한 결과값을 다시 stack.push()한다.
4. 계속 반복한다.
 */
public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = main.solution(sc.next());
		System.out.println(result);
	}

	private int solution(String postfix) {
		Stack<Integer> numbers = new Stack<>();

		for (char c : postfix.toCharArray()) {
			if (isNumber(c)) {
				numbers.push(c - '0');
				continue;
			}
			int result = calculate(numbers.pop(), numbers.pop(), c);
			numbers.push(result);
		}

		return numbers.pop();
	}

	private boolean isNumber(char n) {
		if (n >= '1' && n <= '9') {
			return true;
		}

		return false;
	}

	private int calculate(int a, int b, char c) {
		if (c == '+') {
			return b + a;
		}
		if (c == '-') {
			return b - a;
		}
		if (c == '/') {
			return b / a;
		}
		if (c == '*') {
			return b * a;
		}

		return 0;
	}
}
