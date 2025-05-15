package time;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class SimpleLogDataFormatting {

    public static void main(String[] args) {

        // 직접 포맷팅된 날짜를 출력해보기
        JapaneseDate japaneseDate = JapaneseDate.now();
        // JapaneseDate japaneseDate = JapanesesDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Gyy年MM月dd日", Locale.JAPAN);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Gyy年MM月dd日",Locale.JAPAN);

        System.out.println("일본식 년월은 : " + japaneseDate.format(formatter)); //TODO 일본식 년월은 : 令和07年05月14日
        //System.out.println()

        // 일본식 특정날짜에 요일 뽑기
        LocalDate date = LocalDate.of(1997,1,28);
        DateTimeFormatter birtyDay = DateTimeFormatter.ofPattern("EEEE", Locale.JAPAN);
        System.out.println("태어난 날의 요일은 : " + date.format(birtyDay)); //TODO태어난 날의 요일은 : 火曜日

        LocalTime start = LocalTime.of(2,30);
        LocalTime end = LocalTime.now();
        Duration duration = Duration.between(start,end);
        System.out.println(duration);
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());

        // 일본식 나이 계산해보기
        LocalDate birth = LocalDate.of(1997,1,28);
        LocalDate today = LocalDate.now();

        Period age = Period.between(birth,today);






    }
}
