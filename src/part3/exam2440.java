package part3;

import java.util.Scanner;

public class exam2440 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 1; i <= N ; i++) {
            for (int j = i; j <= N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
