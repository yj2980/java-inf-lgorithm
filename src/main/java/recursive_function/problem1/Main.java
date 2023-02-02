package recursive_function.problem1;

import java.util.Scanner;

/*
	문제 : 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하시오.
	입력 설명 : 첫번째 줄은 정수 N(3 <= N <= 10)이 입력된다.

	입력 예제 1 : 3
	출력 예제 1 : 1 2 3
 */
public class Main {
	static int N;
	static Main main = new Main();

	public static void main(String[] args) {
		int start = 1;
		Scanner sc = new Scanner(System.in);

		N = Integer.parseInt(sc.next());
		main.recursive(start);
	}

	private void recursive(int n) {
		System.out.print(n + " ");

		if (n == N) {
			return ;
		}

		recursive(n + 1);
	}
}
