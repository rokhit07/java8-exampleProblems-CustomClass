package Striver.interviewQuestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class iteratorAndListIteator {
    public static void main(String[] args) {

        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);

        ListIterator itr= list.listIterator();


        while(itr.hasNext()){
            Integer a= (Integer) itr.next();
            if(a.equals(1)){
                itr.set(99);
            }
            System.out.println(a);
        }
        System.out.println("Modified list: " + list); // Shows the updated list

    }
}
