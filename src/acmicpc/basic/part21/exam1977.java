package acmicpc.basic.part21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] map = new boolean[10001];

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= (int) Math.sqrt(10000); i++) {
            map[(int) Math.pow(i, 2)] = true;
        }

        int sum = 0;
        int least = 10000;
        for (int i = M; i <= N; i++) {
            if (map[i]) {
                sum += i;
                least = Math.min(least, i);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(least);
        }
    }
}