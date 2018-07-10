package part3;

import java.util.Scanner;

public class exam11720 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int X = s.nextInt();
        String Y = s.next();
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += (int) (Y.charAt(i) - '0');
//            sum += Integer.parseInt(Y.substring(i, i + 1));
        }
        System.out.println(sum);
    }
}
