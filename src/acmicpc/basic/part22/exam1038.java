package acmicpc.basic.part22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1038 {
    static long[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 10가지 숫자로 만들 수 있는 부분집합 수 - 공집합
        result = new long[1023];
        int cnt = 0;

        for (long i = 0; i <= 9876543210L; i++) {
            long temp = i;
            boolean isTrue = true;
            long jumpSize = 1;

            while (temp > 9) {
                long now = temp % 10;
                long before = (temp / 10) % 10;
                jumpSize *= 10;

                if (now < before) {
                    temp /= 10;
                } else {
                    // 필요없는 계산은 생략
                    isTrue = false;
                    i = (((temp / 10) + 1) * jumpSize) - 1;
                    break;
                }
            }

            if (isTrue) {
                result[cnt++] = i;
            }
        }

        int N = Integer.parseInt(br.readLine());
        print(N, cnt);
    }

    // 출력
    public static void print(int N, int cnt) {
        if (N < cnt) {
            System.out.println(result[N]);
        } else {
            System.out.println(-1);
        }
    }
}
