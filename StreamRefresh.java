package Striver.interviewQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRefresh {
    public static void main(String[] args) {

        // 1) print each element
        List<String> prob1 = Arrays.asList("Alice", "Bob", "Charlie");
        prob1.forEach(System.out::println);

        System.out.println("--------------------");

        // 2) filter even numbers
        List<Integer> prob2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer>solution2=prob2
                .stream()
                .filter(a->a%2==0)
                .collect(Collectors.toList());
        System.out.println(solution2);

        System.out.println("--------------------");

       // 3. Find the maximum value in a list using Streams.

        List<Integer> prob3 = Arrays.asList(10, 20, 30, 40);
        int solution3= prob3
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        System.out.println(solution3);

        System.out.println("--------------------");

        // 4. Convert a list of strings to uppercase.

        List<String> prob4 = Arrays.asList("alice", "bob");
       List<String>solution4= prob4
                .stream()
                .map(a->a.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(solution4);

        System.out.println("--------------------");

        // 5. Group strings by their length using groupingBy().
        List<String> prob5 = Arrays.asList("Alice", "Bob", "Charlie");
        Map <Integer,List<String>>solution5=prob5
                .stream()
                .collect(Collectors.groupingBy(a->a.length()));

        System.out.println(solution5);

        System.out.println("--------------------");

        // 6. Find the sum of numbers using reduce().
        List<Integer> prob6 = Arrays.asList(1, 2, 3, 4);
        int solution6=prob6
                .stream()
                .reduce(0,Integer::sum);
        System.out.println(solution6);
        System.out.println("--------------------");


        // 7. Count word occurrences in a list using groupingBy().
        List<String> prob7 = Arrays.asList("apple", "banana", "apple");
       Map<String,Long>solution7= prob7
                .stream()
                .collect(Collectors.groupingBy(a->a,Collectors.counting()));

        System.out.println(solution7);
        System.out.println("--------------------");

        // 8. Concatenate strings using joining().
        List<String> prob8 = Arrays.asList("Java", "is", "awesome");
       String solution8= prob8
                .stream()
                .collect(Collectors.joining("->"));

        System.out.println(solution8);
        System.out.println("--------------------");

        // 10. Find the first non-repeated character in a string.
        String prob10 = "swiss";
       Map<Character,Integer>solution10= prob10
                .chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.summingInt(c->1)));

        System.out.println(solution10);

        for(Map.Entry<Character,Integer>entry: solution10.entrySet()){
            if(entry.getValue()==1){
                System.out.println("First Non repeated character in string: "+entry.getKey());
                break;
            }
        }

        System.out.println("--------------------");

        // 11. Use Stream.distinct() to remove duplicates from a list.
        List<Integer> prob11 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer>solution11=prob11
                .stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(solution11);

        System.out.println("--------------------");

        // 12. Find all elements starting with "A" in a list.
        List<String> prob12 = Arrays.asList("Alice", "Bob", "Annie", "Alex");
        List<String>solution12=prob12
                .stream()
                .filter(a->a.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(solution12);
        System.out.println("--------------------");

        // 13. Sort a list of strings alphabetically and in reverse order.
        List<String> prob13 = Arrays.asList("Charlie", "Alice", "Bob");
        List<String>solution13=prob13
                .stream()
                .sorted()
                .collect(Collectors.toList());

        List<String>solution13reverse=prob13
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(solution13);
        System.out.println(solution13reverse);
        System.out.println("--------------------");


        // 14. Flatten a list of lists using flatMap().
        List<List<Integer>> prob14 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer>solution14=prob14
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(solution14);

        System.out.println("--------------------");

        // 15. Use Collectors.partitioningBy() to separate even and odd numbers.
        List<Integer> prob15 = Arrays.asList(1, 2, 3, 4, 5, 6);
       Map<Boolean,List<Integer>>solution15= prob15
                .stream()
                .collect(Collectors.partitioningBy(a->a%2==0));

        System.out.println(solution15);

        System.out.println("--------------------");

        // 16. Find the second highest number in a list.
        List<Integer> prob16 = Arrays.asList(10, 20, 30, 40, 10, 20, 53, 50, 50);
        long secondLargest=prob16
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondLargest);

        System.out.println("--------------------");

        // 17. Count the frequency of characters in a string using Streams.
        String prob17 = "java";
        Map<Character,Long> solution17=prob17
                .chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));

        System.out.println(solution17);

        System.out.println("--------------------");

        // 18. Generate an infinite Stream of even numbers and limit it to 10 elements.

        List<Integer>prob18=
                Stream
                        .iterate(0,a->a+2)
                        .limit(10)
                        .collect(Collectors.toList());

        System.out.println(prob18);
        System.out.println("--------------------");

        // 19. Check if all elements in a list are greater than a given number.
        List<Integer> prob19 = Arrays.asList(10, 20, 30, 40);
        int number=5;

       boolean solution19= prob19
                .stream()
                .allMatch(a->a>number);

        System.out.println(solution19);

        System.out.println("--------------------");

        // 20. Find the average of a list of numbers.

        List<Integer> prob20 = Arrays.asList(10, 20, 30, 40);
       double solution20= prob20
                .stream()
                .mapToInt(Integer::intValue)
                .average()
               .orElse(0.0);
        System.out.println(solution20);


        System.out.println("--------------------");

        //23. Count occurrences of each word in a sentence.
        String prob23 = "Java is fun and Java is powerful";
       Map<String,Long>solution23= Arrays
                .stream(prob23.split(" "))
                .collect(Collectors.groupingBy(word->word,Collectors.counting()));

        System.out.println(solution23);

        System.out.println("--------------------");
        // 24. Find the longest word in a list.

        List<String> prob24 = Arrays.asList("apple", "banana", "cherry", "date");
        String solution24=prob24
                .stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(solution24);

        System.out.println("--------------------");

        // 25. Merge two lists into a single list using flatMap().
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        List<Integer>solution25=Stream
                .of(list1,list2)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(solution25);

        System.out.println("--------------------");
        // 26. Find the first element in a Stream greater than 10.

        List<Integer> prob26 = Arrays.asList(5, 8, 12, 3, 20);
        int solution26=prob26
                .stream()
                .sorted()
                .filter(a->a>10)
                .findFirst()
                .get();
        System.out.println(solution26);

        System.out.println("--------------------");

//        27. Find the minimum value in a list using Streams.

        List<Integer> prob27 = Arrays.asList(10, 20, 5, 15);
        int solution27=prob27
                .stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();

        System.out.println(solution27);
        System.out.println("--------------------");

        // 29. Find duplicate elements in a list using Streams.

        List<Integer> prob29 = Arrays.asList(1, 2, 3, 4, 5, 2, 3);
        Set<Integer>solution29=prob29
                .stream()
                .filter(n-> Collections.frequency(prob29,n)>1)
                .collect(Collectors.toSet());

        System.out.println(solution29);

        System.out.println("--------------------");


        // 33. Use Stream.skip() and Stream.limit() to extract sublists.

        List<Integer> prob33 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> solution33=prob33
                .stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(solution33);




    }
}

