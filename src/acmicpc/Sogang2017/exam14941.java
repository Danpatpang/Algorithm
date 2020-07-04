package acmicpc.Sogang2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// fail
public class exam14941 {
    static boolean[] prime = new boolean[100001];
    static int[][] dp= new int[100001][100001];
    public static void main(String[] args) throws IOException {
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= Math.sqrt(100000); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i + i; j <= 100000; j+= i) {
                prime[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 2차원 dp를 이용해서 해결해야 함. (start, finish)
            int result1 = 0;
            int result2 = 0;
            int count = 0;
            for (int j = a; j <= b; j++) {
                if(!prime[j]){
                    if (count % 2 == 0) {
                        result1 += j;
                    } else {
                        result2 += j;
                    }
                    count++;
                }
            }

            System.out.println(3*result1 - result2);
        }
    }
}
