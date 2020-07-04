package acmicpc.basic.part12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam1260 {
    static int N;
    static int M;
    static int V;
    static int[][] map;
    static boolean[] isVisit;

    public static void DFS(int node) {
        isVisit[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i <= N; i++) {
            if (map[node][i] == 1 && !isVisit[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        isVisit[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (map[now][i] == 1 && !isVisit[i]) {
                    queue.add(i);
                    isVisit[i] = true;
                }
            }

            System.out.print(now + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        isVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            map[start][destination] = 1;
            map[destination][start] = 1;
        }

        DFS(V);
        System.out.println();
        for (int i = 1; i <= N; i++) {
            isVisit[i] = false;
        }
        BFS(V);
    }
}