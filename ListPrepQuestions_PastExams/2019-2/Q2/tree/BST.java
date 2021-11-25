/** This class is a part of {@code package tree}. Do not change the package structure.
 * Make sure that your IDE do not change it to for example {@code package src.tree}.
 * If it happens, please revert it once you finish the implementation.
 */
package tree;

/**
 * Binary search tree with integer keys (values). {@code insert} method is
 * provided.
 * 
 * @author dongwoo
 *
 */
public class BST {
	Node root;

	/**
	 * Q2 - Task1 TODO: Implement "find" method. The method should return "true" if
	 * a tree contains the node with value, otherwise return "false". You can define
	 * additional functions in class BST or Node if you need.
	 * 
	 * @param value
	 * @return return true if the tree contains the node with value otherwise false
	 */
	public Boolean find(int value) {

		// start your code
		if (root == null) return false;
		return findHelper(root, value);
		// end your code
	}

	public Boolean findHelper(Node node, int value){
		if (node == null) return false;
		if (node.value == value) return true;
		return findHelper(node.left, value) || findHelper(node.right, value);
	}

	/**
	 * Q2 - Task2 TODO: Implement "delete" method. Find the node with {@code value}
	 * and remove it from the tree. If the target node has two children, use
	 * successor to replace the target node. You can define additional functions in
	 * class BST or Node if you need.
	 * 
	 * Do not care about the case where the target node does not exist.
	 * 
	 * @param value value of the target node
	 */
	public void delete(int value) {

		// start your code
		Node x = locate(root, value);
		Node newNodeAtx = nodeToReplace(x);
		if (x.equals(root)){
			root = replace(x, newNodeAtx);
		} else {
			x = replace(x, newNodeAtx);
		}
		// end your code
	}

	public Node nodeToReplace(Node node){
		if (node.left == null && node.right == null){
			return null;
		} else if (node.left != null && node.right == null){
			return node.left;
		} else if (node.left == null && node.right != null){
			return node.right;
		} else {
			return successor(node);
		}
	}

	public Node locate(Node node, int value) {
		if (node == null) return null;
		if (node.value == value) return node;
		if (locate(node.left, value) != null) return locate(node.left, value);
		if (locate(node.right, value) != null) return locate(node.right, value);
		return null;
	}

	public Node successor(Node node){
		if (node.right != null){
			return getMin(node.right);
		}
		Node pa = node.parent;
		while (pa != null && isRight(node)){
			Node papa = pa.parent;
			node = pa;
			pa = papa;
		}
		return pa;
	}

	public Node getMin(Node node) {
		if (node.left != null){
			return getMin(node.left);
		}
		return node;
	}

	public Node replace(Node originalNode, Node newNode){

		if (newNode == null){
			if (originalNode.parent != null){
				if (isRight(originalNode)){
					originalNode.parent.right = null;
				} else {
					originalNode.parent.left = null;
				}
			}
			return null;
		}

		// delete the new node from its subtree
		Node nodeAtNewNode = nodeToReplace(newNode);
		if (nodeAtNewNode == null){
			if (isRight(newNode)){
				newNode.parent.right = null;
			} else {
				newNode.parent.left = null;
			}
		} else {
			nodeAtNewNode.parent = newNode.parent;
			if (isRight(newNode)){
				nodeAtNewNode.parent.right = nodeAtNewNode;
			} else {
				nodeAtNewNode.parent.left = nodeAtNewNode;
			}
		}

		// replace the new node with original node
		if (originalNode.parent == null){
			newNode.parent = null;
		} else {
			newNode.parent = originalNode.parent;
			if (isRight(originalNode)){
				originalNode.parent.right = newNode;
			} else {
				originalNode.parent.left = newNode;
			}
		}
		newNode.left = originalNode.left;
		newNode.right = originalNode.right;
		if (newNode.left != null) newNode.left.parent = newNode;
		if (newNode.right != null) newNode.right.parent = newNode;

		return newNode;
	}

	public boolean isRight(Node node) {
		if (node.parent == null) return false;
		return node.parent.right.equals(node);
	}

	/**
	 * Q2 - Task3 TODO: Implement "sumEvenNodes" function. The method should return
	 * print the sum of the nodes that have an even number of direct children (zero
	 * is an even number). You can define additional functions in class BST or Node
	 * if you need.
	 * 
	 * @return Sum of the nodes that have an even number of direct children
	 */
	public int sumEvenNodes() {
		//start your code
		return sumEvenNodesHelper(root);
		//end your code
	}

	public int sumEvenNodesHelper(Node node) {
		if (node == null) return 0;
		if (node.left == null && node.right == null) return node.value;
		if (node.left != null && node.right != null) {
			return node.value + sumEvenNodesHelper(node.left) + sumEvenNodesHelper(node.right);
		}
		return sumEvenNodesHelper(node.left) + sumEvenNodesHelper(node.right);
	}

	public class Node {
		public Integer value;
		public Node parent;
		public Node left;
		public Node right;

		public Node(Integer value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

//		public Node replaceBy(Node node){
//			if (parent == null){
//				node.parent = null;
//				node.left = left;
//				node.right = left;
//				return node;
//			}
//
//
//
//
//
//			if (node.parent.left != null && node.parent.left.equals(node)){
//				node.parent.left = null;
//			} else {
//				node.parent.right = null;
//			}
//			if (parent.left != null && parent.left.equals(this)){
//				node.parent = parent;
//				parent.left = node;
//			} else {
//				node.parent = parent;
//				parent.right = node;
//			}
//		}
	}

	public BST() {
		root = null;
	}

	/**
	 * Insert a new node based on an input value. Do not modify the method.
	 * 
	 * Do not consider the case where a tree already has the node with the same
	 * value.
	 * 
	 * @param value value of inserted node
	 * @return inserted node (not the entire tree)
	 */
	public Node insert(int value) {
		Node parent = null;
		Node current = root;
		while (current != null) {
			if (current.value < value) {
				parent = current;
				current = current.right;
			} else if (current.value > value) {
				parent = current;
				current = current.left;
			}
		}

		if (parent == null && current == null) {
			root = new Node(value); // no parent = root is empty
			return root;
		} else {
			Node newNode = new Node(value);

			if (parent.value < value) {
				parent.right = newNode;
				newNode.parent = parent;
			} else if (parent.value > value) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			return newNode;
		}
	}

}