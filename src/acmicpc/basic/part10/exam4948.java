package acmicpc.basic.part10;

import java.util.Scanner;

public class exam4948 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int M = s.nextInt();
        while (M != 0) {
            int count = 0;
            test:
            for (int i = M + 1; i <= 2 * M; i++) {
                if (i == 1) {
                    continue test;
                }
                for (int j = 1; j <= Math.sqrt(i); j++) {
                    if (j != 1 && i % j == 0) {
                        continue test;
                    }
                }
                count++;
            }
            System.out.println(count);
            M = s.nextInt();
        }
    }
}
