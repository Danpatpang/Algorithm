package part3;

import java.util.Scanner;

public class exam11721 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        for (int i = 0; i <= str.length() / 10; i++) {
            if (str.length() - 10 * i >= 10) {
                System.out.println(str.substring(i * 10, i * 10 + 10));
            } else {
                System.out.println(str.substring(i * 10, str.length()));
            }
        }
    }
}