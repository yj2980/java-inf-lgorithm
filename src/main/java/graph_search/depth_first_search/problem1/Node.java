package graph_search.depth_first_search.problem1;

public class Node {
	public int data;
	public Node lt;
	public Node rt;

	public Node(int val) {
		data = val;
		lt = rt = null;
	}
}
