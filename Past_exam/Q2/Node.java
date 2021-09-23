/**
 * Base class for node
 *
 * @param <T> data type
 */

public class Node<T extends Comparable<T>> {

	Colour colour;			// Node colour
	Interval<T> key; 		// Node key, which is an interval
	Node<T> parent; 		// Parent node
	Node<T> left, right; 	// Child nodes

	public Node(Interval<T> key) {
		this.key  = key;
		this.colour = Colour.RED; //property 3 (if a node is red, both children are black) may be violated if parent is red

		this.parent = null;

		// Initialise children leaf nodes
		this.left 			= new Node<T>();  //leaf node
		this.right 			= new Node<T>();  //leaf node
		this.left.parent 	= this; //reference to parent
		this.right.parent 	= this; //reference to parent
	}

	// Leaf node
	public Node() {
		this.key 	= null; //leaf nodes are null
		this.colour = Colour.BLACK; //leaf nodes are always black
	}

	public void replaceBy(Node<T> node){
		if (node == null || node.key == null){
			this.key = null;
			this.colour = Colour.BLACK;
			return;
		}
		this.key = node.key;
		this.colour = node.colour;
		this.left = node.left;
		this.right = node.right;
		this.left.parent = this;
		this.right.parent = this;
	}

	public Node<T> search(Interval<T> key) {
		if (this.key == null){
			return null;
		}
		int compare = this.key.compareTo(key);
		if (compare == 0){
			return this;
		}else if (compare < 0){
			return this.left.search(key);
		}else if (compare > 0){
			return this.right.search(key);
		}
		return null;
	}

	public void insert(Node<T> node) {
		// assume node is only a node, not a subtree
		if (this.key == null){
			this.replaceBy(node);
			this.checkProperty();
			return;
		}
		int compare = this.key.compareTo(node.key);
		if (compare < 0){
			this.left.insert(node);
		}else if (compare > 0){
			this.right.insert(node);
		}
	}

	public void checkProperty(){
		Node<T> uncle = this.getUncle();
		if (uncle == null){
			return;
		}

		if (uncle.colour == Colour.RED){
			this.parent.colour = Colour.BLACK;
			this.getUncle().colour = Colour.BLACK;
			this.parent.parent.colour = Colour.RED;
			this.parent.parent.checkProperty();
			return;
		}
		if (this.parent.isLeft()){
			if (this.isLeft()){
				this.parent.colour = Colour.BLACK;
				this.parent.parent.colour = Colour.RED;
				this.parent.parent.rightRotate();
			}else {
				this.parent.leftRotate().left.checkProperty();
			}
		} else{
			if (this.isLeft()){
				this.parent.rightRotate().right.checkProperty();
			} else {
				this.parent.colour = Colour.BLACK;
				this.parent.parent.colour = Colour.RED;
				this.parent.parent.leftRotate();
			}
		}
	}

	public boolean isLeft(){
		if (this.parent.key == null){
			return false;
		}
		return this.parent.left.equals(this);
	}

	public Node<T> leftRotate(){
		Node<T> x = new Node<>();
		x.replaceBy(this);
		Node<T> y = new Node<>();
		y.replaceBy(x.right);
		x.right.replaceBy(y.left);
		y.left.replaceBy(x);
		this.replaceBy(y);
		return this;
	}

	public Node<T> rightRotate(){
		Node<T> x = new Node<>();
		x.replaceBy(this);
		Node<T> y = new Node<>();
		y.replaceBy(x.left);
		x.left.replaceBy(y.right);
		y.right.replaceBy(x);
		this.replaceBy(y);
		return this;
	}

	public Node<T> getUncle(){
		if (this == null || this.key == null){
			return null;
		}
		if (this.parent == null || this.parent.key == null ){
			return null;
		}
		if (this.parent.parent == null || this.parent.parent.key == null){
			return null;
		}
		if (this.parent.equals(this.parent.parent.left)){
			return this.parent.parent.right;
		}else if (this.parent.equals(this.parent.parent.right)){
			return this.parent.parent.left;
		}
		return null;
	}


	// For a pair of intervals i1, i2, we write i1 < i2, if
	//(1)	i1. startTime < i2. startTime, or
	//(2)	i1. startTime = i2. startTime, and i1. endTime < i2.endTime
	public static class Interval<T extends Comparable<T>>{
		public final T startTime;
		public final T endTime;
		public Interval(T startTime, T endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int compareTo(Interval<T> i2){
			Interval<T> i1 = this;
			int startCompare = i1.startTime.compareTo(i2.startTime);
			int endCompare = i1.endTime.compareTo(i2.endTime);
			if (startCompare == 0){
				return endCompare;
			}
			return startCompare;
		}

		public String toString(){
			return "["+startTime+","+endTime+"]";
		}
	}
}