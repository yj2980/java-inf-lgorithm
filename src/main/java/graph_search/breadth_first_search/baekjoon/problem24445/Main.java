package graph_search.breadth_first_search.baekjoon.problem24445;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);
	static int[] result;

	public static void main(String[] args) {
		// vertex
		int n = main.readNumbers();
		// edge
		int m = main.readNumbers();
		int root = main.readNumbers();

		LinkedList<Integer>[] graph = main.createGraph(n, m);
		boolean[] visited = new boolean[n + 1];
		result = new int[n + 1];

		main.bfs(root, graph, visited);

		for (int i = 1; i <= n; i++) {
			System.out.println(result[i]);
		}
	}

	private LinkedList<Integer>[] createGraph(int n, int m) {
		LinkedList<Integer>[] graph = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			int v1 = readNumbers();
			int v2 = readNumbers();

			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		// sort
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		return graph;
	}

	private void bfs(int vertex, LinkedList<Integer>[] graph, boolean[] visited) {
		int cnt = 1;
		Queue<Integer> queue = new LinkedList<>();

		queue.add(vertex);
		visited[vertex] = true;
		result[vertex] = 1;


		while (!queue.isEmpty()) {
			int w = queue.poll();

			for (int next : graph[w]) {
				if (!visited[next]) {
					result[next] = ++cnt;
					visited[next] = true;
					queue.add(next);
				}
			}
		}

	}

	private int readNumbers() {
		return Integer.parseInt(sc.next());
	}
}
