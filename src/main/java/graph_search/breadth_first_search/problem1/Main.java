package graph_search.breadth_first_search.problem1;

import java.util.LinkedList;
import java.util.Queue;

import graph_search.depth_first_search.problem1.Node;

public class Main {
	static Node root;

	public static void bfs(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int level = 0;
		while (!q.isEmpty()) {
			int length = q.size();
			System.out.print(level + " : ");
			for (int i = 0; i < length; i++) {
				Node current_node = q.poll();
				System.out.print(current_node.data + " ");
				if (current_node.lt != null) {
					q.offer(current_node.lt);
				}
				if (current_node.rt != null) {
					q.offer(current_node.rt);
				}
			}
			level++;
			System.out.println();
		}

	}

	public static void main(String[] args) {
		createTree();
		bfs(root);

	}

	private static void createTree() {
		Main tree = new Main();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
	}
}
