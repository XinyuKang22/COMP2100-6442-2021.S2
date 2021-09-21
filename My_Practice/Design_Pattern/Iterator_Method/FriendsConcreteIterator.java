// inner class
class FriendsConcreteIterator implements Iterator {

    private int index;
    private String[] names;


    public FriendsConcreteIterator(String[] names){
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        if (names != null && index < names.length){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()){
            return names[index++];
        }
        return null;
    }
}
