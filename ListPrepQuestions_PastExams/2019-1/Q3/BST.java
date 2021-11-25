import java.util.ArrayList;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class BST {	
	Node root;

	/**
	 * Node class
	 */
	public class Node {
		String value;
		Node parent;
		Node left;
		Node right;

		public Node(String value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		/**
		 * @param s
		 * @return the node that has the given value.
		 */
	    public Node find(String s) {
			// TODO: Add your implementation here.
	        return findHelper(root, s);
	    }

	    public Node findHelper(Node node, String s){
	    	if (node == null) return null;
	    	if (node.value.equals(s)) return node;
	    	if (findHelper(node.left, s) != null) return findHelper(node.left, s);
			if (findHelper(node.right, s) != null) return findHelper(node.right, s);
			return null;
		}

		/**
		 * Insert a new node into the tree
		 * @param s
		 * @return {@link Node}
		 */
		public Node insert(String s) {
			// TODO: Add your implementation here.
			Node y = null;
			Node x = root;
			while (x != null){
				y = x;
				if (s.compareTo(x.value) < 0){
					x = x.left;
				} else {
					x = x.right;
				}
			}
			Node z = new Node(s);
			z.parent = y;
			if (y == null){
				root = z;
			} else if (s.compareTo(y.value) < 0){
				y.left = z;
			} else {
				y.right = z;
			}
			return this;
		}
		
		/**
		 * @return pre-order traversal of the nodes that have odd number of children.
		 */
		public String printOddNodes() {
			// TODO: Add your implementation here.
			ArrayList<String> stringArrayList = new ArrayList<>();
			ArrayList<String> ret = printOddNodesHelper(stringArrayList, root);
			if (ret.isEmpty()) return "";
			return String.join(" ", ret);
		}

		public ArrayList<String> printOddNodesHelper(ArrayList<String> stringArrayList, Node node){
			if (node == null) return stringArrayList;
			if (hasOddNodes(node)){
				stringArrayList.add(node.value);
			}
			stringArrayList = printOddNodesHelper(stringArrayList, node.left);
			stringArrayList = printOddNodesHelper(stringArrayList, node.right);
			return stringArrayList;
		}

		public boolean hasOddNodes(Node node){
			if (node.left == null && node.right != null) return true;
			if (node.left != null && node.right == null) return true;
			return false;
		}
	}

	public String printOddNodes() {
		return root.printOddNodes();
	}
	
	public BST() {
		root = null;
	}

	public Node insert(String value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		return root.insert(value);
	}
	
	public Node find(String s) {
		if (root == null) {
			return null;
		}
		
		return root.find(s);
	}
}