package Striver.interviewQuestions;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        Optional<String>op=Optional.of("Rokhit");
        System.out.println(op.get());


        Optional<String>op1=Optional.ofNullable(null);
        if(op1.isPresent()){
            System.out.println(op1.get());
        }
        else {
            System.out.println("NOT AVAILABLE");
        }



    }
}
