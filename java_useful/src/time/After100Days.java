package time;

import java.time.LocalDate;

public class After100Days {

    public static void main(String[] args) {
        //현 날짜로 부터 100일후 날짜 출력 계산하고 출력
        LocalDate today = LocalDate.now();

        LocalDate after100Days = today.plusDays(100);

        System.out.println("100일 후 : " + after100Days);
    }
}
