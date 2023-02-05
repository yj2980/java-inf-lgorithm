package graph_search.depth_first_search.baekjoon.problem24479;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);
	static boolean[] visited;
	static LinkedList<Integer>[] graph;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) {
		int v = main.readNumbers();
		int e = main.readNumbers();
		int root = main.readNumbers();

		graph = main.createGraph(v, e);
		visited = new boolean[v + 1];

		visited[root] = true;
		result.add(root);
		main.dfs(root);

		for (int i = 1; i <= v; i++) {
			if (!result.contains(i)) {
				System.out.println(0);
				continue;
			}
			System.out.println(result.get(i - 1));
		}
	}

	private int readNumbers() {
		return Integer.parseInt(sc.next());
	}

	private LinkedList<Integer>[] createGraph(int v, int e) {
		LinkedList<Integer>[] graph = new LinkedList[v + 1];

		for (int i = 1; i <= v; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < e; i++) {
			int left = readNumbers();
			int right = readNumbers();

			graph[left].add(right);
			graph[right].add(left);
		}

		// sort
		for (int i = 1; i <= v; i++) {
			Collections.sort(graph[i]);
		}

		return graph;
	}
	private void dfs(int root) {
		for (int node : graph[root]) {
			if (!visited[node]) {
				result.add(node);
				visited[node] = true;
				dfs(node);
			}
		}
	}
}
