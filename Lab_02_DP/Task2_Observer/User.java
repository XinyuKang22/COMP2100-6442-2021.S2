package Task2_Observer;

/**
 * A user is a typical app user.
 * They inform us of what places they have been in by updating the 'places' ArrayList
 */
public class User implements Observer {
    final private int userId;
    private boolean notifiedOfOutbreak = false;

    /**
     * Constructor which sets the userId.
     * @param userId of the user (to identify them)
     */
    public User(int userId) {
        this.userId = userId;
    }

    /**
     * @return integer representing user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return whether the current user is notified of an outbreak
     */
    public boolean isNotifiedOfOutbreak() {
        return notifiedOfOutbreak;
    }

    /**
     * Updates notification state.
     */
    @Override
    public void update() {
        this.notifiedOfOutbreak = true;
    }

    /**
     * Prints out the user details
     * @return string containing the information of the user
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", notifiedOfOutbreak=" + notifiedOfOutbreak +
                '}';
    }
}
