package recursive_function.problem2;

import java.util.Scanner;

/*
	문제 : 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하시오. 단 재귀함수를 이용해서 출력해라.
 */
public class Main {

	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.next());
		main.recursive(N);

	}

	private void recursive(int n) {
		if (n == 0) {
			return ;
		}
		if (n > 0) {
			recursive(n / 2);
			System.out.print(n % 2 + " ");
		}
	}
}
