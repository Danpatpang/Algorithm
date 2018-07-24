package part8;

import java.util.Scanner;

public class exam6064 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        int M, N, x, y, Max, Min;
        int[] result = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            M = s.nextInt();
            N = s.nextInt();
            x = s.nextInt();
            y = s.nextInt();
            int count = 0;
            if (M < N) {
                int xx = x, yy = x;
                while (yy != y) {
                    count++;
                    yy = (yy + M) % N;
                    if (yy == 0) {
                        yy = N;
                    }
                    if (count > N) {
                        break;
                    }
                }
                if (count > N) {
                    result[i] = -1;
                } else {
                    result[i] = count * M + x;
                }
            } else {
                int xx = y, yy = y;
                while (xx != x) {
                    count++;
                    xx = (xx + N) % M;
                    if (xx == 0) {
                        xx = M;
                    }
                    if (count > M) {
                        break;
                    }
                }
                if (count > M) {
                    result[i] = -1;
                } else {
                    result[i] = count * N + y;
                }
            }
        }
        for (int i = 0; i < testCase; i++) {
            System.out.println(result[i]);
        }
    }
}
