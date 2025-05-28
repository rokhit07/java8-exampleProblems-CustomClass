package Striver.interviewQuestions;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class StreamInterviewQuestions {
    public static void main(String[] args) {

        // Convert Int to String
        IntStream.range(1,4)
                .mapToObj(n->"Id= "+n)
                .forEach(System.out::println);
        System.out.println("---------------------");
        "java"
                .chars()
                .mapToObj(c->(char)c)
                .forEach(System.out::println);
        System.out.println("---------------------");


        // Optional Examples
        System.out.println("Optional Examples: ");

        // 1) Optional empty
        Optional<String>opt1=Optional.of("Rokhit");
        System.out.println(opt1.get());

       /* Optional<String>opt2=Optional.empty();
        System.out.println(opt2.get());*/

        System.out.println("-----------------");

        // 2) ifPresent returns boolean
        Optional<String>op1=Optional.empty();
        System.out.println(op1.isPresent());

        System.out.println("-----------------------");

        // 3) OrElse

        /*Optional<String>o1=Optional.empty();
        System.out.println(o1.orElseThrow(()->new RuntimeException("No value found in ROkhit")));*/

        System.out.println(CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(name -> name + " World")
                .thenAccept(msg -> System.out.println("Message: " + msg)));
    }
}
