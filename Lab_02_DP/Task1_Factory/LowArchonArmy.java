package Task1_Factory;

public class LowArchonArmy implements Army{
    int count = 0;

    @Override
    public void add(int n) {
        count = count + n;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void sub(int n) {
        count = count - n;
    }
}
