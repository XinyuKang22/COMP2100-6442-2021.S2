package Task2_Observer;

import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {
    /*
       Side note:
       Consider the feedback provided by these tests.
       Originally, I (the maker of your labs) just used assertTrue(), however,
       that did not provide developers with quickly actionable, meaningful feedback.
       Hence the method assertBooleanFeedback() was made.

       That all being said, this method can be improved upon to provide even
       more meaningful feedback. You can experiment with it if you want! :)

       Later in this course and in your careers you will need to write tests yourself.
       Consider when writing them what kind of feedback you would like your tests to provide
       and how you can do that. In this case, without assertBooleanFeedback() you
       would not get any meaningful feedback aside from an assertion error.
     */

    /**
     * The following method attempts to help provide developers better feedback.
     * @param user the user being tested.
     * @param location the location being tested.
     * @param expectedNotificationValue the expected value of the user's notification boolean.
     */
    public void assertBooleanFeedback(User user, Location location, boolean expectedNotificationValue) throws AssertionError {
        System.err.println("Expected notification value of user: " + expectedNotificationValue);
        System.err.println("Actual notification value of user: " + user.isNotifiedOfOutbreak());
        System.err.println("User details: " + user);
        System.err.println("Location details: " + location);
        throw new AssertionError();
    }

    @Test(timeout = 1000)
    public void singleWithinTickTest() {
        Location location = new Location(5453);
        User user = new User(1);

        location.attach(user);
        location.notifyObservers();

        // Check if the user was notified
        try {
            assertTrue(user.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user, location, true);
        }
    }

    @Test(timeout = 1000)
    public void multiWithinTickTest() {
        Location location = new Location(5453);
        User[] users = new User[5];
        for (int i = 0; i < users.length; i++) {
            users[i] = new User(i);
            location.attach(users[i]);
        }

        location.notifyObservers();

        // Check if all users were notified
        for (User user : users) {
            try {
                assertTrue(user.isNotifiedOfOutbreak());
            } catch (AssertionError error) {
                assertBooleanFeedback(user, location, true);
            }
        }
    }

    @Test(timeout = 1000)
    public void justWithinTickTest() {
        Location location = new Location(5453);
        User user = new User(1);

        location.attach(user);
        location.incTicks(4);
        location.notifyObservers();

        // Check if the user was notified
        try {
            assertTrue(user.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user, location, true);
        }

    }

    @Test(timeout = 1000)
    public void justOutsideTickTest() {
        Location location = new Location(5453);
        User user = new User(1);

        location.attach(user);
        location.incTicks(5);
        location.notifyObservers();

        // Check if the user was notified
        try {
            assertFalse(user.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user, location, false);
        }
    }

    @Test(timeout = 1000)
    public void multiTickTest() {
        Location location = new Location(5453);
        User[] outSideTickRange = new User[5];
        User[] withinTickRange = new User[5];

        for (int i = 0; i < outSideTickRange.length; i++) {
            outSideTickRange[i] = new User(i);
            location.attach(outSideTickRange[i]);
        }

        // 5 ticks pass by
        location.incTicks(5);

        for (int i = 0; i < withinTickRange.length; i++) {
            withinTickRange[i] = new User(i + 4);
            location.attach(withinTickRange[i]);
        }

        location.incTicks(2);

        location.notifyObservers();

        // Check if those users outside the tick range were notified
        for (User user : outSideTickRange) {
            try {
                assertFalse(user.isNotifiedOfOutbreak());
            } catch (AssertionError error) {
                assertBooleanFeedback(user, location, false);
            }
        }

        // Check if those users within the tick range were notified
        for (User user : withinTickRange) {
            try {
                assertTrue(user.isNotifiedOfOutbreak());
            } catch (AssertionError error) {
                assertBooleanFeedback(user, location, true);
            }
        }
    }

    @Test(timeout = 1000)
    public void detachNullTest() {
        Location location = new Location(5453);
        User user = new User(1);

        location.attach(user);
        location.detach(null);
        location.notifyObservers();

        // Check if the user was notified
        try {
            assertTrue(user.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user, location, true);
        }
    }

    @Test(timeout = 1000)
    public void detachSingleObserverTest() {
        Location location = new Location(5453);
        User user = new User(1);

        location.attach(user);
        location.detach(user);
        location.notifyObservers();

        // Check if the user was notified
        try {
            assertFalse(user.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user, location, false);
        }
    }

    @Test(timeout = 1000)
    public void detachMultiObserverTest() {
        Location location = new Location(5453);
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);

        location.attach(user1);
        location.attach(user2);
        location.attach(user3);

        location.detach(user1);
        location.detach(user2);
        location.notifyObservers();

        // Check if the user was notified
        try {
            assertTrue(user3.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user3, location, true);
        }

        // Check if the detached users were notified
        try {
            assertFalse(user1.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user1, location, false);
        }

        try {
            assertFalse(user2.isNotifiedOfOutbreak());
        } catch (AssertionError error) {
            assertBooleanFeedback(user2, location, false);
        }
    }
}