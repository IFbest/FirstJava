package kh1224;

import java.util.Calendar;

public class EnumWeekExample {
    public static void main(String[] args) {
        Week today = null;//스택 영역

        Calendar cal  = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_WEEK);//일1 에서 토7까지의 숫자를 리턴
        //데이터 중에는 몇 가지로 한정된 값만을 갖는 경우가 있음. 이러한 타입을 열거타입이라고 함

        switch (week){
            case 1:
                today = Week.SUNDAY;//힙영역
                break;
            case 2:
                today = Week.MONDAY;
                break;
            case 3:
                today = Week.TUESDAY;
                break;
            case 4:
                today = Week.WEDNESDAY;
                break;
            case 5:
                today = Week.THURSDAY;
                break;
            case 6:
                today = Week.FRIDAY;
                break;
            case 7:
                today = Week.SATURDAY;
                break;
        }
        System.out.println("오늘 요일: " + today);
        if (today == Week.SUNDAY){
            System.out.println("일요일에는 과제정리를 합니다.");
        }else {
            System.out.println("열심히 자바 공부합니다.");
        }
    }
}
