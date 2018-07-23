package part8;

import java.util.Scanner;

public class exam10250 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        int height, width, guest, YY, XX;
        String[] result = new String[testCase];
        for (int i = 0; i < testCase; i++) {
            height = s.nextInt();
            width = s.nextInt();
            guest = s.nextInt();
            if (guest % height == 0) {
                YY = height;
                XX = guest / height;
            } else {
                YY = guest % height;
                XX = guest / height + 1;
            }
            if (XX < 10) {
                result[i] = "" + YY + 0 + XX;
            } else {
                result[i] = "" + YY + XX;
            }
        }
        for (int i = 0; i < testCase; i++) {
            System.out.println(result[i]);
        }
    }
}
