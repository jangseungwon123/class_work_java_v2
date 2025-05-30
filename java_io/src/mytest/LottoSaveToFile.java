package mytest;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class LottoSaveToFile {

public void LottotextSave (int [] choiceNumbers) {


    try {
//       LottoNumber lottoNumber = new LottoNumber();
        FileOutputStream fos = new FileOutputStream("Lotto_page.txt",true);
//        lottoNumber.makeLottoNumber();
        for (int num : choiceNumbers) {
            fos.write(String.valueOf(num).getBytes());
            fos.write('\t');
        }
        fos.write('\n');

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}


}
