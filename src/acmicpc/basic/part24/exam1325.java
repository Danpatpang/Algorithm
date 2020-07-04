package acmicpc.basic.part24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam1325 {
    static ArrayList<Integer>[] map;
    static boolean[] isVisit;
    static int[] result;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N + 1];

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        // 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            map[start].add(destination);
        }

        for (int i = 1; i <= N; i++) {
            isVisit = new boolean[N + 1];
            DFS(i);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            count = Math.max(count, result[i]);
        }

        // 배열에서 뽑아오므로 정렬 필요 X
        for (int i = 1; i <= N; i++) {
            if (result[i] == count) {
                System.out.print(i + " ");
            }
        }
    }

    // 각 컴퓨터별 방문 횟수 체크.
    public static void DFS(int start) {
        isVisit[start] = true;

        for (int i : map[start]) {
            if (!isVisit[i]) {
                DFS(i);
                result[i]++;
            }
        }
    }
}