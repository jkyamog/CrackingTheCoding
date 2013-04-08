package codinginterview;

import java.util.LinkedList;
import java.util.List;

public class C0404 {
	
	public class Node {
		final Node left;
		final Node right;
		final String value;
		
		public Node(String value, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}

	
	List<List<Node>> listOfNodes = new LinkedList<List<Node>> ();
	Node rootNode;

	public static void main(String[] args) {
		C0404 c = new C0404();
		
		c.rootNode = c.init();
		c.walkTree(c.rootNode, 0);
		
		System.out.println(c.listOfNodesToString());
	}
	
	public void walkTree(Node current, int depth) {
		if (current == null) return;

		System.out.println("walking " + current.value + " " + depth);
		
		List<Node> currentList;
		if (listOfNodes.size() == depth) {
			currentList = new LinkedList<Node>();
			listOfNodes.add(depth, currentList);
		} else {
			currentList = listOfNodes.get(depth);
		}
		currentList.add(current);
		
		walkTree(current.left, depth+1);
		walkTree(current.right, depth+1);
	}
	
	public String listOfNodesToString() {
		int depth = 0;
		StringBuilder sb = new StringBuilder();
		
		for (List<Node> lNodes : listOfNodes) {
			sb.append("depth: " + depth + "[");
			depth++;
			for (Node node : lNodes) {
				sb.append(node.value + ",");
			}
			sb.append("] ");
		}
		
		return sb.toString();
	}
	
	public Node init() {
		Node two = new Node("2", null, null);
		Node four = new Node("4", null, null);
		
		Node three = new Node("3", two, four);
		
		Node six = new Node("6", null, null);
		Node eight = new Node("8", null, null);
		
		Node seven = new Node("7", six, eight);
		
		Node five = new Node("5", three, seven);
		
		return five;
	}
	

}
