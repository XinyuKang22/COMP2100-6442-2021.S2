package Task2_Observer;

public class AttendanceLog {
    final private Observer observer;
    private Integer tick = 0;

    /**
     * Constructor which sets tuple values
     */
    public AttendanceLog(Observer observer) {
        this.observer = observer;
    }

    /**
     * @return observer object
     */
    public Observer getObserver() {
        return observer;
    }

    /**
     * @return current tick value
     */
    public Integer getTick() {
        return tick;
    }

    /**
     * Increments the tick by the given value
     * @param inc number of ticks that have gone by
     * @return current tick for this attendee
     */
    public Integer incTick(int inc) {
        return tick += inc;
    }

    /**
     * Prints out the user details
     * @return string containing the information of the user
     */
    @Override
    public String toString() {
        return "AttendanceLog{" +
                "observer=" + observer +
                ", tick=" + tick +
                '}';
    }
}
