package acmicpc.basic.part24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam10451 {
    static int[] map = new int[1001];
    static boolean[] isVisit = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int countCycle = 0;

            // 입력
            for (int j = 1; j <= N; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }

            // 탐색
            for (int j = 1; j <= N; j++) {
                if (!isVisit[j]) {
                    DFS(j);
                    countCycle++;
                }
            }

            System.out.println(countCycle);

            // 초기화
            Arrays.fill(map, 0);
            Arrays.fill(isVisit, false);
        }
    }

    public static void DFS(int start) {
        if (isVisit[start]) {
            return;
        }
        isVisit[start] = true;
        DFS(map[start]);
    }
}