package mytest;

import java.util.Random;

// 로또 번호를 생성하는 책임
public class LottoNumber {

    Random random;
    int[] choiceNumbers;

    public LottoNumber() {
        this.random = new Random();
        choiceNumbers = new int[6];
    }

    // 한번에 6개의 정수값을 반환 하는 메서드
    public int[] makeLottoNumber() {

        for(int i = 0; i < choiceNumbers.length; i++) {
            choiceNumbers[i]  = random.nextInt(45) + 1;
            // 이중 for 구문 활용
        }
        showNumbers();
        // for, while
        return choiceNumbers;
    }

    public void showNumbers() {
        for(int n : choiceNumbers) {
            System.out.print(n + "\t");
        }
    }

    // 테스트
    public static void main(String[] args) {
        LottoNumber lottoNumber = new LottoNumber();
        // 번호 생성 완료
        lottoNumber.makeLottoNumber();

        // 출력하기 콘솔에
//        lottoNumber.showNumbers();

    }

}
