package graph_search.depth_first_search.problem2;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] ch;

	public static void main(String[] args) {
		Main tree = new Main();
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.next());
		ch = new int[N + 1];

		tree.dfs(1);
	}

	private void dfs(int node) {
		if (node == N + 1) {
			String tmp = "";
			for (int i = 1; i <= N; i++) {
				if (ch[i] == 1) {
					tmp += String.valueOf(i);
				}
			}
			if (tmp.length() > 0) {
				System.out.println(tmp);
			}
		}
		if (node <= N) {
			ch[node] = 1;
			dfs(node + 1); // left
			ch[node] = 0;
			dfs(node +  1); // right
		}
	}
}
