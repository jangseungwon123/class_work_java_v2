package mytest;

// 객체 지향
// 멤버 변수
// 기능 (메서드)
public class LottoTest {
    public static void main(String[] args) {
        LottoNumber lottoNumber = new LottoNumber();
        LottoSaveToFile lottoSaveToFile = new LottoSaveToFile();


        lottoSaveToFile.LottotextSave(lottoNumber.makeLottoNumber());





    }

}
