import java.util.ArrayList;

public class Place implements Subject{
    private String name;
    private ArrayList<Observer> observers;

    public Place(String name){
        this.name = name;
        observers = new ArrayList<Observer>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer obs : this.observers){
            obs.update(this.name + " has a confirm case.");
        }
    }

    public void setCovid(){
        notifyAllObservers();
    }
}
