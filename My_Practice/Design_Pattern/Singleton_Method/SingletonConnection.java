public class SingletonConnection {

    private static SingletonConnection instance = null;
    private SingletonConnection(){
        // Do something
    };
    public static SingletonConnection getInstance(){
        if (instance == null){
            instance = new SingletonConnection();
            System.out.println("Instance created!");
        }else {
            System.out.println("Instance has already been created.");
        }
        return instance;
    }
}
