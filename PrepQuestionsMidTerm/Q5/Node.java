public class Node {
    Integer key;
    Character value;
    Node parent;
    Node left;
    Node right;

    public Node(Integer key, Character value) {
        this.key = key;
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public String DNAGenerator(){
        if (left == null && right == null){
            return "";
        }else if (left == null && right != null){
            return value + right.DNAGenerator();
        }else if (left != null && right == null){
            return value + left.DNAGenerator();
        }else {
            return left.DNAGenerator() + right.DNAGenerator();
        }
    }
}