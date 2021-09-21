public class IteratorDemo {

    public static void main(String[] args) {
        FriendsConcreteCollection f = new FriendsConcreteCollection();
        // f.addItem();

        for (Iterator iter = f.createIterator(); iter.hasNext();){
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
