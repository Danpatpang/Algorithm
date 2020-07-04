package acmicpc.exam.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam14565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        System.out.print((N - A) + " ");
        if (GCP(N, A) != 1) {
            System.out.print(-1);
        } else {
            // 이해 필요
            long x = MultiplicativeInverse(N, A);
            while (x < 0) {
                x += N;
            }
            System.out.print(x);
        }
    }

    public static long GCP(long N, long A) {
        if (N % A == 0) {
            return A;
        } else if (N < A) {
            return GCP(A, N);
        } else {
            return GCP(A, (N % A));
        }
    }

    public static long MultiplicativeInverse(long N, long A) {
        long[] r = {N, A};
        long[] s = {1, 0};
        long[] t = {0, 1};


        while (true) {
            long quotient = r[0] / r[1];
            long remainder = r[0] - (r[1] * quotient);

            if (remainder == 0) {
                return t[1];
            }

            long S = s[0] - (t[0]) * quotient;
            long T = s[1] - (t[1]) * quotient;

            for (int i = 0; i < 2; i++) {
                s[i] = t[i];
            }
            t[0] = S;
            t[1] = T;
            r[0] = r[1];
            r[1] = remainder;
        }
    }
}
