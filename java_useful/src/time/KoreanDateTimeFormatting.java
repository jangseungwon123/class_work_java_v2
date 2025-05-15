package time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KoreanDateTimeFormatting {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("현 날짜와 시간 : "  + now);

        // 한국식 포맷 정의 (예 : 2025 년 5월 14일 12시 00분)
        //패턴 지정 가능
        // 패턴 설명 : yyyy(4자리 년도) MM (2자리 월), dd (2자리 일), HH(24시간), mm(2자리 분)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        //now.format(formatter);
        // 우리가 정의한 포맷 형태로 현재 시간을 출력
        System.out.println("지금은1 : " + now.format(formatter));
        System.out.println("지금은2 : " + now);

    }

}
