package part4;

import java.util.Scanner;

public class exam1546 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int sum = 0;
        int Max = 0;
        int X;
        for (int i = 0; i < N; i++) {
            X = s.nextInt();
            sum += X;
            if (Max <= X) {
                Max = X;
            }
        }
        System.out.println((float) sum / Max / N * 100);
    }
}
