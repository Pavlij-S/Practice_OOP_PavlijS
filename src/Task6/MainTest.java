package Task6;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import Task3.ViewResult;

public class MainTest {
    private final static int N = 1000;

    // Єдине оголошення view з анонімним класом
    private static ViewResult view = new ViewResult(N) {
        @Override
        public void init(double stepX) {
            super.init((int) stepX);
        }

        @Override
        public void ViewHeader() {
            System.out.println("Anonymous Test Results:");
        }
    };

    private static MaxCmd max1 = new MaxCmd(view);
    private static MaxCmd max2 = new MaxCmd(view);
    private static AvgCmd avg1 = new AvgCmd(view);
    private static AvgCmd avg2 = new AvgCmd(view);
    private static MinMaxCmd min1 = new MinMaxCmd(view);
    private static MinMaxCmd min2 = new MinMaxCmd(view);
    private CmdQueue queue = new CmdQueue();

    @BeforeClass
    public static void setUpBeforeClass() {
        view.viewInit();
        assertEquals(5, view.getItems().size()); // виправлено
    }

    @AfterClass
    public static void tearDownAfterClass() {
        assertEquals(max1.getResult(), max2.getResult());
        assertEquals(avg1.getResult(), avg2.getResult(), 0.0001);
        assertEquals(min1.getResultMax(), min2.getResultMax());
        assertEquals(min1.getResultMin(), min2.getResultMin());
    }

    @Test
    public void testMax() {
        max1.execute();
        assertTrue(max1.getResult() > -1);
    }

    @Test
    public void testAvg() {
        avg1.execute();
        assertTrue(avg1.getResult() != 0);
    }

    @Test
    public void testMin() {
        min1.execute();
        assertTrue(min1.getResultMin() > -1);
        assertTrue(min1.getResultMax() > -1);
    }

    @Test
    public void testMaxQueue() {
        queue.put(max2);
        try {
            while (max2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }

    @Test
    public void testAvgQueue() {
        queue.put(avg2);
        try {
            while (avg2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }

    @Test
    public void testMinQueue() {
        queue.put(min2);
        try {
            while (min2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }
}
