package Striver.interviewQuestions;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    static AtomicInteger count = new AtomicInteger(20);

    public static void main(String[] args) {
        // Simulate two threads
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet(); // Safely increase count
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet(); // Safely increase count
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + count.get()); // Should be 2000
    }
}
