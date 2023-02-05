package graph_search.depth_first_searsh.baekjoon.problem24480;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);
	static int cnt = 0;
	static int[] result;

	public static void main(String[] args) {
		int v = main.readNumbers();
		int e = main.readNumbers();
		int root = main.readNumbers();

		LinkedList<Integer>[] graph = main.createGraph(v, e);
		boolean[] visited = new boolean[v + 1];
		result = new int[v + 1];

		main.bfs(root, graph, visited);

		for (int i = 1; i <= v; i++) {
			System.out.println(result[i]);
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
			int v1 = readNumbers();
			int v2 = readNumbers();

			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		// sort
		for (int i = 1; i <= v; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		return graph;
	}

	private void bfs(int n, LinkedList<Integer>[] graph, boolean[] visited) {
		Iterator<Integer> iter = graph[n].listIterator();

		visited[n] = true;
		result[n] = ++cnt;

		while (iter.hasNext()) {
			int w = iter.next();

			if (!visited[w]) {
				visited[w] = true;
				bfs(w, graph, visited);
			}
		}
	}
}
