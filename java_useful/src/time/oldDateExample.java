package time;

import java.util.Calendar;
import java.util.Date;

public class oldDateExample {

    public static void main(String[] args) {

        Date now = new Date();
        System.out.println("현재 시간 : " + now);

        //직접 개발자가 못하게 막아 놓았다.
        //Calendar cal = new Calendar();
        Calendar cal = Calendar.getInstance();
        cal.set(2025, 4, 14); // month는 0부터 시작(5월 = 4 월가 같다.) 가독성을 해침
        System.out.println("설정된 날짜 : " + cal.getTime());

    } // end of main


} // end of class
