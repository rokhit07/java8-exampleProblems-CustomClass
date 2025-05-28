package Striver.interviewQuestions;

public class enumExample {
    enum Day{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        Day today=Day.SUNDAY;
        if(today== Day.SUNDAY){
            System.out.println("It's a Holiday. WOOHHHH!!!");
        }
        else {
            System.out.println("It's a working day!!!");
        }

    }
}
