package part3;

import java.util.Scanner;

public class exam8393 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int sum = 0;
        for (int i = 1; i <= N ; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
