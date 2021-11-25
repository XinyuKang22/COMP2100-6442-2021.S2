import parcel.Parcel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ParcelBST extends BinarySearchTree<Parcel> implements Iterable<Parcel>  {

    public ParcelBST(Parcel value, ParcelBST leftNode, ParcelBST rightNode) {
        super(value, leftNode, rightNode);
    }

    public ParcelBST(BinarySearchTree<Parcel> parcelBST) {
        super(parcelBST.value,parcelBST.leftNode,parcelBST.rightNode);
    }

    public ParcelBST(Tree<Parcel> parcelTree) {
        super(parcelTree.value,parcelTree.leftNode,parcelTree.rightNode);
    }

    public ParcelBST(Parcel value) {
        super(value);
    }


    @Override
    public Iterator<Parcel> iterator() {
        return new IteratorPreOrder();
    }

    class IteratorPreOrder implements Iterator<Parcel> {
        // Hint: value, left/right sub-trees can be accessed by:
        //    ParcelBST.this.value    ParcelBST.this.leftNode   ParcelBST.this.rightNode
        // Or equivalently directly:
        //    value   leftNode    rightNode


        // You may add methods and variables here if you wish
        ParcelBST parcelBST = new ParcelBST(value, new ParcelBST(leftNode), new ParcelBST(rightNode));
        ParcelBST currentBST = parcelBST;
        List<Parcel> parcelList = new ArrayList<>();

        public IteratorPreOrder() {
            preorderTreeWalk(parcelBST, parcelList);
            // You may add code here if you wish
        }

        @Override
        public boolean hasNext() {
            // TODO
            // START YOUR CODE
            return !parcelList.isEmpty();
            // END YOUR CODE
        }

        @Override
        public Parcel next() {
            // TODO
            // START YOUR CODE
            if (!parcelList.isEmpty()){
                Parcel p = parcelList.get(0);
                parcelList.remove(0);
                return p;
            }
            return null;
            // END YOUR CODE
        }

        private void preorderTreeWalk(ParcelBST bst,List<Parcel> parcelList) {
            if (bst != null && !bst.isEmpty()){
                parcelList.add(bst.value);
                if (!bst.leftNode.isEmpty()) preorderTreeWalk(new ParcelBST(bst.leftNode), parcelList);
                if (!bst.rightNode.isEmpty()) preorderTreeWalk(new ParcelBST(bst.rightNode), parcelList);
            }
        }


    }
}
