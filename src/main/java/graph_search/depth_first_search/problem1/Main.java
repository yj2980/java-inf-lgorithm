package graph_search.depth_first_search.problem1;

public class Main {
	static Node root;

	public static void main(String[] args) {
		createTree();
		preorder(root);
		print();
		inorder(root);
		print();
		postorder(root);
		print();
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

	private static void preorder(Node root) {
		if (root == null) {
			return;
		}
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.lt);
			preorder(root.rt);
		}
	}

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}
		if (root != null) {
			inorder(root.lt);
			System.out.print(root.data + " ");
			inorder(root.rt);
		}
	}

	private static void postorder(Node root) {
		if (root == null) {
			return;
		}
		if (root != null) {
			postorder(root.lt);
			postorder(root.rt);
			System.out.print(root.data + " ");
		}
	}

	private static void print() {
		System.out.println();
	}
}
