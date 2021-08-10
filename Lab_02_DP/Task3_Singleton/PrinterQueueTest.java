package Task3_Singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrinterQueueTest {

    @Test(timeout = 1000)
    public void sameInstanceTest() {
        PrinterQueue pQueue1 = PrinterQueue.getInstance();
        PrinterQueue pQueue2 = PrinterQueue.getInstance();

        assertSame(pQueue1, pQueue2);
    }

    @Test(timeout = 1000)
    public void queuePollTest() {
        PrinterQueue pQueue = PrinterQueue.getInstance();
        String paper1 = "paper1";
        String paper2 = "paper2";
        String paper3 = "paper3";

        pQueue.add(paper1);
        pQueue.add(paper2);
        pQueue.add(paper3);

        assertEquals(paper1, pQueue.poll());
        assertEquals(paper2, pQueue.poll());
        assertEquals(paper3, pQueue.poll());
        assertNull(null, pQueue.poll());
    }

    @Test(timeout = 1000)
    public void sameQueueTest() {
        PrinterQueue pQueue1 = PrinterQueue.getInstance();
        PrinterQueue pQueue2 = PrinterQueue.getInstance();

        String paper1 = "paper1";
        String paper2 = "paper2";

        pQueue1.add(paper1);
        pQueue2.add(paper2);

        assertEquals(paper1, pQueue1.peek());
        assertEquals(paper1, pQueue2.peek());
    }
}
