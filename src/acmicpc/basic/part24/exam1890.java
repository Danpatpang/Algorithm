package acmicpc.basic.part24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// bfs로 풀 시 메모리 초과
// dfs + dp로 풀어야 할 듯.
public class exam1890 {
    static int[][] map;
    static long[][] dp;
    static int N;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(1, 1));
    }

    public static long DFS(int x, int y) {
        if (x == N && y == N) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 2; i++) {
            int nextX = x + (dx[i] * map[x][y]);
            int nextY = y + (dy[i] * map[x][y]);

            if (nextX > N || nextY > N) {
                continue;
            }
            dp[x][y] += DFS(nextX, nextY);
        }
        return dp[x][y];
    }
}