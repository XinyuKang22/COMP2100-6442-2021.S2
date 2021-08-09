package Task3_Singleton;

public interface SimpleQueue<T> {
    public boolean add(T element);
    public String peek();
    public String poll();
}