package threads;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadPoolTest {

    /**
     * Started 3 threads in a pool of size 2
     * Checking the 3rd one will be enqueued
     */
    @Test
    public void shouldTest() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            System.out.println("t1");
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            System.out.println("t2");
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            System.out.println("t3");
            Thread.sleep(1000);
            return null;
        });

        assertEquals(2, executor.getPoolSize());
        assertEquals(1, executor.getQueue().size());
    }

    /**
     * Started 3 threads in a pool of size 2
     * This time, we waited until all threads process,
     * so the 3rd one will be enqueued, dequeued and processed
     * Checking the 3rd one is not on the queue anymore
     */
    @Test
    public void shouldTest2() throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            System.out.println("t1");
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            System.out.println("t2");
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            System.out.println("t3");
            Thread.sleep(1000);
            return null;
        });

        Thread.sleep(1000);
        assertEquals(2, executor.getPoolSize());
        assertEquals(0, executor.getQueue().size());
    }
}
