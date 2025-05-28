package Striver.interviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student>  {

    private int marks;
    private String name;

    Student(String name, int marks){
        this.marks=marks;
        this.name=name;
    }

    @Override
    public int compareTo(Student o) {
        return this.marks-o.marks;
    }
    @Override
    public String toString() {
        return name + " - " + marks;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Alice", 70));
        list.add(new Student("Bob", 90));
        list.add(new Student("Charlie", 80));

        Collections.sort(list);

        for(Student s:list){
            System.out.println(s);
        }
    }


}
