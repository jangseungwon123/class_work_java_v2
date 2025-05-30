package mytest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class Lotto {




        public static void main(String[] args) {
                Random random = new Random();
                int [] nums = new int[6];
                for (int i = 0; i < nums.length; i++) {
                        nums[i] = random.nextInt((byte)(45)) + 1;
                }
            try {
                FileOutputStream fos = new FileOutputStream("Lotto_page.txt",true);


                for (int num : nums) {
                    fos.write(String.valueOf(num).getBytes());
                    fos.write('\t');
                }
                fos.write('\n');

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


}


