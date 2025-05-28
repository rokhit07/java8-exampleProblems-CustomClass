package Striver.interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class filterAndsortAndMax{

    public static void main(String[] args) {

        List<Integer>list= Arrays.asList(21,34,11,34,21,41,179,32,46,97,134);
        int maxValue=list
                .stream()
                .filter(a->a%2==0)
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        System.out.println(maxValue);
    }
}
