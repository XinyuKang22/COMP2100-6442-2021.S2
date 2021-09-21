public class Customer implements Observer{
    private String name;
    public Customer(String name){
        this.name = name;
    }
    @Override
    public void update(String msg) {
        System.out.println("Hello "+this.name+", here is a message for you: \n"+msg);
    }
}
