public class FriendsConcreteCollection implements IterableCollection{

    // dummy example
    private String[] names = {"Friend_1", "Friend_2", "Friend_3"};

    @Override
    public Iterator createIterator() {
        return new FriendsConcreteIterator(names);
    }

    public void addItem(){
        // ...
    }
}
