package acmicpc.basic.part2;

import java.util.Scanner;

public class exam2839 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int X = 0;
        while (true) {
            if (N % 5 == 0) {
                System.out.println(N / 5 + X);
                break;
            } else if (N <= 0) {
                System.out.println("-1");
                break;
            } else {
                N -= 3;
                X++;
            }
        }
    }
}
