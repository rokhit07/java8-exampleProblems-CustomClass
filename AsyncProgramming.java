package Striver.interviewQuestions;

import java.util.concurrent.*;

public class AsyncProgramming {
    public static void main(String[] args) {
        /*CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000); // Simulate work
                System.out.println("Task finished!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Main thread keeps running...");
*/


                    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    // Simulate background task
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                    return "Hello from background!";
                });

                future.thenAccept(result -> System.out.println(result));
                System.out.println("Main thread keeps running...");
            }
        }

