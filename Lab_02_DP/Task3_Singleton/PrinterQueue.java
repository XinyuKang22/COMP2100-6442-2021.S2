package Task3_Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * A queue (first-in, first-out) which processes printing requests for a printer.
 * Note that there is only ever 1 instance of the queue. Therefore it implements
 *  the singleton design pattern.
 *
 * Just like the other tasks, you may edit this class as
 *  much as you like (create helper methods if you want!) So long as you
 *  genuinely pass the tests.
 */
public class PrinterQueue implements SimpleQueue<String> {
    /*
     * For this task, much of this queue is not implemented. It is up to you to implement
     *  the contents and ensure that the queue follows the singleton design pattern!
     *
     * To help you, an interface has been created of things you need to implement.
     */

    /**
     * Currently we use a list for our queue. Perhaps... there is a better data structure... ;)
     *  Note that you can complete the whole task with a list. However, you can make life easier
     *  by choosing the right data structure as we will find out later in this course.
     */
    private List<String> queue = new ArrayList<>();

    // TODO: store an instance of the printer queue.

    /**
     * Private constructor so it can only be accessed from within the class
     */
    private PrinterQueue() {};

    /**
     * @return new instance if it currently does not exist and current instance if it already exists.
     */
    public static PrinterQueue getInstance() {
        /*
         TODO: implement this method
         Note that you will need to create an instance of PrinterQueue.
         */
        return null;
    }

    /**
     * Adds element to the end of the print queue
     * @return true if successful, false otherwise.
     */
    @Override
    public boolean add(String paper) {
        // TODO: implement this method
        return false;
    }

    /**
     * Returns the element at the front of the queue
     * @return string at the front of queue or returns null if this queue is empty.
     */
    @Override
    public String peek() {
        // TODO: implement this method
        return null;
    }

    /**
     * Removes and returns the element at the front of the queue
     * @return String at the front of the queue or returns null if this queue is empty.
     */
    @Override
    public String poll() {
        // TODO: implement this method
        return null;
    }
}
