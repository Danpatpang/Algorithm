package acmicpc.basic.part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 몇 칸 이동할 것인가가 아닌 몇 종류를 사용할 것인가.
 * 1 종류 => 2 종류 => 3종류
 * 0 종류는 항상 0
 * 이 문제의 알고리즘은 현재 종류 - 1의 종류로 갈 수 있는 방법 + 나의 방법 case
 * 즉 3 종류 일 때 -> 2종류로 가는 방법(자기 사용 x) + 2종류로 가는 방법(자기 n-1번 사용) + ... + 2종류로 가는 방법(자기 1번 사용)
 *
 * 이해하는데 시간 오래걸림...
 * 기존의 문제 방식과 유사하면서 다름...
 * 기존은 각 순차마다 기록했지만 이번은 전체적으로 기록?
 */
public class exam2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] numberOfCases = new int[101][10001];

        int[] coinValue = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coinValue[i] = Integer.parseInt(br.readLine());
            numberOfCases[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - coinValue[i] < 0) {
                    numberOfCases[i][j] = numberOfCases[i - 1][j];
                } else {
                    numberOfCases[i][j] = numberOfCases[i - 1][j] + numberOfCases[i][j - coinValue[i]];
                }
            }
        }

        System.out.println(numberOfCases[n][k]);
    }
}

