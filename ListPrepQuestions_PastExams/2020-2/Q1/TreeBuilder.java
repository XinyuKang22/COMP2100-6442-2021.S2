
import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

    public RBTree<Integer, List<String>> build(String text) {
        // ########## YOUR CODE STARTS HERE ##########

        RBTree<Integer, List<String>> rbTree = new RBTree<>();
        MyTokenizer myTokenizer = new MyTokenizer(text);
        while (myTokenizer.hasNext()){
            Token token = myTokenizer.current();
            myTokenizer.next();
            if (token.getType() == Token.Type.UPPER_CASE_WORD){
                int key = token.getValue().length();
                Node<Integer, List<String>> node = rbTree.search(key);
                if (node == null){
                    List<String> stringList = new ArrayList<>();
                    stringList.add(token.getValue());
                    rbTree.insert(key, stringList);
                } else {
                    node.data.add(token.getValue());
                }
            }
        }
        return rbTree; // change the return
        // ########## YOUR CODE ENDS HERE ##########
    }




}
