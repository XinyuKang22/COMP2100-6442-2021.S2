package Task2_Observer;

/**
 * Defines what a subject must have
 */
public interface Subject {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObservers();
}
